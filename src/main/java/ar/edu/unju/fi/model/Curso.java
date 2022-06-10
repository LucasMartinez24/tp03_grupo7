package ar.edu.unju.fi.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import javax.persistence.GenerationType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "Cursos")
public class Curso {
  @Id
  @GeneratedValue
  (strategy=GenerationType.IDENTITY)
  @Column (nullable = true)
  private Long id;
  @Size(min=3, max=100, message="EL nombre debe tener 3 caracteres minimo, maximo 100")
	@NotEmpty(message="El nombre no puede estar vacio")
  private String nombre;
  @Size(min=3, max=100, message="EL docente debe tener 3 caracteres minimo, maximo 100")
	@NotEmpty(message="El docente no puede estar vacio")
  private String docente;
  @Positive(message="La duracion debe ser mayor a 0 semanas")
  private Long duracion;
  @Size(min=0, max=200, message="La descripcion debe tener maximo 100 caracteres")
  private String descripcion;
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private LocalDate fechaInicio;
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private LocalDate fechaFinal;
  @Positive(message="El cupo debe ser positivo")
  private Long cupo;
  @PositiveOrZero(message="El costo debe ser mayor o igual a 0")
  private Double costo;
  public Curso() {
    
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getDocente() {
    return docente;
  }
  public void setDocente(String docente) {
    this.docente = docente;
  }
  public Long getDuracion() {
    return duracion;
  }
  public void setDuracion(Long duracion) {
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
  public Long getCupo() {
    return cupo;
  }
  public void setCupo(Long cupo) {
    this.cupo = cupo;
  }
  public Double getCosto() {
    return costo;
  }
  public void setCosto(Double costo) {
    this.costo = costo;
  }

  public Curso(String nombre, Long id, String docente, Long duracion, String descripcion, LocalDate fechaInicio,
      LocalDate fechaFinal, Long cupo, Double costo) {
    this.nombre = nombre;
    this.id= id;
    this.docente = docente;
    this.duracion = duracion;
    this.descripcion = descripcion;
    this.fechaInicio = fechaInicio;
    this.fechaFinal = fechaFinal;
    this.cupo = cupo;
    this.costo = costo;
  }
}
