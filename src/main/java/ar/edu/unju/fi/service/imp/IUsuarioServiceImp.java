package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.controller.UsuarioController;
import ar.edu.unju.fi.model.Persona;
import ar.edu.unju.fi.until.Lista;
import ar.edu.unju.fi.service.IUsuarioService;

@Service
public class IUsuarioServiceImp implements IUsuarioService{
  private static final Log LUCAS = LogFactory.getLog(UsuarioController.class);
	
	@Autowired
	Lista list;
	
	@Override
	public void guardarUsuario(Persona usuario) {
		usuario.setEstado(true);
		list.getLista().add(usuario);
	}

	@Override
	public void eliminarUsuario(Long id) {
		
		for (int i = 0; i < list.getLista().size(); i++) {			
			if (list.getLista().get(i).getDni().equals(id)) {				
				list.getLista().get(i).setEstado(false);		
			}            
        }		
	}

	@Override
	public void modificarUsuario(Persona usuario) {
		LUCAS.error("dni");
		for (int i = 0; i < list.getLista().size(); i++) {			
			if (list.getLista().get(i).getDni().equals(usuario.getDni())) {
				LUCAS.error("encontrando");
				list.getLista().set(i, usuario);			
			}            
        }
	}

	@Override
	public List<Persona> listarUsuarios() {
		List<Persona> auxiliar = new ArrayList<>();
		LUCAS.info("ingresando al metodo");
		for (int i = 0; i < list.getLista().size(); i++) {
			LUCAS.error("recorriendo "+list.getLista().get(i).getDni());
			
			if (list.getLista().get(i).getEstado()==true) {
				//GUSTAVO.error("encontrando: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				auxiliar.add(list.getLista().get(i));		
			}            
        }
		return auxiliar;
	}

	

	@Override
	public Persona buscarUsuario(Long id) {
		Persona usuarioEncontrado = new Persona();
		for (int i = 0; i < list.getLista().size(); i++) {
			
			if (list.getLista().get(i).getDni().equals(id)) {
				usuarioEncontrado = list.getLista().get(i);		
			}            
        }
		return usuarioEncontrado;
	}
}
