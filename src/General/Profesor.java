package General;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Profesor {
    private String id, nombre, Correo, Contra;
    private ArrayList<Materia> Materias;

    public Profesor(String id, String nombre, String Correo, String Contra) {
        this.id = id;
        this.nombre = nombre;
        this.Correo = Correo;
        this.Contra = Contra;
        this.Materias = new ArrayList<>();
    }

    public Profesor(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.Materias = new ArrayList<>();
    }
    
    
    
    //gets y sets

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContra() {
        return Contra;
    }

    public void setContra(String Contra) {
        this.Contra = Contra;
    }

    public ArrayList<Materia> getMaterias() {
        return Materias;
    }

    public void setMaterias(ArrayList<Materia> Materias) {
        this.Materias = Materias;
    }
    
}
