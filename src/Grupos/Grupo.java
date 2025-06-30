/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupos;

/**
 *
 * @author jadia
 */
import General.Estudiante;
import General.Estudiante;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Grupo implements Serializable {
    private String id;
    private String nombre;
    private String idMateria; // Para relacionar el grupo con la materia
    private List<Estudiante> estudiantes;

    public Grupo(String id, String nombre, String idMateria) {
        this.id = id;
        this.nombre = nombre;
        this.idMateria = idMateria;
        this.estudiantes = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getIdMateria() { return idMateria; }
    public void setIdMateria(String idMateria) { this.idMateria = idMateria; }

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