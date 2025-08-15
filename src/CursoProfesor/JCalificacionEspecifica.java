package CursoProfesor;

import General.Estudiante;
import General.Materia;
import javax.swing.JOptionPane;

public class JCalificacionEspecifica extends javax.swing.JFrame {

    private Estudiante estudiante;
    private Materia mate;
    
    public JCalificacionEspecifica() {
        initComponents();
        this.mate = mate;
        this.setLocationRelativeTo(null);
    }

    public JCalificacionEspecifica(Estudiante estudiante, Materia materia) {
        initComponents();
        this.estudiante = estudiante;
        this.mate = materia;

        this.JLEstu.setText(estudiante.getNombre());
        this.JLNota.setText(String.valueOf(estudiante.getNotaGeneral()));
        
        JCbx_Asignaciones.removeAllItems();

        for (Asignacion a : materia.getAsignaciones()) {
            JCbx_Asignaciones.addItem(a.getNombre()); 
        }
    }
    // Metodos para asignacion
    
    Asignacion asigna = new Asignacion();
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBtn_calificar = new javax.swing.JButton();
        JCbx_Asignaciones = new javax.swing.JComboBox<>();
        JNota = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        JLEstu = new javax.swing.JLabel();
        JLNota = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jBtn_calificar.setText("Calificar");
        jBtn_calificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_calificarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nota de");

        JLEstu.setText("Estudiante");

        JLNota.setText("Nota");

        jLabel2.setText("Calificacion");

        jLabel3.setText("Comentario");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Calificar");

        jLabel5.setText("Asignación");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel4)
                        .addGap(503, 503, 503)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JLEstu)
                        .addGap(67, 67, 67)
                        .addComponent(JLNota))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(375, 375, 375)
                        .addComponent(jBtn_calificar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCbx_Asignaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(JNota, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JLEstu)
                    .addComponent(JLNota)
                    .addComponent(jLabel4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JNota)
                            .addComponent(JCbx_Asignaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jBtn_calificar)
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtn_calificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_calificarActionPerformed
        try {
            String nombreAsignacion = JCbx_Asignaciones.getSelectedItem().toString();
            String notaTexto = JNota.getText().trim();

            if (notaTexto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, escriba una nota.");
                return;
            }

            double nota;
            try {
                nota = Double.parseDouble(notaTexto);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "La nota debe ser un número válido.");
                return;
            }

            if (nota < 0 || nota > 100) {
                JOptionPane.showMessageDialog(this, "La nota debe estar entre 0 y 100.");
                return;
            }


            Asignacion asignacionSeleccionada = null;
            for (Asignacion a : mate.getAsignaciones()) {
                if (a.getNombre().equals(nombreAsignacion)) {
                    asignacionSeleccionada = a;
                    break;
                }
            }

            if (asignacionSeleccionada == null) {
                JOptionPane.showMessageDialog(this, "Asignación no válida");
                return;
            }

            estudiante.asignarNota(mate, asignacionSeleccionada, nota); // 👈 Aquí usás tu método

            JOptionPane.showMessageDialog(this, "Nota asignada correctamente.");
            this.dispose();
            new JCalificacionesProfe(mate).setVisible(true);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La nota debe ser un número válido.");
        }
    }//GEN-LAST:event_jBtn_calificarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCbx_Asignaciones;
    private javax.swing.JLabel JLEstu;
    private javax.swing.JLabel JLNota;
    private javax.swing.JTextField JNota;
    private javax.swing.JButton jBtn_calificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
