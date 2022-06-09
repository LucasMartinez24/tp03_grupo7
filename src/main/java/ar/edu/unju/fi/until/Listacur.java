package ar.edu.unju.fi.until;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Curso;

@Component
public class Listacur {
  private List<Curso> lista = new ArrayList<>();
  
  public Listacur(){
    
  }

  public Listacur(List<Curso> lista) {
    this.lista = lista;
  }

  public List<Curso> getLista() {
    return lista;
  }

  public void setLista(List<Curso> lista) {
    this.lista = lista;
  }
}
