package ar.edu.unju.fi.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Persona;
import ar.edu.unju.fi.until.Lista;

@Controller
public class UsuarioController {
  private static final Log LUCAS=LogFactory.getLog(UsuarioController.class);

  @Autowired
  Persona listaPersona;
  @Autowired
  Lista list;

  @GetMapping("/formulario")
  public ModelAndView addUsuario(){
    ModelAndView vista= new ModelAndView();
    vista.addObject("formulario");
    vista.addObject("usuario", listaPersona);
    vista.addObject("band","false");
    return vista;
  }
  @PostMapping("/formulario")
  public String saveUser(@ModelAttribute("usuario") Persona user){
    list.getLista().add(user);
    System.out.println("Tamaño Lista: " + list.getLista().size());
    return "redirect:/formulario";
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
}
