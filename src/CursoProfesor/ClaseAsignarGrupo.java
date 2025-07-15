/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CursoProfesor;

import General.Grupo;
import General.Materia;
import General.Estudiante;

import javax.swing.JOptionPane;
import java.util.List;

public class ClaseAsignarGrupo {

    public static void mostrarSelectorGrupo(Materia materia) {
        // Mostrar estudiantes sin grupo
        StringBuilder listaEst = new StringBuilder("Estudiantes sin grupo:\n");
        List<Estudiante> sinGrupo = materia.getEstudiantesSinGrupo(); // ya filtra internamente

        for (Estudiante e : sinGrupo) {
            listaEst.append("- ").append(e.getNombre()).append(" (").append(e.getId()).append(")\n");
        }

        JOptionPane.showMessageDialog(null, listaEst.toString());

        // Elegir grupo
        String[] nombresGrupos = {"Grupo 1", "Grupo 2", "Grupo 3", "Grupo 4", "Grupo 5", "Grupo 6"};
        String grupoSeleccionado = (String) JOptionPane.showInputDialog(
            null, "Seleccione un grupo:",
            "Asignar Grupo", JOptionPane.PLAIN_MESSAGE,
            null, nombresGrupos, nombresGrupos[0]
        );

        if (grupoSeleccionado == null) return;

        String idEstudiante = JOptionPane.showInputDialog("ID del estudiante a asignar:");
        if (idEstudiante == null || idEstudiante.trim().isEmpty()) return;

        Estudiante estudiante = buscarEnLista(sinGrupo, idEstudiante);
        if (estudiante == null) {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
            return;
        }

        Grupo grupoFinal = buscarOGenerarGrupo(materia, grupoSeleccionado);
        grupoFinal.agregarEstudiante(estudiante);
        materia.eliminarEstudiante(estudiante);

        JOptionPane.showMessageDialog(null, "Estudiante asignado a " + grupoFinal.getNombre());
    }

    private static Estudiante buscarEnLista(List<Estudiante> lista, String id) {
        for (Estudiante e : lista) {
            if (e.getId().equalsIgnoreCase(id)) return e;
        }
        return null;
    }

    private static Grupo buscarOGenerarGrupo(Materia materia, String nombreGrupo) {
        for (Grupo g : materia.getGrupos()) {
            if (g.getNombre().equalsIgnoreCase(nombreGrupo)) return g;
        }

        Grupo nuevo = new Grupo("g" + System.currentTimeMillis(), nombreGrupo, materia.getId());
        materia.agregarGrupo(nuevo);
        return nuevo;
    }
}