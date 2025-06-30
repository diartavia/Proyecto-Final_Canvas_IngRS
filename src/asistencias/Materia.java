/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asistencias;

/**
 *
 * @author jadia
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Materia implements Serializable {
    private String id;
    private String nombre;
    private List<Estudiante> estudiantes;

    public Materia(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<Estudiante> getEstudiantes() { return estudiantes; }

    public void agregarEstudiante(Estudiante e) {
        if (!estudiantes.contains(e)) {
            estudiantes.add(e);
        }
    }

    public void eliminarEstudiante(Estudiante e) {
        estudiantes.remove(e);
    }

    @Override
    public String toString() {
        return nombre + " (" + id + ")";
    }
}