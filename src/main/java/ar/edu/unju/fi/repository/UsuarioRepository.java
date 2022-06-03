package ar.edu.unju.fi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Persona;

@Repository
public interface UsuarioRepository extends CrudRepository<Persona,Integer>{
  
}
