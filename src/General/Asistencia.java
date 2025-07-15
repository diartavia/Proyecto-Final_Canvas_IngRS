/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package General;

/**
 *
 * @author jadia
 */

import java.io.Serializable;
import java.util.Date;

import java.io.Serializable;

import java.util.Date;

public class Asistencia implements Serializable {
    private String idEstudiante;
    private Date fecha;
    private EstadoAsistencia estado;

    public enum EstadoAsistencia {
        PRESENTE, AUSENTE, TARDE
    }

    public Asistencia(String idEstudiante, Date fecha, EstadoAsistencia estado) {
        this.idEstudiante = idEstudiante;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String getIdEstudiante() { return idEstudiante; }
    public Date getFecha() { return fecha; }
    public EstadoAsistencia getEstado() { return estado; }

    public void setEstado(EstadoAsistencia estado) {
        this.estado = estado;
    }
}
