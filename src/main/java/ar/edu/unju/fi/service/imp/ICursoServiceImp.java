package ar.edu.unju.fi.service.imp;

import ar.edu.unju.fi.controller.CursoController;
import ar.edu.unju.fi.model.Curso;
import ar.edu.unju.fi.repository.CursoRepository;
import ar.edu.unju.fi.service.ICursoService;
import ar.edu.unju.fi.until.Listacur;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ICursoServiceImp implements ICursoService{
  private static final Log LUCAS = LogFactory.getLog(CursoController.class);
	
	@Autowired
	Listacur list;
	@Autowired
	CursoRepository cursoRepository;

	@Override
	public void guardarCurso( Curso curso){
		curso.setEstado(true);
		cursoRepository.save(curso);
	}

	@Override
	public void eliminarCurso(Long id) throws Exception{
		Curso auxiliar =new Curso();
		auxiliar=buscarCurso(id);
		cursoRepository.delete(auxiliar);	
	}

	@Override
	public void modificarCurso(Curso curso) {
		cursoRepository.save(curso);
	}

	@Override
	public List<Curso> listarCursos() {
		LUCAS.info("ingresando al metodo mostrar");
		List<Curso> auxiliar = new ArrayList<>();
		List<Curso> auxiliar2 = new ArrayList<>();
		auxiliar=(List<Curso>) cursoRepository.findAll();
		for (int i = 0; i < auxiliar.size(); i++) {			
			if(auxiliar.get(i).getEstado()==true) {
				auxiliar2.add(auxiliar.get(i));
			}          
    }		
		return auxiliar2;
	}

	

	@Override
	public Curso buscarCurso(Long id) throws Exception {
		Curso cursoEncontrado = new Curso();
		cursoEncontrado=cursoRepository.findById(id).orElseThrow(()->new Exception("curso no encontrado"));
		return cursoEncontrado;
	}

}
