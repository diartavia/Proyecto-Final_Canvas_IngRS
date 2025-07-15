package General;

/**
 *
 * @author jadia
 */
import CursoProfesor.Asignacion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estudiante implements Serializable {
    private String id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contra;

    // Relación: Materia → Lista de notas por asignación
    private Map<Materia, List<NotaAsignacion>> notasPorMateria;

    // Lista de materias en las que está inscrito
    private ArrayList<Materia> materias;

    /**
     * Constructor completo
     */
    public Estudiante(String id, String nombre, String apellido, String correo, String contra) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contra = contra;
        this.notasPorMateria = new HashMap<>();
        this.materias = new ArrayList<>();
    }

    /**
     * Constructor básico (ej: para pruebas rápidas)
     */
    public Estudiante(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.notasPorMateria = new HashMap<>();
        this.materias = new ArrayList<>();
    }

    // ------------------------ Gestión de notas ------------------------ //

    /**
     * Devuelve el promedio general del estudiante en todas sus materias.
     */
    public double getNotaGeneral() {
        double total = 0;
        int cantidadNotas = 0;

        for (List<NotaAsignacion> lista : notasPorMateria.values()) {
            for (NotaAsignacion notaAsignacion : lista) {
                total += notaAsignacion.getNota();
                cantidadNotas++;
            }
        }

        return cantidadNotas == 0 ? 0.0 : total / cantidadNotas;
    }

    /**
     * Asigna o actualiza una nota para una asignación en una materia.
     */
    public void asignarNota(Materia materia, Asignacion asignacion, double nota) {
        notasPorMateria.putIfAbsent(materia, new ArrayList<>());
        List<NotaAsignacion> lista = notasPorMateria.get(materia);

        for (NotaAsignacion n : lista) {
            if (n.getAsignacion().equals(asignacion)) {
                n.setNota(nota);
                return;
            }
        }

        lista.add(new NotaAsignacion(asignacion, nota));
    }

    // ------------------------ Gestión de materias ------------------------ //

    /**
     * Inscribe al estudiante en una materia si no está inscrito ya.
     */
    public void agregarMateria(Materia mate) {
        if (!materias.contains(mate)) {
            materias.add(mate);
        }
    }

    // ------------------------ Getters y Setters ------------------------ //

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public Map<Materia, List<NotaAsignacion>> getNotasPorMateria() {
        return notasPorMateria;
    }

    public void setNotasPorMateria(Map<Materia, List<NotaAsignacion>> notasPorMateria) {
        this.notasPorMateria = notasPorMateria;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + id + ")";
    }
    @Override
    public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Estudiante other = (Estudiante) obj;
    return id != null && id.equals(other.id);
}

    @Override
    public int hashCode() {
    return id != null ? id.hashCode() : 0;
    }
}