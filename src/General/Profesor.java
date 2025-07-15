package General;

import java.io.Serializable;
import java.util.ArrayList;


public class Profesor implements Serializable {

    private String id;
    private String nombre;
    private String correo;
    private String contra;
    private ArrayList<Materia> materias;

    // ----------------- Constructores ----------------- //

    /**
     * Constructor completo para inicializar todos los campos.
     */
    public Profesor(String id, String nombre, String correo, String contra) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contra = contra;
        this.materias = new ArrayList<>();
    }

    /**
     * Constructor básico (solo ID y nombre).
     */
    public Profesor(String id, String nombre) {
        this(id, nombre, "", ""); // delega al constructor principal
    }

    // ----------------- Métodos funcionales ----------------- //

    /**
     * Agrega una materia al profesor si no está previamente asignada.
     * @param materia Objeto de tipo Materia
     */
    public void agregarMateria(Materia materia) {
        if (materia != null && !materias.contains(materia)) {
            materias.add(materia);
        }
    }

    // ----------------- Getters y Setters ----------------- //

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

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        return nombre + " (" + id + ")";
    }
}