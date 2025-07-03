package General;

import General.Estudiante;
import java.io.Serializable;
import java.util.ArrayList;

public class Materia implements Serializable {
    private String id, nombre, carreras, horario, grupo, id_profesor;
    private ArrayList<Estudiante> estudiantes;

    public Materia(String id, String nombre, String carreras, String horario, String grupo, String id_profesor) {
        this.id = id;
        this.nombre = nombre;
        this.carreras = carreras;
        this.horario = horario;
        this.grupo = grupo;
        this.id_profesor = id_profesor;
        this.estudiantes = new ArrayList<>();
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