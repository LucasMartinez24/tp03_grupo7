package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Persona {
  private String usuario;
  private String email;
  private String contraseña;
  private Long dni;
  public Persona(){
    
  }
  public Long getDni() {
    return dni;
  }
  public void setDni(Long dni) {
    this.dni = dni;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public Persona(String usuario, String contraseña, String email, Long dni) {
    this.usuario = usuario;
    this.contraseña = contraseña;
    this.email = email;
    this.dni = dni;
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
