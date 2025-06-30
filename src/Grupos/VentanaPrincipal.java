/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupos;

/**
 *
 * @author jadia
 */
import General.Materia;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class VentanaPrincipal extends JFrame {

    private Sistema sistema;
    private DefaultListModel<Materia> modeloMaterias;
    private JList<Materia> listaMaterias;
    private JButton btnAbrirMateria, btnAgregarMateria;

    public VentanaPrincipal() {
        sistema = Sistema.getInstancia();
        try {
            sistema.cargarDatos();
        } catch (Exception e) {
            System.out.println("No se pudo cargar datos, iniciando vacío.");
        }

        setTitle("Menú Principal - Canvas Ulacit");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponentes();
        cargarMaterias();
    }

    private void initComponentes() {
        modeloMaterias = new DefaultListModel<>();
        listaMaterias = new JList<>(modeloMaterias);
        JScrollPane scroll = new JScrollPane(listaMaterias);

        btnAbrirMateria = new JButton("Abrir Materia");
        btnAgregarMateria = new JButton("Agregar Materia");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAbrirMateria);
        panelBotones.add(btnAgregarMateria);

        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        btnAbrirMateria.addActionListener(e -> {
            Materia seleccionada = listaMaterias.getSelectedValue();
            if (seleccionada == null) {
                JOptionPane.showMessageDialog(this, "Seleccione una materia.");
                return;
            }
            new VentanaMateria(seleccionada).setVisible(true);
        });

        btnAgregarMateria.addActionListener(e -> {
            String id = JOptionPane.showInputDialog(this, "ID de la materia:");
            if (id == null || id.trim().isEmpty()) return;
            String nombre = JOptionPane.showInputDialog(this, "Nombre de la materia:");
            if (nombre == null || nombre.trim().isEmpty()) return;

            Materia nueva = new Materia(id.trim(), nombre.trim());
            sistema.agregarMateria(nueva);
            modeloMaterias.addElement(nueva);
            guardarDatos();
        });
    }

    private void cargarMaterias() {
        modeloMaterias.clear();
        for (Materia m : sistema.getMaterias()) {
            modeloMaterias.addElement(m);
        }
    }

    private void guardarDatos() {
        try {
            sistema.guardarDatos();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error guardando datos: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }
}
