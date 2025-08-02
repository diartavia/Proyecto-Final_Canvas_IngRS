package General;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Modulo implements Serializable {
    private String titulo;

    // Cada módulo puede tener múltiples objetos (textos, links, etc.)
    private List<ObjetoModulo> objetos;

    public Modulo(String titulo) {
        this.titulo = titulo;
        this.objetos = new ArrayList<>();
    }

    public void agregarObjeto(ObjetoModulo objeto) {
        objetos.add(objeto);
    }
    
    // Método que devuelve los elementos del módulo (antes `getObjetos`)
    public List<ObjetoModulo> getElementos() {
        return objetos;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
