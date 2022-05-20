package ar.edu.unju.fi.tp03_grupo7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.persona;

@Controller
public class UsuarioController {
  @Autowired
  persona list;
  @GetMapping("/formulario")
  public ModelAndView addUsuario(){
    ModelAndView vista= new ModelAndView("Formulario");
    vista.addObject("usuario", list);
    return vista;
  }
}
