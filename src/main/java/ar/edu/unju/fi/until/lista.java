package ar.edu.unju.fi.until;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.persona;

@Component
public class lista {
  private List<persona> lista = new ArrayList<>();
  
  public lista(){
    
  }

  public lista(List<persona> lista) {
    this.lista = lista;
  }

  public List<persona> getLista() {
    return lista;
  }

  public void setLista(List<persona> lista) {
    this.lista = lista;
  }
}
