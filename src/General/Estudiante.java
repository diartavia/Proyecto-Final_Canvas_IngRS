/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package General;

/**
 *
 * @author jadia
 */
import java.io.Serializable;
import java.util.ArrayList;

public class Estudiante implements Serializable {
    private String id;
    private String nombre;
    private double nota;
    private ArrayList<Materia> Materias;

    public Estudiante(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.nota=0;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota() {
        return nota;
    }

    public ArrayList<Materia> getMaterias() {
        return Materias;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setMaterias(ArrayList<Materia> Materias) {
        this.Materias = Materias;
    }

    
    @Override
    public String toString() {
        return nombre + " (" + id + ")";
    }
}