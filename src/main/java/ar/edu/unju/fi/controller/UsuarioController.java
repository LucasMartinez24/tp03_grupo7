package ar.edu.unju.fi.controller;


import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Persona;
import ar.edu.unju.fi.service.IUsuarioService;
import ar.edu.unju.fi.until.Lista;

@Controller
public class UsuarioController {
  private static final Log LUCAS=LogFactory.getLog(UsuarioController.class);

  @Autowired
  Persona listaPersona;
  @Autowired
  Lista list;
  @Autowired
  IUsuarioService usuarioService;

  @GetMapping("/formulario")
  public ModelAndView addUsuario(){
    ModelAndView vista= new ModelAndView();
    vista.addObject("formulario");
    vista.addObject("usuario", listaPersona);
    vista.addObject("band","false");
    return vista;
  }
  @PostMapping("/formulario")
  public String saveUser(@Valid @ModelAttribute("usuario") Persona user, BindingResult resultado, Model model){
    if (resultado.hasErrors()) {
      LUCAS.fatal("Error de validación");
      model.addAttribute("usuario", user);
      return "formulario";
    }
    try {
      usuarioService.guardarUsuario(user);
    } catch (Exception e) {
      model.addAttribute("formUsuarioErrorMessage", e.getMessage());
			model.addAttribute("unUsuario", user);
			LUCAS.error("saliendo del metodo");
			return "formulario";	
    }
    model.addAttribute("formUsuarioErrorMessage", "Usuario guardado correctamente");
		model.addAttribute("unUsuario", user);			
		return "usuarios";
  }
  @GetMapping("/lista")
  public ModelAndView getlista(){
    ModelAndView vista = new ModelAndView("Listado");
    vista.addObject("listaUsuario", list.getLista());
    return vista;
  }
  @GetMapping("/editarUsuario/{dni}")
  public ModelAndView edituser(@PathVariable(name="dni") Long dni){
    Persona usuarioencontrado = new Persona();
    for(int i=0;i<list.getLista().size();i++){
      if(list.getLista().get(i).getDni().equals(dni)){
        usuarioencontrado = list.getLista().get(i);
      }
    }
    LUCAS.fatal("Error de entrada"+usuarioencontrado.getDni());
    ModelAndView encontrado = new ModelAndView("formulario");
    encontrado.addObject("usuario", usuarioencontrado);
    encontrado.addObject("band","true");
    return encontrado;
  }
  @PostMapping("/modificarusuario")
  public String modUser(@Valid @ModelAttribute("usuario") Persona user, BindingResult resultado,Model model){
    LUCAS.info("Ingresando al metodo guardar usuario: "+ user.getDni());
    if (resultado.hasErrors()) {
      LUCAS.fatal("Error de validacion");
      model.addAttribute("usuario", user);
    }
    for (int i=0;i<list.getLista().size();i++) {
      if (list.getLista().get(i).getDni().equals(user.getDni())) {
        list.getLista().set(i, user);
      } 
    }
    LUCAS.error("Tamaño del listado: "+ list.getLista().size());
    return "redirect:/Listado";
  }
}
