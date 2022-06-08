package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Persona;

@Service
public interface IUsuarioService {
  public void guardarUsuario( Persona usuario);
	public void eliminarUsuario(Long id) throws Exception;
	public void modificarUsuario(Persona usuario);
	public List<Persona> listarUsuarios(); 
	public Persona buscarUsuario(Long id) throws Exception; 
}
