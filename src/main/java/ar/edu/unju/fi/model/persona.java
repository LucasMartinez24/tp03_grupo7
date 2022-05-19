package ar.edu.unju.fi.model;

public class persona {
  private String Nombre;
  private String Apellido;
  private String email;
  private String contraseña;
  public persona(String nombre, String apellido, String email, String contraseña) {
    Nombre = nombre;
    Apellido = apellido;
    this.email = email;
    this.contraseña = contraseña;
  }
  public void setNombre(String nombre) {
    Nombre = nombre;
  }
  public String getNombre() {
    return Nombre;
  }
  public void setApellido(String apellido) {
    Apellido = apellido;
  }
  public String getApellido() {
    return Apellido;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getEmail() {
    return email;
  }
  public void setContraseña(String contraseña) {
    this.contraseña = contraseña;
  }
  public String getContraseña() {
    return contraseña;
  }
}
