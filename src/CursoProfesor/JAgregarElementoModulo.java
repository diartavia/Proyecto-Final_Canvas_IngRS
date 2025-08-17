package CursoProfesor;

import General.*;
import javax.swing.JOptionPane;

public class JAgregarElementoModulo extends javax.swing.JFrame {

    /*
            - Nota Developer 1:
        Frame para agregar elementos al modulo
        this.setLocationRelativeTo(null); hace que la ventana se inicie en el centro
    */
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JAgregarElementoModulo.class.getName());
    private Modulo moduloActual;
    private JModuloProfesor ventanaPrincipal;
    //Constructor
    public JAgregarElementoModulo(Modulo modulo, JModuloProfesor ventanaPrincipal) {
        this.moduloActual = modulo;
        this.ventanaPrincipal = ventanaPrincipal;
        initComponents();
        this.setLocationRelativeTo(null); // Centra la ventana

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoCB = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCB_Texto = new javax.swing.JCheckBox();
        jCB_Link = new javax.swing.JCheckBox();
        TF_Titulo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxtA_Contenido = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Agregar elemento");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Titulo");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tipo");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Contenido");

        tipoCB.add(jCB_Texto);
        jCB_Texto.setText("Texto");

        tipoCB.add(jCB_Link);
        jCB_Link.setText("Link");

        jTxtA_Contenido.setColumns(20);
        jTxtA_Contenido.setRows(5);
        jScrollPane1.setViewportView(jTxtA_Contenido);

        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCB_Texto, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCB_Link, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TF_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TF_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jCB_Texto)
                    .addComponent(jCB_Link))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Obtener el título ingresado en el campo de texto y eliminar espacios en blanco
        String titulo = TF_Titulo.getText().trim();

        // Obtener el contenido ingresado en el área de texto y eliminar espacios en blanco
        String contenido = jTxtA_Contenido.getText().trim();

        // Validar que los campos no estén vacíos
        if (titulo.isEmpty() || contenido.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe completar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Sale del método si faltan datos
        }

        // Determinar qué tipo de elemento crear según la opción seleccionada
        if (jCB_Texto.isSelected()) {
            // Si se selecciona "Texto", se crea un objeto de tipo TextoModulo
            TextoModulo nuevoElemento = new TextoModulo(titulo, contenido);
            moduloActual.agregarObjeto(nuevoElemento); // Se agrega al módulo actual
        } else if (jCB_Link.isSelected()) {
            // Si se selecciona "Link", se crea un objeto de tipo LinkModulo
            LinkModulo nuevoElemento = new LinkModulo(titulo, contenido);
            moduloActual.agregarObjeto(nuevoElemento); // Se agrega al módulo actual
        } else {
            // Si no se seleccionó ninguna opción, se muestra un error
            JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de elemento (Texto o Link).", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Sale del método sin agregar nada
        }

        // Mensaje de confirmación al usuario
        JOptionPane.showMessageDialog(this, "Elemento agregado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        // Actualizar la vista de la ventana principal y cerrar esta ventana
        ventanaPrincipal.cargarModulos(); // Refresca los paneles en la ventana principal
        this.dispose(); // Cierra la ventana actual
    }//GEN-LAST:event_jButton1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TF_Titulo;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCB_Link;
    private javax.swing.JCheckBox jCB_Texto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTxtA_Contenido;
    private javax.swing.ButtonGroup tipoCB;
    // End of variables declaration//GEN-END:variables
}
