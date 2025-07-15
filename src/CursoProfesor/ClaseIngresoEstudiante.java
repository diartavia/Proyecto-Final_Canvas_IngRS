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
        String id = JOptionPane.showInputDialog(null, "ID del estudiante:");
        if (id == null || id.trim().isEmpty()) return;

        String nombre = JOptionPane.showInputDialog(null, "Nombre:");
        if (nombre == null || nombre.trim().isEmpty()) return;

        String apellido = JOptionPane.showInputDialog(null, "Apellido:");
        if (apellido == null || apellido.trim().isEmpty()) return;

        String correo = JOptionPane.showInputDialog(null, "Correo:");
        if (correo == null || correo.trim().isEmpty()) return;

        String contra = JOptionPane.showInputDialog(null, "Contraseña:");
        if (contra == null || contra.trim().isEmpty()) return;

        Estudiante nuevo = new Estudiante(id, nombre, apellido, correo, contra);
        Sistema.getEstudiantes().add(nuevo);
        materia.agregarEstudiante(nuevo);

        JOptionPane.showMessageDialog(null, "Estudiante creado y agregado exitosamente.");
    }
}