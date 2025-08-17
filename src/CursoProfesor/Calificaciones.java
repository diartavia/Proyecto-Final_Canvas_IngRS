package CursoProfesor;

import CursoEstudiante.JCalificacionesMateria;
import General.Grupo;
import General.*;
import java.util.ArrayList;

public class Calificaciones {
    /**
     *      -- Nota Developer 1
     *   En esta seccion se va a trabajar la parte de asignarle las notas a cada estudiante
     */
    Grupo grupoactual; // Para saber a qué grupo se le van a dar las calificaciones
    Asignacion asignacion; // Representa una asignación específica (tarea, examen, etc.)
    Estudiante estudiante;  // Representa a un estudiante en particular
    ArrayList<Asignacion> asignaciones; // Lista de asignaciones (pueden ser varias tareas)
    ArrayList<Estudiante> ArrayListEstudiantes; // Lista de estudiantes asociados al grupo
    JCalificacionesMateria JPanelCalificaciones; // Panel gráfico para mostrar las calificaciones

    // Constructor con grupo, asignación, estudiante y lista de estudiantes
    public Calificaciones(Grupo grupoactual, Asignacion asignacion, Estudiante estudiante, ArrayList estudiantes) {
        this.grupoactual = grupoactual; // Se asigna el grupo actual
        this.asignacion = asignacion; // Se asigna la asignación
        this.estudiante = estudiante; // Se asigna el estudiante
        this.asignaciones = new ArrayList<>(); // Se inicializa la lista de asignaciones vacía
        this.ArrayListEstudiantes = estudiantes; // Se asigna la lista de estudiantes recibida
        JPanelCalificaciones = new JCalificacionesMateria(this); // Se crea el panel de calificaciones
    }

    // Constructor sin grupo, pero con asignación, estudiante y lista de estudiantes
    public Calificaciones(Asignacion asignacion, Estudiante estudiante, ArrayList estudiantes) {
        this.asignacion = asignacion; // Se asigna la asignación
        this.estudiante = estudiante; // Se asigna el estudiante
        this.asignaciones = new ArrayList<>(); // Se inicializa la lista de asignaciones vacía
        this.ArrayListEstudiantes = estudiantes; // Se asigna la lista de estudiantes recibida
        JPanelCalificaciones = new JCalificacionesMateria(this); // Se crea el panel de calificaciones
    }

    // Método para obtener notas de un estudiante por su ID
    public ArrayList<Asignacion> getNotas(String id_estudiante){
        for (int i = 0; i < 10; i++) { // Se recorre hasta 10 estudiantes
            if (this.ArrayListEstudiantes.get(i).getId().equals(id_estudiante)) { // Si el ID coincide
                this.ArrayListEstudiantes.get(i); // Aquí se debería mostrar o procesar el estudiante
                return asignaciones; // Devuelve la lista de asignaciones asociadas
            }
        }
        return null; // Si no se encuentra, devuelve null
    }


    /// Métodos Getters y Setters
    public Grupo getGrupoactual() {
        return grupoactual; // Devuelve el grupo actual
    }

    public void setGrupoactual(Grupo grupoactual) {
        this.grupoactual = grupoactual; // Asigna el grupo actual
    }

    public Asignacion getAsignacion() {
        return asignacion; // Devuelve la asignación
    }

    public void setAsignacion(Asignacion asignacion) {
        this.asignacion = asignacion; // Asigna la asignación
    }

    public Estudiante getEstudiante() {
        return estudiante; // Devuelve el estudiante
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante; // Asigna el estudiante
    }

    public ArrayList getAsignaciones() {
        return asignaciones; // Devuelve la lista de asignaciones
    }

    public void setAsignaciones(ArrayList asignaciones) {
        this.asignaciones = asignaciones; // Asigna la lista de asignaciones
    }


}
