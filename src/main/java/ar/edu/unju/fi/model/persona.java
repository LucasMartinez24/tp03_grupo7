package ar.edu.unju.fi.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
public class Persona {
  private String usuario;
  private String email;
  @NotEmpty
  private String contraseña;
  private Boolean estado;
  @NotEmpty
  @Min(value=1000000,message = "El DNI debe ser mayor al millon")
  @Max(value = 999999999, message = "El DNI debe ser menor a 999999999")
  private Long dni;
  public Persona(){
    
  }
  public Boolean getEstado() {
    return estado;
  }
  public void setEstado(Boolean estado) {
    this.estado = estado;
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
