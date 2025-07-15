package General;

import CursoProfesor.Asignacion;
import java.io.Serializable;

/**
 * Representa la nota obtenida por un estudiante en una asignación específica.
 */
public class NotaAsignacion implements Serializable {
    
    private Asignacion asignacion;
    private double nota;

    // ----------------- Constructores ----------------- //

    public NotaAsignacion(Asignacion asignacion, double nota) {
        this.asignacion = asignacion;
        this.nota = nota;
    }

    public NotaAsignacion() {
    }

    // ----------------- Getters y Setters ----------------- //

    public Asignacion getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(Asignacion asignacion) {
        this.asignacion = asignacion;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    // ----------------- Utilidades ----------------- //

    @Override
    public String toString() {
        return "Asignación: " + (asignacion != null ? asignacion.getNombre() : "N/A") +
               " | Nota: " + nota;
    }
}