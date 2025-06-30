package Calificaciones;

import java.io.Serializable;
import java.util.Date;

public class Asignacion implements Serializable{
    //----------- Atributos ----------------------//
    String Nombre,Descripcion;
    Date fechaInicio, fechaFinal;
    boolean EnGrupo;
    double calificacion;
    int id_categoria; //Esto porque aveces las notas se agrupan en diferentes categorias omo lo puede ser proyecto final, etc...

    public Asignacion(String Nombre, String Descripcion, Date fechaInicio, Date fechaFinal, boolean EnGrupo, int calificacion, int id_categoria) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.EnGrupo = EnGrupo;
        this.calificacion = calificacion;
        this.id_categoria = id_categoria;
    }

    public Asignacion() {
    }
    
    // --- Metodos --- //
    
    
    
    // --- Gets y ses --- //

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public boolean isEnGrupo() {
        return EnGrupo;
    }

    public void setEnGrupo(boolean EnGrupo) {
        this.EnGrupo = EnGrupo;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    
    
}
