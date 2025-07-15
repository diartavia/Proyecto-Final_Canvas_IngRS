package General;

import CursoProfesor.Asignacion;
import java.io.Serializable;

public class NotaAsignacion implements Serializable {
    
    private Asignacion asignacion;
    private double nota;
    // constructor, getters y setters

    public NotaAsignacion(Asignacion asignacion, double nota) {
        this.asignacion = asignacion;
        this.nota = nota;
    }
    
    public NotaAsignacion() {
    }

    
    //-------------- Get y sets ------------------------//
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
    
    
}
