package CursoProfesor;

import General.Materia;
import General.VentanaPrincipalProfesor;
import java.io.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JAsignaciones extends javax.swing.JFrame {
    Materia mate;

    public JAsignaciones(Materia mate) {
        initComponents();
        this.setLocationRelativeTo(null);

        if (mate == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: No se asignó una materia.");
            dispose();
            return;
        }

            this.mate = mate;
            cargarTablaAsignaciones(); // solo si la materia es válida
    }
    

    
public void cargarTablaAsignaciones() {
    if (mate == null) return; // Seguridad por si no está asignada

    List<Asignacion> listaTareas = mate.getAsignaciones(); // ✅ Usa las tareas de la materia actual

    DefaultTableModel model = (DefaultTableModel) AsignacionesCreadasTable.getModel();
    model.setRowCount(0); // Limpiar tabla

    for (Asignacion tarea : listaTareas) {
        Object[] fila = {
            tarea.getNombre(),
            tarea.getFechaFinal(),
            tarea.getPuntos()
        };
        model.addRow(fila);
    }
}

private class EditarTareaDialog extends javax.swing.JDialog {
    private boolean confirmado = false;
    private Asignacion tareaEditada;

    private javax.swing.JTextField campoNombre, campoInicio, campoFinal, campoPuntos;
    private javax.swing.JTextArea campoDescripcion;
    private javax.swing.JButton btnConfirmar;

    public EditarTareaDialog(java.awt.Frame parent, Asignacion tarea, int index) {
        super(parent, "Editar Tarea", true);
        setSize(450, 400);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(java.awt.Color.WHITE);
        setLayout(new java.awt.GridBagLayout());

        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(10, 10, 5, 10);
        gbc.anchor = java.awt.GridBagConstraints.WEST;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        java.awt.Font labelFont = new java.awt.Font("Dialog", java.awt.Font.BOLD, 14);
        java.awt.Font inputFont = new java.awt.Font("Dialog", java.awt.Font.PLAIN, 13);

        // Campos
        add(new JLabel("Nombre:", JLabel.LEFT) {{
            setFont(labelFont);
        }}, gbc);

        campoNombre = new JTextField(tarea.getNombre());
        campoNombre.setFont(inputFont);
        gbc.gridy++;
        add(campoNombre, gbc);

        gbc.gridy++;
        add(new JLabel("Fecha Inicio:", JLabel.LEFT) {{
            setFont(labelFont);
        }}, gbc);

        campoInicio = new JTextField(tarea.getFechaInicio());
        campoInicio.setFont(inputFont);
        gbc.gridy++;
        add(campoInicio, gbc);

        gbc.gridy++;
        add(new JLabel("Fecha Final:", JLabel.LEFT) {{
            setFont(labelFont);
        }}, gbc);

        campoFinal = new JTextField(tarea.getFechaFinal());
        campoFinal.setFont(inputFont);
        gbc.gridy++;
        add(campoFinal, gbc);

        gbc.gridy++;
        add(new JLabel("Puntos:", JLabel.LEFT) {{
            setFont(labelFont);
        }}, gbc);

        campoPuntos = new JTextField(String.valueOf(tarea.getPuntos()));
        campoPuntos.setFont(inputFont);
        gbc.gridy++;
        add(campoPuntos, gbc);

        gbc.gridy++;
        add(new JLabel("Descripción:", JLabel.LEFT) {{
            setFont(labelFont);
        }}, gbc);

        campoDescripcion = new JTextArea(tarea.getDescripcion(), 4, 20);
        campoDescripcion.setFont(inputFont);
        campoDescripcion.setLineWrap(true);
        campoDescripcion.setWrapStyleWord(true);

        gbc.gridy++;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = java.awt.GridBagConstraints.BOTH;
        add(new JScrollPane(campoDescripcion), gbc);

        // Botón confirmar
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBackground(new java.awt.Color(63, 42, 85));
        btnConfirmar.setForeground(java.awt.Color.WHITE);
        btnConfirmar.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 13));
        btnConfirmar.setFocusPainted(false);
        btnConfirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        gbc.gridy++;
        gbc.fill = java.awt.GridBagConstraints.NONE;
        gbc.anchor = java.awt.GridBagConstraints.CENTER;
        gbc.weighty = 0;
        add(btnConfirmar, gbc);

        btnConfirmar.addActionListener(e -> {
            try {
                int puntos = Integer.parseInt(campoPuntos.getText());
                tareaEditada = new Asignacion(
                    campoNombre.getText(),
                    campoInicio.getText(),
                    campoFinal.getText(),
                    puntos,
                    campoDescripcion.getText()
                );
                confirmado = true;
                dispose();
            } catch (NumberFormatException ex) {
                javax.swing.JOptionPane.showMessageDialog(this, "Los puntos deben ser un número entero.");
            }
        });
    }

    public boolean fueConfirmado() {
        return confirmado;
    }

    public Asignacion getTareaEditada() {
        return tareaEditada;
    }
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_editar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        Menupop = new javax.swing.JPanel();
        jLabel_Modulos = new javax.swing.JLabel();
        jLabel_Anuncios = new javax.swing.JLabel();
        jLabel_PagInicio = new javax.swing.JLabel();
        jLabel_Asignaciones = new javax.swing.JLabel();
        jLabel_Calificaciones = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel_Grupos1 = new javax.swing.JLabel();
        jLabel_Asistencias = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        AsignacionesCreadasTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_Tablero = new javax.swing.JLabel();
        jLabel_Cursos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(1586, 1885));
        jPanel2.setName(""); // NOI18N

        jButton2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton2.setText("Editar");
        jButton2.setBorder(null);

        jLabel1.setText("Asignaciones");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(562, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(358, Short.MAX_VALUE)
                .addComponent(btn_editar)
                .addGap(230, 230, 230))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        Menupop.setBackground(new java.awt.Color(255, 255, 255));

        jLabel_Modulos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel_Modulos.setForeground(new java.awt.Color(153, 153, 153));
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

        jLabel_Asignaciones.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_Asignaciones.setForeground(new java.awt.Color(63, 42, 85));
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

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel_Grupos1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel_Grupos1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel_Grupos1.setText("Grupos");
        jLabel_Grupos1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Grupos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Grupos1MouseClicked(evt);
            }
        });

        jLabel_Asistencias.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel_Asistencias.setForeground(new java.awt.Color(153, 153, 153));
        jLabel_Asistencias.setText("Asistencias");
        jLabel_Asistencias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MenupopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Grupos1)
                    .addComponent(jLabel_Asistencias)
                    .addComponent(jLabel_Anuncios)
                    .addComponent(jLabel_Modulos)
                    .addComponent(jLabel_Asignaciones)
                    .addComponent(jLabel_Calificaciones)
                    .addComponent(jLabel_PagInicio))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        MenupopLayout.setVerticalGroup(
            MenupopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenupopLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel_PagInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Anuncios)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Modulos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MenupopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Asignaciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Calificaciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel_Grupos1)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Asistencias)
                .addContainerGap())
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
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(185, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Asignaciones ");

        jLabel4.setText("No se ha escrito una descripción");

        AsignacionesCreadasTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Fecha Final", "Puntos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AsignacionesCreadasTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(AsignacionesCreadasTable);

        jScrollPane4.setViewportView(jScrollPane3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(722, 722, 722)
                        .addComponent(jButton2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jButton2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(63, 42, 85));
        jPanel1.setForeground(new java.awt.Color(153, 153, 255));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_Tablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_Cursos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 897, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_CalificacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_CalificacionesMouseClicked
        JCalificacionesProfe califica = new JCalificacionesProfe(mate);
        califica.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_CalificacionesMouseClicked

    private void jLabel_AsignacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_AsignacionesMouseClicked
        // TODO add your handling code here:
        JCreaAsignaciones CA = new JCreaAsignaciones(mate);
        CA.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_AsignacionesMouseClicked

    private void jLabel_PagInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_PagInicioMouseClicked
        // TODO add your handling code here:
        CursoProfesor CursoP = new CursoProfesor(mate);
        CursoP.setVisible(true);
        this.dispose();
        //Redirigir a otra pantalla
    }//GEN-LAST:event_jLabel_PagInicioMouseClicked

    private void jLabel_AnunciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_AnunciosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_AnunciosMouseClicked

    private void jLabel_ModulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_ModulosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_ModulosMouseClicked

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        int filaSeleccionada = AsignacionesCreadasTable.getSelectedRow();
        if (filaSeleccionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(null, "Selecciona una asignación para editar.");
            return;
        }

        // Cargar la lista de tareas
        List<Asignacion> listaTareas = mate.getAsignaciones();
        Asignacion tareaSeleccionada = listaTareas.get(filaSeleccionada);

        // Mostrar diálogo para editar
        EditarTareaDialog dialogo = new EditarTareaDialog(this, tareaSeleccionada, filaSeleccionada);
        dialogo.setVisible(true);

        // Si se confirmó la edición, recargar archivo y tabla
        if (dialogo.fueConfirmado()) {
            listaTareas.set(filaSeleccionada, dialogo.getTareaEditada());
            Asignacion.guardarTareas(listaTareas);
            cargarTablaAsignaciones();
        }
    }//GEN-LAST:event_btn_editarActionPerformed

    private void jLabel_TableroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_TableroMouseClicked
        // TODO add your handling code here:
        VentanaPrincipalProfesor VPE = new VentanaPrincipalProfesor();
        VPE.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_TableroMouseClicked

    private void jLabel_CursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_CursosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_CursosMouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        if (!Menupop.isVisible()) {
            this.Menupop.setVisible(true);
        }else{
            this.Menupop.setVisible(false);
        }
    }//GEN-LAST:event_jLabel8MouseClicked

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JAsignaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JAsignaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JAsignaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JAsignaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AsignacionesCreadasTable;
    private javax.swing.JPanel Menupop;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
