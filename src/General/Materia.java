package General;

import CursoProfesor.Asignacion;
import General.Estudiante;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Materia implements Serializable {
    private String id, nombre, carreras, horario, grupo, id_profesor;
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Asignacion> Asignaciones;
    

    public Materia(String id, String nombre, String carreras, String horario, String grupo, String id_profesor) {
        this.id = id;
        this.nombre = nombre;
        this.carreras = carreras;
        this.horario = horario;
        this.grupo = grupo;
        this.id_profesor = id_profesor;
        this.estudiantes = new ArrayList<>();
        
    }

    public ArrayList<Asignacion> getAsignaciones() {
        return Asignaciones;
    }

    public void agregarAsignaciones(Asignacion asigna) {
        Date fecha = new Date();
        Grupo grupo = new Grupo("1", "Grupo 1", "");
        //Asignacion a = new Asignacion("Tarea 1","Descripcion de prueba",fecha,fecha,false,1.3,1, grupo, this);
        //Asignaciones.add(a);
        if (!Asignaciones.contains(asigna)) {
            Asignaciones.add(asigna);
        }
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public ArrayList<Estudiante> getEstudiantes() { return estudiantes; }

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