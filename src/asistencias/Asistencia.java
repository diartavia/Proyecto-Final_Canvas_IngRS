/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asistencias;

/**
 *
 * @author jadia
 */
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Asistencia implements Serializable {
    private String idMateria;
    private String idGrupo;
    private LocalDate fecha;

    // Mapa de estudianteId a estado (true = presente, false = ausente)
    private Map<String, Boolean> asistenciaPorEstudiante;

    public Asistencia(String idMateria, String idGrupo, LocalDate fecha) {
        this.idMateria = idMateria;
        this.idGrupo = idGrupo;
        this.fecha = fecha;
        this.asistenciaPorEstudiante = new HashMap<>();
    }

    public String getIdMateria() { return idMateria; }
    public String getIdGrupo() { return idGrupo; }
    public LocalDate getFecha() { return fecha; }

    public void marcarAsistencia(String idEstudiante, boolean presente) {
        asistenciaPorEstudiante.put(idEstudiante, presente);
    }

    public Boolean obtenerAsistencia(String idEstudiante) {
        return asistenciaPorEstudiante.getOrDefault(idEstudiante, false);
    }

    public Map<String, Boolean> getAsistenciaPorEstudiante() {
        return asistenciaPorEstudiante;
    }
}