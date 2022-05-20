package ar.edu.unju.fi.tp03_grupo7;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.persona;
import ar.edu.unju.fi.until.lista;

@Controller
public class UsuarioController {
  @GetMapping("/formulario")
  public ModelAndView addUsuario(){
    persona list = new persona();
    ModelAndView vista= new ModelAndView();
    vista.addObject("formulario");
    vista.addObject("usuario", list);
    return vista;
  }
  @PostMapping("/formulario")
  public String saveUser(@ModelAttribute("usuario") persona user){
    lista list = new lista();
    list.getLista().add(user);
    System.out.println("Tamaño Lista: " + list.getLista().size());
    return "redirect:/formulario";
  }
}
