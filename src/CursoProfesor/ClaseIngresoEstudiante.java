/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
  package CursoProfesor;

import General.Estudiante;
import General.Materia;
import General.Sistema;

import javax.swing.JOptionPane;

public class ClaseIngresoEstudiante {

    public static void mostrarFormulario(Materia materia) {
        // Solicitar el ID del estudiante
        String id = JOptionPane.showInputDialog(null, "ID del estudiante:");
        if (id == null || id.trim().isEmpty()) return; // Si se cancela o queda vacío, se termina el método

        // Solicitar el nombre del estudiante
        String nombre = JOptionPane.showInputDialog(null, "Nombre:");
        if (nombre == null || nombre.trim().isEmpty()) return; // Validar entrada

        // Solicitar el apellido del estudiante
        String apellido = JOptionPane.showInputDialog(null, "Apellido:");
        if (apellido == null || apellido.trim().isEmpty()) return; // Validar entrada

        // Solicitar el correo electrónico del estudiante
        String correo = JOptionPane.showInputDialog(null, "Correo:");
        if (correo == null || correo.trim().isEmpty()) return; // Validar entrada

        // Solicitar la contraseña del estudiante
        String contra = JOptionPane.showInputDialog(null, "Contraseña:");
        if (contra == null || contra.trim().isEmpty()) return; // Validar entrada

        // Crear un nuevo objeto Estudiante con los datos ingresados
        Estudiante nuevo = new Estudiante(id, nombre, apellido, correo, contra);

        // Agregar al estudiante a la lista global del sistema
        Sistema.getEstudiantes().add(nuevo);

        // Agregar al estudiante a la materia específica recibida como parámetro
        materia.agregarEstudiante(nuevo);

        // Mostrar mensaje de confirmación
        JOptionPane.showMessageDialog(null, "Estudiante creado y agregado exitosamente.");
    }

}