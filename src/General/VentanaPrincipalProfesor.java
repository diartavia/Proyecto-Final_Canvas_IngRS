package General;

import CursoProfesor.CursoProfesor;
import Pantallas.LogIn.LogIn;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class VentanaPrincipalProfesor extends javax.swing.JFrame {


    public VentanaPrincipalProfesor() {
        initComponents();
        this.setLocationRelativeTo(null);

        
        // Suponé que este es el profesor actual que ingresó al sistema
    Profesor profesorActual = Sistema.getProfesorActual();

    // Este panel es el que pusiste en el JFrame donde irán los botones
    JPanel panelCursos = this.jPanel_BotonesEstu; // El que agregaste visualmente

    // Por si ya hay algo
    panelCursos.removeAll(); 

    panelCursos.setLayout(new GridLayout(0, 2, 20, 20)); // Filas automáticas, 2 columnas

    for (Materia curso : profesorActual.getMaterias()) {
        JButton botonCurso = new JButton(curso.getNombre());

        // Acciones cuando hacen clic en el botón
        botonCurso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abrir la ventana de curso con info del curso
                new CursoProfesor(curso).setVisible(true);
                dispose(); // o esconder esta si querés
            }
        });

        // Opcional: estilos parecidos a los de tu imagen
        botonCurso.setBackground(new Color(60, 60, 60));
        botonCurso.setForeground(Color.LIGHT_GRAY);
        botonCurso.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        panelCursos.add(botonCurso);
    }

    panelCursos.revalidate();
    panelCursos.repaint();
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_Salir = new javax.swing.JLabel();
        jLabel_Tablero = new javax.swing.JLabel();
        jLabel_Cursos1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel_BotonesEstu = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(63, 42, 85));
        jPanel2.setForeground(new java.awt.Color(153, 153, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo Ulacit_vSmall.png"))); // NOI18N

        jLabel_Salir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_Salir.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Salir.setText("Salir");
        jLabel_Salir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_SalirMouseClicked(evt);
            }
        });

        jLabel_Tablero.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_Tablero.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Tablero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Tablero.setText("Tablero");
        jLabel_Tablero.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_Tablero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_TableroMouseClicked(evt);
            }
        });

        jLabel_Cursos1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_Cursos1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Cursos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Cursos1.setText("Cursos");
        jLabel_Cursos1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_Cursos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Cursos1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_Tablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_Salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_Cursos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(40, 40, 40)
                .addComponent(jLabel_Tablero, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Cursos1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel1.setText("TABLERO");

        jPanel_BotonesEstu.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_BotonesEstu.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel_BotonesEstu, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jPanel_BotonesEstu, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_SalirMouseClicked
        LogIn In = new LogIn("n");
        In.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_SalirMouseClicked

    private void jLabel_TableroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_TableroMouseClicked
        // TODO add your handling code here:
        this.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_jLabel_TableroMouseClicked

    private void jLabel_Cursos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Cursos1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_Cursos1MouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Cursos1;
    private javax.swing.JLabel jLabel_Salir;
    private javax.swing.JLabel jLabel_Tablero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_BotonesEstu;
    // End of variables declaration//GEN-END:variables
}
