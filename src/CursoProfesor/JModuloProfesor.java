package CursoProfesor;

import General.*;
import General.VentanaPrincipalProfesor;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class JModuloProfesor extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JModuloProfesor.class.getName());
    Materia mate;
    
    
    public JModuloProfesor(Materia mater) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.mate = mater;
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));
        cargarModulos();
    }
    
    public JModuloProfesor() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.mate = null;
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));
        cargarModulos();
    }
 
        // Método auxiliar para crear un panel de módulo que se expande
    private javax.swing.JPanel crearPanelModulo(General.Modulo modulo) {
        javax.swing.JPanel panelPrincipal = new javax.swing.JPanel();
        panelPrincipal.setLayout(new javax.swing.BoxLayout(panelPrincipal, javax.swing.BoxLayout.Y_AXIS)); // Usamos BoxLayout en Y para apilar todo verticalmente

        // Panel superior con el título y los botones
        javax.swing.JPanel panelCabecera = new javax.swing.JPanel();
        panelCabecera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        panelCabecera.setBackground(new java.awt.Color(255, 255, 255));
        panelCabecera.setLayout(new javax.swing.BoxLayout(panelCabecera, javax.swing.BoxLayout.X_AXIS));
        panelCabecera.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 50)); 

        javax.swing.JLabel labelNombre = new javax.swing.JLabel("  " + modulo.getTitulo());
        labelNombre.setFont(new java.awt.Font("Dialog", 1, 14));

        panelCabecera.add(labelNombre);
        panelCabecera.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(500, 50)));
        panelCabecera.add(javax.swing.Box.createHorizontalGlue());
        panelCabecera.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 50))); 
        
        //Botones
        javax.swing.JButton btnAgregar = new javax.swing.JButton("Agregar");
        javax.swing.JButton btnEditar = new javax.swing.JButton("Editar");
        
        //Acciones
        btnAgregar.addActionListener(e -> {
            JAgregarElementoModulo ag = new JAgregarElementoModulo(modulo, this);
            ag.setVisible(true);
        });

        btnEditar.addActionListener(e -> {
            // Llama al constructor de edición de la clase JAgregarElementoModulo
            JAgregarModulo editor = new JAgregarModulo(modulo, this);
            editor.setVisible(true);
        });
        panelCabecera.add(btnAgregar);
        panelCabecera.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(5, 0))); 
        panelCabecera.add(btnEditar);
        panelCabecera.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(5, 0)));

        panelPrincipal.add(panelCabecera); // Agregamos el panel de la cabecera al panel principal

            // Itera sobre los elementos del módulo y crea un panel para cada uno
        for (General.ObjetoModulo elemento : modulo.getElementos()) {
            panelPrincipal.add(crearPanelElemento(modulo, elemento));
            panelPrincipal.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 5)));
        }

        panelPrincipal.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 10)));

        return panelPrincipal;
    }
    
    
    // Método auxiliar para crear un panel de un elemento dentro de un módulo
    private javax.swing.JPanel crearPanelElemento(General.Modulo modulo, General.ObjetoModulo elemento) {
        javax.swing.JPanel panelElemento = new javax.swing.JPanel();
        panelElemento.setLayout(new javax.swing.BoxLayout(panelElemento, javax.swing.BoxLayout.X_AXIS)); // Cambiado a BoxLayout
        panelElemento.setBackground(new java.awt.Color(245, 245, 245));
        panelElemento.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 20, 5, 5));
        panelElemento.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 40)); 

        javax.swing.JLabel labelIcono = new javax.swing.JLabel();
        javax.swing.JLabel labelTexto = new javax.swing.JLabel(elemento.getTitulo());
        labelTexto.setFont(new java.awt.Font("Dialog", 0, 12));

        if (elemento instanceof General.TextoModulo) {
            labelIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/texto.png")));
        } else if (elemento instanceof General.LinkModulo) {
            labelIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/link.png")));
            labelTexto.setForeground(java.awt.Color.BLUE);
            labelTexto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }

        panelElemento.add(labelIcono);
        panelElemento.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(10, 0)));
        panelElemento.add(labelTexto);
        panelElemento.add(javax.swing.Box.createHorizontalGlue()); // Para empujar el botón a la derecha

        javax.swing.JButton btnEliminarElemento = new javax.swing.JButton("Eliminar");

        // Agrega el ActionListener para eliminar el elemento
        btnEliminarElemento.addActionListener(e -> {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este elemento?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                modulo.getElementos().remove(elemento);
                JOptionPane.showMessageDialog(this, "Elemento eliminado correctamente.");
                cargarModulos(); // Actualiza la interfaz para reflejar el cambio
            }
        });

        panelElemento.add(btnEliminarElemento);
        panelElemento.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(5, 0)));

        return panelElemento;
    }
    // Método para cargar y mostrar todos los módulos de la materia actual
    public void cargarModulos() {
        //Limpia el panel para evitar duplicados
        jPanel3.removeAll();

        //Obtiene la materia del sistema
        Materia materiaActual = Sistema.getMateriaDemoPublica();

        if (materiaActual != null) {
            // Itera sobre la lista de módulos y agrega los paneles
            for (Modulo modulo : materiaActual.getModulos()) {
                jPanel3.add(crearPanelModulo(modulo));
            }
        }

        //Se actualiza la interfaz
        jPanel3.revalidate();
        jPanel3.repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Btn_AgregarModulo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Menupop = new javax.swing.JPanel();
        jLabel_Modulos = new javax.swing.JLabel();
        jLabel_Anuncios = new javax.swing.JLabel();
        jLabel_PagInicio = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel_Asignaciones = new javax.swing.JLabel();
        jLabel_Calificaciones = new javax.swing.JLabel();
        jLabel_Grupos1 = new javax.swing.JLabel();
        jLabel_Asistencias = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_Tablero = new javax.swing.JLabel();
        jLabel_Cursos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Modulo");

        Btn_AgregarModulo.setBackground(new java.awt.Color(255, 255, 255));
        Btn_AgregarModulo.setForeground(new java.awt.Color(0, 0, 0));
        Btn_AgregarModulo.setText("Agregar modulo");
        Btn_AgregarModulo.setBorder(null);
        Btn_AgregarModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AgregarModuloActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setText(".");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(482, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        Menupop.setBackground(new java.awt.Color(255, 255, 255));

        jLabel_Modulos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_Modulos.setForeground(new java.awt.Color(63, 42, 85));
        jLabel_Modulos.setText("Modulos");
        jLabel_Modulos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_Modulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_ModulosMouseClicked(evt);
            }
        });

        jLabel_Anuncios.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel_Anuncios.setForeground(new java.awt.Color(153, 153, 153));
        jLabel_Anuncios.setText("Anuncios");
        jLabel_Anuncios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_Anuncios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_AnunciosMouseClicked(evt);
            }
        });

        jLabel_PagInicio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel_PagInicio.setForeground(new java.awt.Color(153, 153, 153));
        jLabel_PagInicio.setText("Pagina inicio");
        jLabel_PagInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_PagInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_PagInicioMouseClicked(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel_Asignaciones.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel_Asignaciones.setForeground(new java.awt.Color(153, 153, 153));
        jLabel_Asignaciones.setText("Asignaciones");
        jLabel_Asignaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_Asignaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_AsignacionesMouseClicked(evt);
            }
        });

        jLabel_Calificaciones.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel_Calificaciones.setForeground(new java.awt.Color(153, 153, 153));
        jLabel_Calificaciones.setText("Calificaciones");
        jLabel_Calificaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_Calificaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_CalificacionesMouseClicked(evt);
            }
        });

        jLabel_Grupos1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel_Grupos1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel_Grupos1.setText("Grupos");
        jLabel_Grupos1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_Grupos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Grupos1MouseClicked(evt);
            }
        });

        jLabel_Asistencias.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel_Asistencias.setForeground(new java.awt.Color(153, 153, 153));
        jLabel_Asistencias.setText("Asistencias");
        jLabel_Asistencias.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_Asistencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_AsistenciasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MenupopLayout = new javax.swing.GroupLayout(Menupop);
        Menupop.setLayout(MenupopLayout);
        MenupopLayout.setHorizontalGroup(
            MenupopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenupopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenupopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Anuncios)
                    .addGroup(MenupopLayout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_Modulos))
                    .addComponent(jLabel_Asignaciones)
                    .addComponent(jLabel_Calificaciones)
                    .addComponent(jLabel_Grupos1)
                    .addComponent(jLabel_Asistencias)
                    .addComponent(jLabel_PagInicio))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        MenupopLayout.setVerticalGroup(
            MenupopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenupopLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel_PagInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(MenupopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(MenupopLayout.createSequentialGroup()
                        .addComponent(jLabel_Anuncios)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_Modulos))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel_Asignaciones)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Calificaciones)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Grupos1)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Asistencias)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("jLabel5");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Hmenu.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Menupop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(2, 2, 2)
                .addComponent(Menupop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Btn_AgregarModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(13, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_AgregarModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(63, 42, 85));
        jPanel2.setForeground(new java.awt.Color(153, 153, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo Ulacit_vSmall.png"))); // NOI18N

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

        jLabel_Cursos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_Cursos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Cursos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Cursos.setText("Cursos");
        jLabel_Cursos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_Cursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_CursosMouseClicked(evt);
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
                    .addComponent(jLabel_Cursos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Tablero, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Cursos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_TableroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_TableroMouseClicked
        // TODO add your handling code here:
        VentanaPrincipalProfesor VPE = new VentanaPrincipalProfesor();
        VPE.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_TableroMouseClicked

    private void jLabel_CursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_CursosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_CursosMouseClicked

    private void Btn_AgregarModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AgregarModuloActionPerformed
        Materia materiaActual = Sistema.getMateriaDemoPublica();
        JAgregarModulo ag = new JAgregarModulo(materiaActual, this); // Pasa 'this'
        ag.setVisible(true);
    }//GEN-LAST:event_Btn_AgregarModuloActionPerformed

    private void jLabel_ModulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_ModulosMouseClicked
        JModuloProfesor mp = new JModuloProfesor(mate);
        mp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_ModulosMouseClicked

    private void jLabel_AnunciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_AnunciosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_AnunciosMouseClicked

    private void jLabel_PagInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_PagInicioMouseClicked
        CursoProfesor cursoP = new CursoProfesor(mate); // ✅ materia actual
        cursoP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_PagInicioMouseClicked

    private void jLabel_AsignacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_AsignacionesMouseClicked
        JAsignaciones asignaciones = new JAsignaciones(mate);
        asignaciones.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_AsignacionesMouseClicked

    private void jLabel_CalificacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_CalificacionesMouseClicked
        if (mate != null) {
            JCalificacionesProfe califica = new JCalificacionesProfe(mate);
            califica.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error: No hay materia seleccionada.\n"
                + " vuelva al panel de inicio");
        }
    }//GEN-LAST:event_jLabel_CalificacionesMouseClicked

    private void jLabel_Grupos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Grupos1MouseClicked
        JGrupo grupo = new JGrupo(mate);
        grupo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_Grupos1MouseClicked

    private void jLabel_AsistenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_AsistenciasMouseClicked
        JAsistencia asistencias = new JAsistencia(mate);
        asistencias.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_AsistenciasMouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        if (!Menupop.isVisible()) {
            this.Menupop.setVisible(true);
        }else{
            this.Menupop.setVisible(false);
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new JModuloProfesor().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_AgregarModulo;
    private javax.swing.JPanel Menupop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_Anuncios;
    private javax.swing.JLabel jLabel_Asignaciones;
    private javax.swing.JLabel jLabel_Asistencias;
    private javax.swing.JLabel jLabel_Calificaciones;
    private javax.swing.JLabel jLabel_Cursos;
    private javax.swing.JLabel jLabel_Grupos1;
    private javax.swing.JLabel jLabel_Modulos;
    private javax.swing.JLabel jLabel_PagInicio;
    private javax.swing.JLabel jLabel_Tablero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
