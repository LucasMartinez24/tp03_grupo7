package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Persona {
  private String usuario;
  private String contraseña;
  public Persona(){
    
  }
  public Persona(String usuario, String contraseña) {
    this.usuario = usuario;
    this.contraseña = contraseña;
  }
  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public void setContraseña(String contraseña) {
    this.contraseña = contraseña;
  }
  public String getContraseña() {
    return contraseña;
  }
}
