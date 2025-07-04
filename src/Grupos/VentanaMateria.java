/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupos;

/**
 *
 * @author jadia
 */
import CursoProfesor.VentanaAsitenciaMateria;
import General.Materia;
import General.Estudiante;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.List;

public class VentanaMateria extends JFrame {

    private Materia materia;
    private Sistema sistema;

    private DefaultListModel<Estudiante> modeloEstudiantes;
    private JList<Estudiante> listaEstudiantes;

    private DefaultListModel<Grupo> modeloGrupos;
    private JList<Grupo> listaGrupos;

    private JButton btnAgregarEstudiante, btnCrearGrupo, btnMarcarAsistencia, btnVolver;

    public VentanaMateria(Materia materia) {
        this.materia = materia;
        this.sistema = Sistema.getInstancia();

        setTitle("Materia: " + materia.getNombre());
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        initComponentes();
        cargarDatos();
    }

    private void initComponentes() {
        setLayout(new BorderLayout(10, 10));

        // Panel estudiantes
        modeloEstudiantes = new DefaultListModel<>();
        listaEstudiantes = new JList<>(modeloEstudiantes);
        JScrollPane scrollEstudiantes = new JScrollPane(listaEstudiantes);
        JPanel panelEstudiantes = new JPanel(new BorderLayout());
        panelEstudiantes.add(new JLabel("Estudiantes de la materia"), BorderLayout.NORTH);
        panelEstudiantes.add(scrollEstudiantes, BorderLayout.CENTER);

        btnAgregarEstudiante = new JButton("Agregar Estudiante");
        panelEstudiantes.add(btnAgregarEstudiante, BorderLayout.SOUTH);

        // Panel grupos
        modeloGrupos = new DefaultListModel<>();
        listaGrupos = new JList<>(modeloGrupos);
        JScrollPane scrollGrupos = new JScrollPane(listaGrupos);
        JPanel panelGrupos = new JPanel(new BorderLayout());
        panelGrupos.add(new JLabel("Grupos"), BorderLayout.NORTH);
        panelGrupos.add(scrollGrupos, BorderLayout.CENTER);

        JPanel panelGruposBotones = new JPanel();
        btnCrearGrupo = new JButton("Crear Grupo");
        btnMarcarAsistencia = new JButton("Marcar Asistencia (todos estudiantes materia)");
        btnVolver = new JButton("Volver");

        panelGruposBotones.add(btnCrearGrupo);
        panelGruposBotones.add(btnMarcarAsistencia);
        panelGruposBotones.add(btnVolver);

        panelGrupos.add(panelGruposBotones, BorderLayout.SOUTH);

        add(panelEstudiantes, BorderLayout.WEST);
        add(panelGrupos, BorderLayout.EAST);

        btnAgregarEstudiante.addActionListener(e -> agregarEstudiante());
        btnCrearGrupo.addActionListener(e -> crearGrupoAutomatico());
        btnMarcarAsistencia.addActionListener(e -> marcarAsistenciaMateria());
        btnVolver.addActionListener(e -> volver());
    }

    private void cargarDatos() {
        modeloEstudiantes.clear();
        for (Estudiante e : materia.getEstudiantes()) {
            modeloEstudiantes.addElement(e);
        }

        modeloGrupos.clear();
        List<Grupo> gruposMateria = sistema.getGrupos().stream()
                .filter(g -> g.getIdMateria().equals(materia.getId()))
                .toList();

        for (Grupo g : gruposMateria) {
            modeloGrupos.addElement(g);
        }
    }

    private void agregarEstudiante() {
        String id = JOptionPane.showInputDialog(this, "ID del estudiante:");
        if (id == null || id.trim().isEmpty()) return;
        String nombre = JOptionPane.showInputDialog(this, "Nombre del estudiante:");
        if (nombre == null || nombre.trim().isEmpty()) return;

        Estudiante e = new Estudiante(id.trim(), nombre.trim());
        sistema.agregarEstudiante(e);
        materia.agregarEstudiante(e);
        modeloEstudiantes.addElement(e);
        guardarDatos();
    }

    // Crear grupo automático con nombre "Grupo X"
    private void crearGrupoAutomatico() {
        // Contar cuántos grupos hay ya para esta materia
        long count = sistema.getGrupos().stream()
                .filter(g -> g.getIdMateria().equals(materia.getId()))
                .count();

        int numeroGrupo = (int) count + 1;

        String idGrupo = materia.getId() + "-G" + numeroGrupo; // Ejemplo: MAT01-G1
        String nombreGrupo = "Grupo " + numeroGrupo;

        Grupo g = new Grupo(idGrupo, nombreGrupo, materia.getId());
        sistema.agregarGrupo(g);
        modeloGrupos.addElement(g);
        guardarDatos();

        JOptionPane.showMessageDialog(this, "Grupo creado: " + nombreGrupo);
    }

    // Marcar asistencia para todos los estudiantes de la materia
    private void marcarAsistenciaMateria() {
        if (materia.getEstudiantes().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay estudiantes en la materia para marcar asistencia.");
            return;
        }
        VentanaAsitenciaMateria va = new VentanaAsitenciaMateria(materia);
        va.setVisible(true);
    }

    private void volver() {
        this.dispose();
    }

    private void guardarDatos() {
        try {
            sistema.guardarDatos();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error guardando datos: " + ex.getMessage());
        }
    }
}