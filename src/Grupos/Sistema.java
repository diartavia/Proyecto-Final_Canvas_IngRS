/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupos;

/**
 *
 * @author jadia
 */
import CursoProfesor.ArchivoUtil;
import CursoProfesor.Asistencia;
import General.Materia;
import General.Estudiante;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sistema {

    private List<Estudiante> estudiantes;
    private List<Materia> materias;
    private List<Grupo> grupos;
    private List<Asistencia> asistencias;

    private static Sistema instancia;

    private Sistema() {
        estudiantes = new ArrayList<>();
        materias = new ArrayList<>();
        grupos = new ArrayList<>();
        asistencias = new ArrayList<>();
    }

    public static Sistema getInstancia() {
        if (instancia == null) {
            instancia = new Sistema();
        }
        return instancia;
    }

    // Métodos para estudiantes
    public void agregarEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public void eliminarEstudiante(Estudiante e) {
        estudiantes.remove(e);
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    // Métodos para materias
    public void agregarMateria(Materia m) {
        materias.add(m);
    }

    public void eliminarMateria(Materia m) {
        materias.remove(m);
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    // Métodos para grupos
    public void agregarGrupo(Grupo g) {
        grupos.add(g);
    }

    public void eliminarGrupo(Grupo g) {
        grupos.remove(g);
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    // Métodos para asistencias
    public void agregarAsistencia(Asistencia a) {
        asistencias.add(a);
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    // Guardar todos los datos en archivos
    public void guardarDatos() throws IOException {
        ArchivoUtil.guardarLista("estudiantes.dat", estudiantes);
        ArchivoUtil.guardarLista("materias.dat", materias);
        ArchivoUtil.guardarLista("grupos.dat", grupos);
        ArchivoUtil.guardarLista("asistencias.dat", asistencias);
    }

    // Cargar todos los datos desde archivos
    public void cargarDatos() throws IOException, ClassNotFoundException {
        List<Estudiante> est = ArchivoUtil.cargarLista("estudiantes.dat");
        if (est != null) estudiantes = est;

        List<Materia> mat = ArchivoUtil.cargarLista("materias.dat");
        if (mat != null) materias = mat;

        List<Grupo> gru = ArchivoUtil.cargarLista("grupos.dat");
        if (gru != null) grupos = gru;

        List<Asistencia> asi = ArchivoUtil.cargarLista("asistencias.dat");
        if (asi != null) asistencias = asi;
    }
}
