package Pantallas.LogIn;

import General.Profesor;
import General.Sistema;
import General.VentanaPrincipalProfesor;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LoginProfesor extends javax.swing.JFrame {

    public LoginProfesor() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_Ingresar_Profe = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JLabel_Correo_Profe = new javax.swing.JLabel();
        JLabel_Passwd_Profe = new javax.swing.JLabel();
        tf_correo_profe = new javax.swing.JTextField();
        JPsswF_passwProfe = new javax.swing.JPasswordField();
        btn_atras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(63, 42, 85));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btn_Ingresar_Profe.setText("Siguiente");
        btn_Ingresar_Profe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Ingresar_ProfeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Autentificacion de Profesor");

        JLabel_Correo_Profe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JLabel_Correo_Profe.setForeground(new java.awt.Color(0, 0, 0));
        JLabel_Correo_Profe.setText("Correo");

        JLabel_Passwd_Profe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JLabel_Passwd_Profe.setForeground(new java.awt.Color(0, 0, 0));
        JLabel_Passwd_Profe.setText("Contraseña");

        tf_correo_profe.setText("Usuario@ulacit.ed.cr");

        btn_atras.setText("Atras");
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_atras)
                                .addGap(56, 56, 56)
                                .addComponent(btn_Ingresar_Profe))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLabel_Correo_Profe)
                                    .addComponent(JLabel_Passwd_Profe))
                                .addGap(75, 75, 75)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_correo_profe, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                                    .addComponent(JPsswF_passwProfe))))))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel_Correo_Profe)
                    .addComponent(tf_correo_profe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel_Passwd_Profe)
                    .addComponent(JPsswF_passwProfe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Ingresar_Profe)
                    .addComponent(btn_atras))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
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

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        // TODO add your handling code here:
        LogIn login = new LogIn();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_atrasActionPerformed
    
    private void btn_Ingresar_ProfeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Ingresar_ProfeActionPerformed
        String correo = tf_correo_profe.getText().trim().toLowerCase();
        String passw = new String(JPsswF_passwProfe.getPassword()).trim();

        if (correo.isEmpty() || passw.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe llenar ambos campos.");
            return;
        }

        if (!correo.endsWith("@ulacit.ed.cr")) {
            JOptionPane.showMessageDialog(null, "El correo debe terminar en @ulacit.ed.cr");
            return;
        }

        for (Profesor profe : Sistema.getProfesores()) {
            if (profe.getCorreo().equalsIgnoreCase(correo) && profe.getContra().equals(passw)) {
                Sistema.setProfesorActual(profe);
                VentanaPrincipalProfesor ventana = new VentanaPrincipalProfesor();
                ventana.setVisible(true);
                this.dispose();
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Credenciales incorrectas.");   
    }//GEN-LAST:event_btn_Ingresar_ProfeActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel_Correo_Profe;
    private javax.swing.JLabel JLabel_Passwd_Profe;
    private javax.swing.JPasswordField JPsswF_passwProfe;
    private javax.swing.JButton btn_Ingresar_Profe;
    private javax.swing.JButton btn_atras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField tf_correo_profe;
    // End of variables declaration//GEN-END:variables
}
