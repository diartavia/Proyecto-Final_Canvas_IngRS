package CursoProfesor;

import Grupos.Grupo;
import General.*;
import java.util.ArrayList;

public class Calificaciones {
    
    //En esta seccion se va a trabajar la parte de asignarle las notas a cada estudiante
    
    Grupo grupoactual; //para saber a que grupo dar calificaciones
    Asignacion asignacion;
    Estudiante estudiante;  
    ArrayList<Asignacion> asignaciones;
    ArrayList<Estudiante> ArrayListEstudiantes;
    JCalificacionesMateria JPanelCalificaciones;

    public Calificaciones(Grupo grupoactual, Asignacion asignacion, Estudiante estudiante, ArrayList estudiantes) {
        this.grupoactual = grupoactual;
        this.asignacion = asignacion;
        this.estudiante = estudiante;
        this.asignaciones = new ArrayList<>();
        this.ArrayListEstudiantes = estudiantes;
        JPanelCalificaciones = new JCalificacionesMateria(this);
    }

    public Calificaciones(Asignacion asignacion, Estudiante estudiante, ArrayList estudiantes) {
        this.asignacion = asignacion;
        this.estudiante = estudiante;
        this.asignaciones = new ArrayList<>();
        this.ArrayListEstudiantes = estudiantes;
        JPanelCalificaciones = new JCalificacionesMateria(this);
    }
    
    //metodos
    
    public ArrayList<Asignacion> getNotas(String id_estudiante){
        for (int i = 0; i < 10; i++) {
            if (this.ArrayListEstudiantes.get(i).getId().equals(id_estudiante)) {
                this.ArrayListEstudiantes.get(i); //crear metodo en estudiante para mostrar 
                return asignaciones;
            } 
        }
        return null;
    }
    
    //Gets y sets

    public Grupo getGrupoactual() {
        return grupoactual;
    }

    public void setGrupoactual(Grupo grupoactual) {
        this.grupoactual = grupoactual;
    }

    public Asignacion getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(Asignacion asignacion) {
        this.asignacion = asignacion;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public ArrayList getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(ArrayList asignaciones) {
        this.asignaciones = asignaciones;
    }
    
}
