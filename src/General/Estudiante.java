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
    private String id, nombre, Correo, Contra;
    private Map<Materia, List<NotaAsignacion>> notasPorMateria;
    private ArrayList<Materia> Materias;

    public Estudiante(String id, String nombre, String Correo, String Contra) {
        this.id = id;
        this.nombre = nombre;
        this.notasPorMateria = new HashMap<>();
        this.Materias = new ArrayList<>();
        this.Correo = Correo;
        this.Contra = Contra;
    }

    public Estudiante(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.notasPorMateria = new HashMap<>();
        this.Materias = new ArrayList<>();
    }
    //metodos
    
    public double getNotaGeneral() {
        double total = 0;
        int cantidadNotas = 0;

        for (List<NotaAsignacion> lista : notasPorMateria.values()) {
            for (NotaAsignacion notaAsignacion : lista) {
                total += notaAsignacion.getNota();
                cantidadNotas++;
            }
        }

        if (cantidadNotas == 0) return 0.0;

        return total / cantidadNotas;
    }

    
    public void asignarNota(Materia materia, Asignacion asignacion, double nota) {
        notasPorMateria.putIfAbsent(materia, new ArrayList<>());
        List<NotaAsignacion> lista = notasPorMateria.get(materia);

        // Si ya existe una nota para esa asignación, actualizar
        for (NotaAsignacion n : lista) {
            if (n.getAsignacion().equals(asignacion)) {
                n.setNota(nota);
                return;
            }
        }

        // Si no existe, la agregamos
        lista.add(new NotaAsignacion(asignacion, nota));
    }
    
    
    public String getCorreo() {    
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContra() {
        return Contra;
    }

    //gets y sets
    public void setContra(String Contra) {
        this.Contra = Contra;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setNotasPorMateria(Map<Materia, List<NotaAsignacion>> notasPorMateria) {
        this.notasPorMateria = notasPorMateria;
    }

    public ArrayList<Materia> getMaterias() {
        return Materias;
    }

    public Map<Materia, List<NotaAsignacion>> getNotasPorMateria() {
        return notasPorMateria;
    }

    public void setMaterias(ArrayList<Materia> Materias) {
        this.Materias = Materias;
    }

    
    @Override
    public String toString() {
        return nombre + " (" + id + ")";
    }
}