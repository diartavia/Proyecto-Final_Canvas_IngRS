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
    // Constructor de la clase.
    public JDetalleAsignacionEstudiante(Asignacion tarea) {
        // Almacena el objeto 'Asignacion' pasado en la variable de instancia.
        this.asignacion = tarea;
        initComponents();
        // Llama al método para cargar los datos de la asignación
        cargarDatos();
    }

    /**
     * Método para cargar los datos del objeto 'Asignacion' en los JLabels y JTextArea.
     */
    private void cargarDatos() {
        // Establece el texto de los JLabels con los datos de la asignación.
        lblNombre.setText(asignacion.getNombre());
        lblFechaInicio.setText(asignacion.getFechaInicio());
        lblFechaFinal.setText(asignacion.getFechaFinal());
        // Convierte el valor de puntos (posiblemente un tipo numérico) a String para el JLabel.
        lblPuntos.setText(String.valueOf(asignacion.getPuntos()));
        // Establece el texto del JTextArea con la descripción de la asignación.
        txtDescripcion.setText(asignacion.getDescripcion());

        // Simulación de estado: estas variables deberían ser calculadas
        // basándose en la lógica real de la aplicación.
        boolean subido = false; // Aquí se debería verificar si el estudiante ya ha subido la tarea.
        boolean atrasado = false; // Aquí se debería comparar la fecha actual con la fecha final.

        // Usa un operador ternario para mostrar "Sí" o "No" según el valor de las variables booleanas.
        lblSubido.setText(subido ? "Sí" : "No");
        lblAtrasado.setText(atrasado ? "Sí" : "No");
    }

    /**
     * Método para inicializar todos los componentes de la interfaz gráfica.
     * La anotación @SuppressWarnings("unchecked") se usa para suprimir advertencias
     * relacionadas con tipos genéricos.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Configuración de la ventana principal (JDialog).
        setTitle("Detalle de Asignación");
        setSize(500, 600);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla.
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Cierra solo esta ventana, no toda la aplicación.
        setLayout(null); // Establece el gestor de diseño a nulo, permitiendo posicionar componentes con setBounds.

        // Creación y configuración de componentes.
        JLabel titulo = new JLabel("Detalle de Asignación", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(100, 10, 300, 30);
        add(titulo);

        // JLabel para el nombre de la asignación y su correspondiente JLabel de datos.
        JLabel l1 = new JLabel("Nombre:");
        l1.setBounds(30, 60, 100, 25);
        add(l1);

        lblNombre = new JLabel();
        lblNombre.setBounds(150, 60, 300, 25);
        add(lblNombre);

        // JLabel para la fecha de inicio y su correspondiente JLabel de datos.
        JLabel l2 = new JLabel("Fecha Inicio:");
        l2.setBounds(30, 90, 100, 25);
        add(l2);

        lblFechaInicio = new JLabel();
        lblFechaInicio.setBounds(150, 90, 300, 25);
        add(lblFechaInicio);

        // JLabel para la fecha final y su correspondiente JLabel de datos.
        JLabel l3 = new JLabel("Fecha Final:");
        l3.setBounds(30, 120, 100, 25);
        add(l3);

        lblFechaFinal = new JLabel();
        lblFechaFinal.setBounds(150, 120, 300, 25);
        add(lblFechaFinal);

        // JLabel para los puntos y su correspondiente JLabel de datos.
        JLabel l4 = new JLabel("Puntos:");
        l4.setBounds(30, 150, 100, 25);
        add(l4);

        lblPuntos = new JLabel();
        lblPuntos.setBounds(150, 150, 300, 25);
        add(lblPuntos);

        // JLabel para la descripción.
        JLabel l5 = new JLabel("Descripción:");
        l5.setBounds(30, 180, 100, 25);
        add(l5);

        // JTextArea para la descripción, configurado para no ser editable y con ajuste de línea.
        txtDescripcion = new JTextArea();
        txtDescripcion.setBounds(30, 210, 420, 100);
        txtDescripcion.setEditable(false);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        add(txtDescripcion);

        // JLabel para el estado de "subido" y su correspondiente JLabel de datos.
        JLabel l6 = new JLabel("¿Lo subió?:");
        l6.setBounds(30, 320, 100, 25);
        add(l6);

        lblSubido = new JLabel();
        lblSubido.setBounds(150, 320, 100, 25);
        add(lblSubido);

        // JLabel para el estado de "atrasado" y su correspondiente JLabel de datos.
        JLabel l7 = new JLabel("¿Está atrasado?:");
        l7.setBounds(30, 350, 120, 25);
        add(l7);

        lblAtrasado = new JLabel();
        lblAtrasado.setBounds(150, 350, 100, 25);
        add(lblAtrasado);

        // JLabel para el área de subida.
        JLabel l8 = new JLabel("Área de subida:");
        l8.setBounds(30, 390, 120, 25);
        add(l8);

        // JPanel que simula el área de subida de archivos.
        JPanel panelSubida = new JPanel();
        panelSubida.setBounds(30, 420, 420, 80);
        panelSubida.setBackground(Color.LIGHT_GRAY);
        panelSubida.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        // Agrega un JLabel para dar instrucciones al usuario.
        panelSubida.add(new JLabel("Arrastra o selecciona un archivo aquí"));
        add(panelSubida);

        // Botón "Cerrar".
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(200, 520, 100, 30);
        // Añade un ActionListener para cerrar la ventana cuando se hace clic.
        btnCerrar.addActionListener(e -> dispose());
        add(btnCerrar);
    }

    // Variables de instancia para los componentes de la interfaz.
    private JLabel lblNombre, lblFechaInicio, lblFechaFinal, lblPuntos, lblSubido, lblAtrasado;
    private JTextArea txtDescripcion;
}
