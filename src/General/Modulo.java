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

    public List<ObjetoModulo> getObjetos() {
        return objetos;
    }

    //Esto permite que tanto el profesor como el estudiante accedan a los mismos módulos del curso.
    private List<Modulo> modulos = new ArrayList<>();

    public void agregarModulo(Modulo modulo) {
        modulos.add(modulo);
    }

    public List<Modulo> getModulos() {
        return modulos;
    }
    // Getters y Setters normales

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
}

