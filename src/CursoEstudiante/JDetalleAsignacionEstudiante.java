/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CursoEstudiante;

/**
 *
 * @author jadia
 */
import CursoProfesor.Asignacion;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class JDetalleAsignacionEstudiante extends javax.swing.JFrame {

    private Asignacion asignacion;

    public JDetalleAsignacionEstudiante(Asignacion tarea) {
        this.asignacion = tarea;
        initComponents();
        cargarDatos();
    }

    private void cargarDatos() {
        lblNombre.setText(asignacion.getNombre());
        lblFechaInicio.setText(asignacion.getFechaInicio());
        lblFechaFinal.setText(asignacion.getFechaFinal());
        lblPuntos.setText(String.valueOf(asignacion.getPuntos()));
        txtDescripcion.setText(asignacion.getDescripcion());

        // Simulación de estado
        boolean subido = false; // Aquí podrías verificar si el estudiante ya subió
        boolean atrasado = false; // Aquí podrías calcular si la fecha actual > fecha final

        lblSubido.setText(subido ? "Sí" : "No");
        lblAtrasado.setText(atrasado ? "Sí" : "No");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setTitle("Detalle de Asignación");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel titulo = new JLabel("Detalle de Asignación", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(100, 10, 300, 30);
        add(titulo);

        JLabel l1 = new JLabel("Nombre:");
        l1.setBounds(30, 60, 100, 25);
        add(l1);

        lblNombre = new JLabel();
        lblNombre.setBounds(150, 60, 300, 25);
        add(lblNombre);

        JLabel l2 = new JLabel("Fecha Inicio:");
        l2.setBounds(30, 90, 100, 25);
        add(l2);

        lblFechaInicio = new JLabel();
        lblFechaInicio.setBounds(150, 90, 300, 25);
        add(lblFechaInicio);

        JLabel l3 = new JLabel("Fecha Final:");
        l3.setBounds(30, 120, 100, 25);
        add(l3);

        lblFechaFinal = new JLabel();
        lblFechaFinal.setBounds(150, 120, 300, 25);
        add(lblFechaFinal);

        JLabel l4 = new JLabel("Puntos:");
        l4.setBounds(30, 150, 100, 25);
        add(l4);

        lblPuntos = new JLabel();
        lblPuntos.setBounds(150, 150, 300, 25);
        add(lblPuntos);

        JLabel l5 = new JLabel("Descripción:");
        l5.setBounds(30, 180, 100, 25);
        add(l5);

        txtDescripcion = new JTextArea();
        txtDescripcion.setBounds(30, 210, 420, 100);
        txtDescripcion.setEditable(false);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        add(txtDescripcion);

        JLabel l6 = new JLabel("¿Lo subió?:");
        l6.setBounds(30, 320, 100, 25);
        add(l6);

        lblSubido = new JLabel();
        lblSubido.setBounds(150, 320, 100, 25);
        add(lblSubido);

        JLabel l7 = new JLabel("¿Está atrasado?:");
        l7.setBounds(30, 350, 120, 25);
        add(l7);

        lblAtrasado = new JLabel();
        lblAtrasado.setBounds(150, 350, 100, 25);
        add(lblAtrasado);

        JLabel l8 = new JLabel("Área de subida:");
        l8.setBounds(30, 390, 120, 25);
        add(l8);

        JPanel panelSubida = new JPanel();
        panelSubida.setBounds(30, 420, 420, 80);
        panelSubida.setBackground(Color.LIGHT_GRAY);
        panelSubida.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        panelSubida.add(new JLabel("Arrastra o selecciona un archivo aquí"));
        add(panelSubida);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(200, 520, 100, 30);
        btnCerrar.addActionListener(e -> dispose());
        add(btnCerrar);
    }

    // Variables
    private JLabel lblNombre, lblFechaInicio, lblFechaFinal, lblPuntos, lblSubido, lblAtrasado;
    private JTextArea txtDescripcion;
}
