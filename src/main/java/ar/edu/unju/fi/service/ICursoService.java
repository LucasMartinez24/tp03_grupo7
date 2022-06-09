package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Curso;

public interface ICursoService {
  public void guardarCurso( Curso curso);
	public void eliminarCurso(Long id) throws Exception;
	public void modificarCurso(Curso curso);
	public List<Curso> listarCursos(); 
	public Curso buscarCurso(Long id) throws Exception; 
}
