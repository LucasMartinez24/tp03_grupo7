package ar.edu.unju.fi.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;


@Entity
@Component
@Table(name = "usuarios")
public class Persona {
  @Id
  @NotEmpty
  @Min(value=1000000,message = "El DNI debe ser mayor al millon")
  @Max(value = 999999999, message = "El DNI debe ser menor a 999999999")
  private Long dni;
  public Persona(
      @NotEmpty @Min(value = 1000000, message = "El DNI debe ser mayor al millon") @Max(value = 999999999, message = "El DNI debe ser menor a 999999999") Long dni,
      String usuario, String email, String contraseña, Boolean estado) {
        super();
    this.dni = dni;
    this.usuario = usuario;
    this.email = email;
    this.contraseña = contraseña;
    this.estado = estado;
  }
  @Column(name = "nombre")
  private String usuario;
  @Column(name = "email")
  private String email;
  @Column(name = "contraseña")
  private String contraseña;
  @Column(name = "estado")
  private Boolean estado;
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
