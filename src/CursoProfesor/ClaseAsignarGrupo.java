package CursoProfesor;

import General.Grupo;
import General.Materia;
import General.Estudiante;

import javax.swing.JOptionPane;
import java.util.List;

public class ClaseAsignarGrupo {

    public static void mostrarSelectorGrupo(Materia materia) {
        // Crear un mensaje con los estudiantes que aún no tienen grupo
        StringBuilder listaEst = new StringBuilder("Estudiantes sin grupo:\n");

        // Obtener lista de estudiantes sin grupo (el método ya hace el filtro en Materia)
        List<Estudiante> sinGrupo = materia.getEstudiantesSinGrupo();

        // Recorrer los estudiantes sin grupo y agregarlos al mensaje
        for (Estudiante e : sinGrupo) {
            listaEst.append("- ")
                    .append(e.getNombre()) // Nombre del estudiante
                    .append(" (")
                    .append(e.getId()) // ID del estudiante
                    .append(")\n");
        }

        // Mostrar la lista de estudiantes sin grupo en un cuadro de diálogo
        JOptionPane.showMessageDialog(null, listaEst.toString());

        // Opciones de grupos disponibles
        String[] nombresGrupos = {"Grupo 1", "Grupo 2", "Grupo 3", "Grupo 4", "Grupo 5", "Grupo 6"};

        // Cuadro de diálogo para seleccionar un grupo
        String grupoSeleccionado = (String) JOptionPane.showInputDialog(
                null,                          // Ventana padre
                "Seleccione un grupo:",        // Mensaje
                "Asignar Grupo",               // Título del cuadro
                JOptionPane.PLAIN_MESSAGE,     // Tipo de mensaje
                null,                          // Icono (null = sin icono)
                nombresGrupos,                 // Opciones disponibles
                nombresGrupos[0]               // Opción por defecto
        );

        // Si el usuario cancela, se termina el método
        if (grupoSeleccionado == null) return;

        // Pedir el ID del estudiante que se quiere asignar
        String idEstudiante = JOptionPane.showInputDialog("ID del estudiante a asignar:");
        if (idEstudiante == null || idEstudiante.trim().isEmpty()) return; // Si se cancela o está vacío, salir

        // Buscar el estudiante en la lista de los que no tienen grupo
        Estudiante estudiante = buscarEnLista(sinGrupo, idEstudiante);

        // Si no se encuentra, mostrar error y terminar
        if (estudiante == null) {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
            return;
        }

        // Buscar un grupo ya existente con ese nombre o generar uno nuevo si no existe
        Grupo grupoFinal = buscarOGenerarGrupo(materia, grupoSeleccionado);

        // Agregar el estudiante al grupo seleccionado
        grupoFinal.agregarEstudiante(estudiante);

        // Quitar al estudiante de la lista de "sin grupo"
        materia.eliminarEstudiante(estudiante);

        // Confirmar que el estudiante fue asignado
        JOptionPane.showMessageDialog(null, "Estudiante asignado a " + grupoFinal.getNombre());
    }

    // Método auxiliar: busca un estudiante en una lista por su ID
    private static Estudiante buscarEnLista(List<Estudiante> lista, String id) {
        for (Estudiante e : lista) {
            if (e.getId().equalsIgnoreCase(id)) return e; // Devuelve el estudiante si coincide el ID
        }
        return null; // Si no se encuentra, devuelve null
    }

    // Método auxiliar: busca un grupo por nombre dentro de la materia
// Si no lo encuentra, crea uno nuevo y lo agrega a la materia
    private static Grupo buscarOGenerarGrupo(Materia materia, String nombreGrupo) {
        for (Grupo g : materia.getGrupos()) {
            if (g.getNombre().equalsIgnoreCase(nombreGrupo)) return g; // Si ya existe, lo devuelve
        }

        // Si no existe, se genera un nuevo grupo con un ID único basado en la hora actual
        Grupo nuevo = new Grupo("g" + System.currentTimeMillis(), nombreGrupo, materia.getId());
        materia.agregarGrupo(nuevo); // Se agrega el nuevo grupo a la materia
        return nuevo; // Se devuelve el nuevo grupo creado
    }

}