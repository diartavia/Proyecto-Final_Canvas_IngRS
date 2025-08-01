package General;

import CursoProfesor.Asignacion;
import General.Estudiante;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Materia implements Serializable {

    // ----------------- Atributos ----------------- //
    private String id;
    private String nombre;
    private String carreras;
    private String horario;
    private String grupo;
    private String idProfesor;

    private ArrayList<Asistencia> asistencias = new ArrayList<>();
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Asignacion> asignaciones;
    private ArrayList<Grupo> grupos; // Lista de grupos asociados a esta materia
    private List<Modulo> modulos = new ArrayList<>();

    
    /**
     * Constructor completo para una materia.
     */
    public Materia(String id, String nombre, String carreras, String horario, String grupo, String idProfesor) {
        this.id = id;
        this.nombre = nombre;
        this.carreras = carreras;
        this.horario = horario;
        this.grupo = grupo;
        this.idProfesor = idProfesor;

        this.estudiantes = new ArrayList<>();
        this.asignaciones = new ArrayList<>();
        this.grupos = new ArrayList<>();
    }

    // ----------------- Métodos de grupos ----------------- //

    /**
     * Devuelve los grupos asociados a esta materia.
     */
    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    /**
     * Agrega un grupo a esta materia si no existe.
     */
    public void agregarGrupo(Grupo g) {
        if (g != null && !grupos.contains(g)) {
            grupos.add(g);
        }
    }

    // ----------------- Métodos de asignaciones ----------------- //

    public ArrayList<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void agregarAsignaciones(Asignacion asigna) {
        if (asigna != null && !asignaciones.contains(asigna)) {
            asignaciones.add(asigna);
        }
    }

    // ----------------- Métodos de estudiantes ----------------- //

    public ArrayList<Estudiante> getEstudiantes() {
    ArrayList<Estudiante> todos = new ArrayList<>();

    // 1. Agregar estudiantes asignados directamente (sin grupo aún)
    for (Estudiante e : estudiantes) {
        if (!todos.contains(e)) {
            todos.add(e);
        }
    }

    // 2. Agregar estudiantes que ya están en grupos
    for (Grupo grupo : grupos) {
        for (Estudiante e : grupo.getEstudiantes()) {
            if (!todos.contains(e)) {
                todos.add(e);
            }
        }
    }

    return todos;
}

    public void agregarEstudiante(Estudiante e) {
        if (e != null && !estudiantes.contains(e)) {
            estudiantes.add(e);
        }
    }

    public void eliminarEstudiante(Estudiante e) {
        estudiantes.remove(e);
    }

 public ArrayList<Estudiante> getEstudiantesSinGrupo() {
    ArrayList<Estudiante> sinGrupo = new ArrayList<>();
    for (Estudiante e : estudiantes) {
        boolean tieneGrupo = false;
        for (Grupo g : grupos) {
            if (g.getEstudiantes().contains(e)) {
                tieneGrupo = true;
                break;
            }
        }
        if (!tieneGrupo) {
            sinGrupo.add(e);
        }
    }
    return sinGrupo;
}
 //asistenciaas-------------------------------------------------------------------
 
 
 public ArrayList<Asistencia> getAsistencias() {
    return asistencias;
}
 
 public void agregarAsistencia(Asistencia a) {
    asistencias.add(a);
}
 
 public boolean contieneEstudiante(String idEstudiante) {
    for (Estudiante e : getEstudiantes()) {
        if (e.getId().equals(idEstudiante)) {
            return true;
        }
    }
    return false;
}
    // ----------------- Getters y Setters ----------------- //

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarreras() {
        return carreras;
    }

    public String getHorario() {
        return horario;
    }

    public String getGrupo() {
        return grupo;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public List<Modulo> getModulos() {
    return modulos;
    }

    public void agregarModulo(Modulo modulo) {
        modulos.add(modulo);
    }

    // ----------------- Overrides ----------------- //

    @Override
    public String toString() {
        return nombre + " (" + id + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Materia other = (Materia) obj;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}