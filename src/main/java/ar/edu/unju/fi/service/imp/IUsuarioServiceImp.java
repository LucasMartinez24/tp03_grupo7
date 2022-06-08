package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.controller.UsuarioController;
import ar.edu.unju.fi.model.Persona;
import ar.edu.unju.fi.repository.UsuarioRepository;
import ar.edu.unju.fi.until.Lista;
import ar.edu.unju.fi.service.IUsuarioService;

@Service
public class IUsuarioServiceImp implements IUsuarioService{
  private static final Log LUCAS = LogFactory.getLog(UsuarioController.class);
	
	@Autowired
	Lista list;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Override
	public void guardarUsuario(Persona usuario) {
		usuario.setEstado(true);
		usuarioRepository.save(usuario);
	}

	@Override
	public void eliminarUsuario(Long id) throws Exception{
		Persona auxiliar =new Persona();
		auxiliar=buscarUsuario(id);
		usuarioRepository.delete(auxiliar);	
	}

	@Override
	public void modificarUsuario(Persona usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public List<Persona> listarUsuarios() {
		LUCAS.info("ingresando al metodo mostrar");
		List<Persona> auxiliar = new ArrayList<>();
		List<Persona> auxiliar2 = new ArrayList<>();
		auxiliar=(List<Persona>) usuarioRepository.findAll();
		for (int i = 0; i < auxiliar.size(); i++) {			
			if (auxiliar.get(i).getEstado().equals(true)) {		
				auxiliar2.add(auxiliar.get(i));		
			}            
    }		
		return auxiliar2;
	}

	

	@Override
	public Persona buscarUsuario(Long id) throws Exception {
		Persona usuarioEncontrado = new Persona();
		usuarioEncontrado=usuarioRepository.findById(id).orElseThrow(()->new Exception("usuario no encontrado"));
		return usuarioEncontrado;
	}
}
