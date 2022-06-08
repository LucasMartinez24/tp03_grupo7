package ar.edu.unju.fi.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Curso {
  private String nombre;
  @Id
  @GeneratedValue
  (strategy=GenerationType.IDENTITY)
  private Long idCurso;
  private String docente;
  private Integer duracion;
  @Column(name = "d")
  private String descripcion;
  private LocalDate fechaInicio;
  private LocalDate fechaFinal;
  private Integer cupo;
  private Double costo;
  private Integer valoracion;
  private Boolean estado;
  public Curso() {
    
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public Long getIdCurso() {
    return idCurso;
  }
  public void setIdCurso(Long idCurso) {
    this.idCurso = idCurso;
  }
  public String getDocente() {
    return docente;
  }
  public void setDocente(String docente) {
    this.docente = docente;
  }
  public Integer getDuracion() {
    return duracion;
  }
  public void setDuracion(Integer duracion) {
    this.duracion = duracion;
  }
  public String getDescripcion() {
    return descripcion;
  }
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
  public LocalDate getFechaInicio() {
    return fechaInicio;
  }
  public void setFechaInicio(LocalDate fechaInicio) {
    this.fechaInicio = fechaInicio;
  }
  public LocalDate getFechaFinal() {
    return fechaFinal;
  }
  public void setFechaFinal(LocalDate fechaFinal) {
    this.fechaFinal = fechaFinal;
  }
  public Integer getCupo() {
    return cupo;
  }
  public void setCupo(Integer cupo) {
    this.cupo = cupo;
  }
  public Double getCosto() {
    return costo;
  }
  public void setCosto(Double costo) {
    this.costo = costo;
  }
  public Integer getValoracion() {
    return valoracion;
  }
  public void setValoracion(Integer valoracion) {
    this.valoracion = valoracion;
  }
  public Boolean getEstado() {
    return estado;
  }
  public void setEstado(Boolean estado) {
    this.estado = estado;
  }
}
