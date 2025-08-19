package CursoProfesor;

import General.Materia;
import General.VentanaPrincipalProfesor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class JCreaAsignaciones extends javax.swing.JFrame {

    /*
            - Nota Developer 1:
        Frame para crear las asignaciones de los estudiantes siendo profesor
        this.setLocationRelativeTo(null); hace que la ventana se inicie en el centro

        Después hay botones/labels que permiten moverse a otros frames de la parte de CursoProfesor
        se debe de pasar siempre la materia por el constructor de cada frame
    */
    Materia mate;
    public JCreaAsignaciones(Materia mate) {
        initComponents();
        cargarTareasDesdeArchivo();
        this.setLocationRelativeTo(null);
        this.mate=mate;
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_Subir = new javax.swing.JButton();
        btn_Ver = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Menupop = new javax.swing.JPanel();
        jLabel_Tareas = new javax.swing.JLabel();
        jLabel_Modulos = new javax.swing.JLabel();
        jLabel_Anuncios = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel_PagInicio = new javax.swing.JLabel();
        jLabel_Calificaciones1 = new javax.swing.JLabel();
        jLabel_Grupos = new javax.swing.JLabel();
        jLabel_Asistencias = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        LabelT = new javax.swing.JLabel();
        LabelFe = new javax.swing.JLabel();
        LabelFi = new javax.swing.JLabel();
        LabelPun = new javax.swing.JLabel();
        LabelDesc = new javax.swing.JLabel();
        NombreTarea = new javax.swing.JTextField();
        FechaInicio = new javax.swing.JTextField();
        FechaFinal = new javax.swing.JTextField();
        Puntos = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Descripcion = new javax.swing.JTextArea();
        jScrollBar1 = new javax.swing.JScrollBar();
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

        jLabel1.setText("Pagina de inicio");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btn_Subir.setBackground(new java.awt.Color(238, 238, 238));
        btn_Subir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Subir.setText("Subir Asignacion");
        btn_Subir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SubirActionPerformed(evt);
            }
        });

        btn_Ver.setBackground(new java.awt.Color(238, 238, 238));
        btn_Ver.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Ver.setText("Ver Asignaciones Creadas");
        btn_Ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Subir)
                .addGap(94, 94, 94)
                .addComponent(btn_Ver)
                .addContainerGap(423, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(302, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Subir, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_Ver, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Crear Tarea");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        Menupop.setBackground(new java.awt.Color(255, 255, 255));

        jLabel_Tareas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_Tareas.setForeground(new java.awt.Color(63, 42, 85));
        jLabel_Tareas.setText("Asignaciones");
        jLabel_Tareas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_Tareas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_TareasMouseClicked(evt);
            }
        });

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

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel_PagInicio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel_PagInicio.setForeground(new java.awt.Color(153, 153, 153));
        jLabel_PagInicio.setText("Pagina inicio");
        jLabel_PagInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_PagInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_PagInicioMouseClicked(evt);
            }
        });

        jLabel_Calificaciones1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel_Calificaciones1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel_Calificaciones1.setText("Calificaciones");
        jLabel_Calificaciones1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_Calificaciones1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Calificaciones1MouseClicked(evt);
            }
        });

        jLabel_Grupos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel_Grupos.setForeground(new java.awt.Color(153, 153, 153));
        jLabel_Grupos.setText("Grupos");
        jLabel_Grupos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Grupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_GruposMouseClicked(evt);
            }
        });

        jLabel_Asistencias.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel_Asistencias.setForeground(new java.awt.Color(153, 153, 153));
        jLabel_Asistencias.setText("Asistencias");
        jLabel_Asistencias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout MenupopLayout = new javax.swing.GroupLayout(Menupop);
        Menupop.setLayout(MenupopLayout);
        MenupopLayout.setHorizontalGroup(
            MenupopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenupopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenupopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenupopLayout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MenupopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_PagInicio)
                            .addComponent(jLabel_Anuncios)
                            .addComponent(jLabel_Modulos)
                            .addComponent(jLabel_Tareas)))
                    .addGroup(MenupopLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(MenupopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Asistencias)
                            .addComponent(jLabel_Grupos)
                            .addComponent(jLabel_Calificaciones1))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        MenupopLayout.setVerticalGroup(
            MenupopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenupopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_PagInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Anuncios)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Modulos)
                .addGap(18, 18, 18)
                .addGroup(MenupopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Tareas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Calificaciones1)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Grupos)
                .addGap(12, 12, 12)
                .addComponent(jLabel_Asistencias)
                .addContainerGap(55, Short.MAX_VALUE))
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
                    .addComponent(jLabel8)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Menupop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        LabelT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelT.setText("Nombre de la Tarea:");

        LabelFe.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelFe.setText("Fecha de inicio:");

        LabelFi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelFi.setText("Fecha Final:");

        LabelPun.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelPun.setText("Puntos:");

        LabelDesc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelDesc.setText("Descripción:");

        NombreTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreTareaActionPerformed(evt);
            }
        });

        FechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaInicioActionPerformed(evt);
            }
        });

        FechaFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaFinalActionPerformed(evt);
            }
        });

        Puntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PuntosActionPerformed(evt);
            }
        });

        Descripcion.setColumns(20);
        Descripcion.setRows(5);
        jScrollPane1.setViewportView(Descripcion);

        jScrollBar1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelFe)
                            .addComponent(LabelFi)
                            .addComponent(LabelPun)
                            .addComponent(LabelDesc)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(NombreTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Puntos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                .addComponent(FechaFinal, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(FechaInicio, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(38, 38, 38)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(638, 638, 638)
                        .addComponent(jButton2))
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(LabelT))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jButton2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(75, 75, 75)
                                .addComponent(jLabel3)
                                .addGap(32, 32, 32)
                                .addComponent(LabelT)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(NombreTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(LabelFe)
                                        .addGap(9, 9, 9)
                                        .addComponent(FechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LabelFi)
                                        .addGap(8, 8, 8)
                                        .addComponent(FechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(LabelPun)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Puntos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addComponent(LabelDesc)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jScrollPane1)))
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                .addGap(36, 36, 36)
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
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 591, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //datos
    private final String archivoTareas = "tareas.txt";

    // Método para cargar las tareas almacenadas en un archivo de texto
    private void cargarTareasDesdeArchivo() {
        File archivo = new File(archivoTareas); // Se crea una referencia al archivo de tareas
        if (!archivo.exists()) return; // Si el archivo no existe, no se hace nada

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            // Leer línea por línea el archivo
            while ((linea = br.readLine()) != null) {
                // Convierte la línea en un objeto Asignacion
                Asignacion tarea = Asignacion.fromFileString(linea);

                // Si la tarea se pudo crear, existe una materia y la tarea aún no está registrada en esa materia
                if (tarea != null && mate != null && !mate.getAsignaciones().contains(tarea)) {
                    mate.agregarAsignaciones(tarea); // Se agrega la tarea a la lista de la materia
                }
            }
        } catch (Exception e) {
            // Si ocurre algún error al leer, muestra mensaje de error
            JOptionPane.showMessageDialog(this, "Error cargando tareas: " + e.getMessage());
        }
    }

    // Método para guardar una tarea en el archivo de texto
    private void guardarTareaEnArchivo(Asignacion tarea) {
        try (
                FileWriter fw = new FileWriter(archivoTareas, true); // true -> para no sobrescribir
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)
        ) {
            out.println(tarea.toFileString()); // Escribe la tarea como string en el archivo
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error guardando archivo: " + e.getMessage());
        }
    }

    /**
     -------                                                                     ----------
     Labels que sirven como botones, los cuales llevan a otras "pestañas" de CursoEstudiante
     En todos se crea un objeto del frame, se pone visible y se cierra la ventana actual
     -------                                                                     ----------
     */
    // Evento del campo de texto "NombreTarea"
    private void NombreTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreTareaActionPerformed
        // TODO add your handling code here: (aún no se implementa lógica)
    }//GEN-LAST:event_NombreTareaActionPerformed

    // Evento al hacer clic en "Calificaciones"
    private void jLabel_Calificaciones1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Calificaciones1MouseClicked
        JCalificacionesProfe califica = new JCalificacionesProfe(mate); // Abre ventana de calificaciones
        califica.setVisible(true);
        this.dispose(); // Cierra la ventana actual
    }//GEN-LAST:event_jLabel_Calificaciones1MouseClicked

    // Evento al hacer clic en "Página de Inicio"
    private void jLabel_PagInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_PagInicioMouseClicked
        if (mate != null) {
            CursoProfesor cursoP = new CursoProfesor(mate); // Abre curso del profesor con la materia actual
            cursoP.setVisible(true);
            this.dispose(); // Cierra la ventana actual
        } else {
            JOptionPane.showMessageDialog(this, "Error: No hay materia asociada."); // Validación si mate es null
        }
    }//GEN-LAST:event_jLabel_PagInicioMouseClicked

    // Evento al hacer clic en "Anuncios"
    private void jLabel_AnunciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_AnunciosMouseClicked
        // TODO add your handling code here: (pendiente implementación)
    }//GEN-LAST:event_jLabel_AnunciosMouseClicked

    // Evento al hacer clic en "Módulos"
    private void jLabel_ModulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_ModulosMouseClicked
        JModuloProfesor mp = new JModuloProfesor(mate); // Abre ventana de módulos
        mp.setVisible(true);
        this.dispose(); // Cierra la ventana actual
    }//GEN-LAST:event_jLabel_ModulosMouseClicked

    // Evento al hacer clic en "Tareas"
    private void jLabel_TareasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_TareasMouseClicked
        JCreaAsignaciones VentanaTareas = new JCreaAsignaciones(mate); // Abre ventana para crear asignaciones
        VentanaTareas.setVisible(true);
    }
    // Botón para ver las asignaciones
    private void btn_VerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VerActionPerformed
        JAsignaciones ventanaAsignaciones = new JAsignaciones(mate); // Abre ventana de asignaciones
        ventanaAsignaciones.setVisible(true);
        this.dispose(); // Cierra la ventana actual
    }//GEN-LAST:event_btn_VerActionPerformed

    // Botón para subir/crear una tarea nueva
    private void btn_SubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SubirActionPerformed
        try {
            // Se obtienen los valores ingresados en los campos de texto
            String nombre = NombreTarea.getText().trim();
            String fechaInicio = FechaInicio.getText().trim();
            String fechaFinal = FechaFinal.getText().trim();
            String descripcion = Descripcion.getText().trim();
            int puntos = Integer.parseInt(Puntos.getText().trim());

            // Validación: no permitir campos vacíos
            if (nombre.isEmpty() || fechaInicio.isEmpty() || fechaFinal.isEmpty() || descripcion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, llena todos los campos.");
                return;
            }

            // Crear una nueva tarea con los datos ingresados
            Asignacion nuevaTarea = new Asignacion(nombre, fechaInicio, fechaFinal, puntos, descripcion);

            if (mate != null) {
                // Validación: evitar duplicados
                if (!mate.getAsignaciones().contains(nuevaTarea)) {
                    mate.agregarAsignaciones(nuevaTarea); // Se agrega a la materia
                    guardarTareaEnArchivo(nuevaTarea); // También se guarda en archivo
                    JOptionPane.showMessageDialog(this, "Tarea guardada correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Ya existe una tarea con ese nombre.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error: No hay materia asociada."); // Validación si mate es null
                return;
            }

            // Limpiar los campos del formulario
            NombreTarea.setText("");
            FechaInicio.setText("");
            FechaFinal.setText("");
            Puntos.setText("");
            Descripcion.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Los puntos deben ser un número entero."); // Validación de tipo
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al crear la tarea: " + e.getMessage()); // Otros errores
        }
    }//GEN-LAST:event_btn_SubirActionPerformed

    // Evento del campo "Fecha de Inicio"
    private void FechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaInicioActionPerformed

    // Evento del campo "Fecha Final"
    private void FechaFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaFinalActionPerformed

    // Evento del campo "Puntos"
    private void PuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PuntosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PuntosActionPerformed

    // Evento al hacer clic en "Tablero"
    private void jLabel_TableroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_TableroMouseClicked
        VentanaPrincipalProfesor VPE = new VentanaPrincipalProfesor(); // Abre ventana principal del profesor
        VPE.setVisible(true);
        this.dispose(); // Cierra ventana actual
    }//GEN-LAST:event_jLabel_TableroMouseClicked

    // Evento al hacer clic en "Cursos"
    private void jLabel_CursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_CursosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_CursosMouseClicked

    // Evento al hacer clic en el ícono de menú (mostrar/ocultar menú desplegable)
    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        if (!Menupop.isVisible()) {
            this.Menupop.setVisible(true); // Muestra menú
        } else {
            this.Menupop.setVisible(false); // Oculta menú
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    // Evento al hacer clic en "Grupos"
    private void jLabel_GruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_GruposMouseClicked
        // TODO add your handling code here: (pendiente implementación)
    }//GEN-LAST:event_jLabel_GruposMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Descripcion;
    private javax.swing.JTextField FechaFinal;
    private javax.swing.JTextField FechaInicio;
    private javax.swing.JLabel LabelDesc;
    private javax.swing.JLabel LabelFe;
    private javax.swing.JLabel LabelFi;
    private javax.swing.JLabel LabelPun;
    private javax.swing.JLabel LabelT;
    private javax.swing.JPanel Menupop;
    private javax.swing.JTextField NombreTarea;
    private javax.swing.JTextField Puntos;
    private javax.swing.JButton btn_Subir;
    private javax.swing.JButton btn_Ver;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_Anuncios;
    private javax.swing.JLabel jLabel_Asistencias;
    private javax.swing.JLabel jLabel_Calificaciones1;
    private javax.swing.JLabel jLabel_Cursos;
    private javax.swing.JLabel jLabel_Grupos;
    private javax.swing.JLabel jLabel_Grupos1;
    private javax.swing.JLabel jLabel_Modulos;
    private javax.swing.JLabel jLabel_PagInicio;
    private javax.swing.JLabel jLabel_Tablero;
    private javax.swing.JLabel jLabel_Tareas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
