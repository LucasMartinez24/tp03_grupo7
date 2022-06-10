package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ar.edu.unju.fi.model.Curso;
import ar.edu.unju.fi.service.ICursoService;
import ar.edu.unju.fi.until.Listacur;

@Controller
public class CursoController {
  private static final Log LUCAS=LogFactory.getLog(UsuarioController.class);

  @Autowired
  Curso nuevoCurso;
  
  @Autowired
  Listacur list;
  
  @Autowired
  ICursoService cursoService;

  @GetMapping("/formulariocursos")
  public ModelAndView addCursos(){
    ModelAndView vista= new ModelAndView("formulariocursos");
    vista.addObject("curso", nuevoCurso);
    vista.addObject("editMode",false);
    return vista;
  }
  @PostMapping("/formulariocursos")
  public String saveUser(@Valid @ModelAttribute("curso") Curso curso, BindingResult resultado, Model model){
    LUCAS.info(curso.getDocente() + resultado.getFieldError());
    if (resultado.hasErrors()) {
      LUCAS.fatal("Error de validación en guardar curso");
      model.addAttribute("curso", curso);
      return "formulariocursos";
    }
    try {
      cursoService.guardarCurso(curso);
    } catch (Exception e) {
      model.addAttribute("formUsuarioErrorMessage", e.getMessage());
			model.addAttribute("unCurso", curso);
			LUCAS.error("saliendo del metodo");
			return "formulariocursos";	
    }
    model.addAttribute("formUsuarioErrorMessage", "curso guardado correctamente");
		model.addAttribute("unCurso", curso);			
		return "formulariocursos";
  }
  @GetMapping("/listacursos")
  public ModelAndView getlista(){
    ModelAndView vista = new ModelAndView("Listadocur");
    vista.addObject("listaCursos", cursoService.listarCursos());
    LUCAS.info("Ingresando al metodo listar cursos");
    return vista;
  }
  @GetMapping("/editarCurso/{id}")
  public ModelAndView edituser(@PathVariable(name="id") Long id) throws Exception{
    Curso cursoencontrado = new Curso();
    cursoencontrado=cursoService.buscarCurso(id);    
    ModelAndView encontrado = new ModelAndView("formulariocursos");
    encontrado.addObject("curso", cursoencontrado);
    LUCAS.fatal("Saliendo del metodo encontrado curso");
    encontrado.addObject("editMode",true);
    return encontrado;
  }
  @PostMapping("/modificarcursos")
  public ModelAndView modUser(@ModelAttribute("curso") Curso curso){
    cursoService.modificarCurso(curso);;
    ModelAndView vista = new ModelAndView("Listadocur");
    vista.addObject("listaCursos", cursoService.listarCursos());
    vista.addObject("formUsuarioErrorMessage","curso Guardado Correctamente");
    return vista;
  }
  @GetMapping("/eliminarcurso/{id}")
	public String eliminar(@PathVariable Long id, Model model) {	
		try {
		cursoService.eliminarCurso(id);
		}catch(Exception e) {
			LUCAS.error("encontrando curso");
			model.addAttribute("formUsuarioErrorMessage", e.getMessage());
			return "redirect:/formulariocursos";			
		}
		return "redirect:/listacursos";
	}
}
