/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CursoEstudiante;

import General.Estudiante;
import General.Materia;
import General.NotaAsignacion;
import General.Sistema;
import General.VentanaPrincipalEstudiante;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JCalificaciones extends javax.swing.JFrame {

    /*
            - Nota Developer 1:
        Constructor, en este frame se ven las notas de cada curso de un estudiante en el curso
        this.setLocationRelativeTo(null); hace que la ventana se inicie en el centro

        Después hay botones/labels que permiten moverse a otros frames de la parte del curso como tal del estudiante
        se debe de pasar siempre la materia por el constructor de cada frame con algunas posibles excepciones
    */
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JCalificaciones.class.getName());
    Materia mate;
    //Constructor
    public JCalificaciones() {
        initComponents();
        cargarNotasGenerales(); //Metodo para cargar generales
        Estudiante estudianteact = Sistema.getEstudianteActual(); //para guardar el estudiante actual
        JLabel_Nombre.setText(estudianteact.getNombre()+" "+estudianteact.getApellido()); //para poner el nombre en el frame
        this.setLocationRelativeTo(null);
    }

    /*
        -----------Metodo para cargar las notas
     */
    private void cargarNotasGenerales() {
        //la tabla creada se asigna a un objeto de tabla
        DefaultTableModel model = (DefaultTableModel) TablasNota.getModel();
        model.setRowCount(0); // Limpiar tabla

        //Para saber el estudiante actual
        Estudiante estudiante = Sistema.getEstudianteActual();

        //para cargar la tabla de los cursos y las notas de cada asignación
        for (Materia materia : estudiante.getMaterias()) {
            List<NotaAsignacion> notas = estudiante.getNotasPorMateria().get(materia);
            if (notas != null && !notas.isEmpty()) {
                double suma = 0;
                for (NotaAsignacion n : notas) {
                    suma += n.getNota();
                }
                double promedio = suma / notas.size();
                model.addRow(new Object[]{materia.getNombre(), promedio});
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_Grupos = new javax.swing.JLabel();
        jLabel_Cursos = new javax.swing.JLabel();
        jLabel_Tablero = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JLabel_Nombre = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablasNota = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(63, 42, 85));
        jPanel1.setForeground(new java.awt.Color(153, 153, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo Ulacit_vSmall.png"))); // NOI18N

        jLabel_Grupos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_Grupos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Grupos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Grupos.setText("Grupos");
        jLabel_Grupos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Grupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_GruposMouseClicked(evt);
            }
        });

        jLabel_Cursos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_Cursos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Cursos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Cursos.setText("Cursos");
        jLabel_Cursos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Cursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_CursosMouseClicked(evt);
            }
        });

        jLabel_Tablero.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_Tablero.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Tablero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Tablero.setText("Tablero");
        jLabel_Tablero.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Tablero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_TableroMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_Tablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_Cursos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_Grupos, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(jLabel_Tablero, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Cursos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Grupos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setText("Cursos que estoy tomando");

        JLabel_Nombre.setText("Nombre Estudiante");

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));

        TablasNota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Curso", "Nota"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablasNota.setGridColor(new java.awt.Color(255, 255, 255));
        TablasNota.setSelectionForeground(new java.awt.Color(204, 204, 204));
        TablasNota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablasNotaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablasNota);
        if (TablasNota.getColumnModel().getColumnCount() > 0) {
            TablasNota.getColumnModel().getColumn(0).setResizable(false);
            TablasNota.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(JLabel_Nombre))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(148, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(JLabel_Nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    /*
       -------                                                                     ----------
       Labels que sirven como botones, los cuales llevan a otras "pestañas" del curso del estudiante
       En todos se crea un objeto del frame, se pone visible y se cierra la ventana actual
       -------                                                                     ----------
    */
    //Este lleva a poder ver los grupos del estudiante
    private void jLabel_GruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_GruposMouseClicked
       if (Sistema.getEstudianteActual() == null) {
            JOptionPane.showMessageDialog(this, "Debe iniciar sesión para acceder a Grupos.");
            return;
        }
    
        JGruposEstudiante ventana = new JGruposEstudiante(mate);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_GruposMouseClicked

    //Este lleva a poder ver los cursos del estudiante
    private void jLabel_CursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_CursosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_CursosMouseClicked

    //Este lleva a poder ver el tablero del estudiante donde sale cada curso
    private void jLabel_TableroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_TableroMouseClicked
        // TODO add your handling code here:
        VentanaPrincipalEstudiante VPE = new VentanaPrincipalEstudiante(Sistema.getEstudianteActual());
        VPE.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_TableroMouseClicked

    /*
        Es para que cuando se seleccione un objeto de la tabla se redirija al frame de cursos donde se ven las notas más especificas
    */
    private void TablasNotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablasNotaMouseClicked
        if (evt.getClickCount() == 2) { 
            int fila = TablasNota.rowAtPoint(evt.getPoint());
            if (fila >= 0) {
                String nombreMateria = (String) TablasNota.getValueAt(fila, 0);
                
                // Buscar la materia por nombre
                for (Materia m : Sistema.getEstudianteActual().getMaterias()) {
                    if (m.getNombre().equals(nombreMateria)) {
                        new JCalificacionesMateria(m).setVisible(true);
                        this.dispose();
                        break;
                    }
                }
            }
        }
    }//GEN-LAST:event_TablasNotaMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel_Nombre;
    private javax.swing.JTable TablasNota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Cursos;
    private javax.swing.JLabel jLabel_Grupos;
    private javax.swing.JLabel jLabel_Tablero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
