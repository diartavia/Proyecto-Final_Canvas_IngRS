package General;

/**
 *
 * @author jadia
 */
import General.Estudiante;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Grupo implements Serializable {

    private String id;
    private String nombre;
    private String idMateria; // ID de la materia a la que pertenece este grupo
    private List<Estudiante> estudiantes;
    private ArrayList<Grupo> grupos;

    public Grupo(String id, String nombre, String idMateria) {
        this.id = id;
        this.nombre = nombre;
        this.idMateria = idMateria;
        this.estudiantes = new ArrayList<>();
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

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    // ----------------- Métodos funcionales ----------------- //

    /**
     * Agrega un estudiante al grupo si no está ya inscrito.
     */
    public void agregarEstudiante(Estudiante e) {
        if (e != null && !estudiantes.contains(e)) {
            estudiantes.add(e);
        }
    }

    /**
     * Elimina un estudiante del grupo.
     */
    public void eliminarEstudiante(Estudiante e) {
        estudiantes.remove(e);
    }

    @Override
    public String toString() {
        return nombre + " (" + id + ")";
    }

    
}
