package ar.edu.unju.fi.until;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Persona;

@Component
public class Lista {
  private List<Persona> lista = new ArrayList<>();
  
  public Lista(){
    
  }

  public Lista(List<Persona> lista) {
    this.lista = lista;
  }

  public List<Persona> getLista() {
    return lista;
  }

  public void setLista(List<Persona> lista) {
    this.lista = lista;
  }
}
