package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Persona;
import ar.edu.unju.fi.until.Lista;

@Controller
public class UsuarioController {
  @Autowired
  Persona listaPersona;
  @Autowired
  Lista list;

  @GetMapping("/formulario")
  public ModelAndView addUsuario(){
    ModelAndView vista= new ModelAndView();
    vista.addObject("formulario");
    vista.addObject("usuario", listaPersona);
    return vista;
  }
  @PostMapping("/formulario")
  public String saveUser(@ModelAttribute("usuario") Persona user){
    list.getLista().add(user);
    System.out.println("Tamaño Lista: " + list.getLista().size());
    return "redirect:/formulario";
  }
}
