/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CursoProfesor;

/**
 *
 * @author jadia
 */
import General.Materia;
import General.Estudiante;
import Grupos.Sistema;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.io.IOException;

public class VentanaAsitenciaMateria extends JFrame {

    private Materia materia;
    private Sistema sistema;

    private JCheckBox[] checkBoxes;

    private JButton btnGuardar;

    public VentanaAsitenciaMateria(Materia materia) {
        this.materia = materia;
        this.sistema = Sistema.getInstancia();

        setTitle("Asistencia materia: " + materia.getNombre());
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        initComponentes();
    }

    private void initComponentes() {
        setLayout(new BorderLayout());

        java.util.List<Estudiante> estudiantes = materia.getEstudiantes();

        JPanel panelLista = new JPanel();
        panelLista.setLayout(new BoxLayout(panelLista, BoxLayout.Y_AXIS));
        checkBoxes = new JCheckBox[estudiantes.size()];

        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante e = estudiantes.get(i);
            checkBoxes[i] = new JCheckBox(e.toString());
            panelLista.add(checkBoxes[i]);
        }

        JScrollPane scrollPane = new JScrollPane(panelLista);

        btnGuardar = new JButton("Guardar Asistencia");

        add(scrollPane, BorderLayout.CENTER);
        add(btnGuardar, BorderLayout.SOUTH);

        btnGuardar.addActionListener(e -> guardarAsistencia());
    }

    private void guardarAsistencia() {
        Asistencia asistencia = new Asistencia(materia.getId(), "NO_GRUPO", LocalDate.now());

        for (int i = 0; i < materia.getEstudiantes().size(); i++) {
            Estudiante e = materia.getEstudiantes().get(i);
            boolean presente = checkBoxes[i].isSelected();
            asistencia.marcarAsistencia(e.getId(), presente);
        }

        sistema.agregarAsistencia(asistencia);
        try {
            sistema.guardarDatos();
            JOptionPane.showMessageDialog(this, "Asistencia guardada para la materia.");
            dispose();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error guardando asistencia: " + ex.getMessage());
        }
    }
}
