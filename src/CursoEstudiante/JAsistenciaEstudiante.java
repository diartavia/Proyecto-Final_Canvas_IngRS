/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CursoEstudiante;

import General.ArchivoAsistencias;
import General.Asistencia;
import General.Estudiante;
import General.Materia;
import General.Sistema;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JAsistenciaEstudiante extends javax.swing.JFrame {

    /*
            - Nota Developer 1:
        Constructor, en este frame se ve la asisencia de un estudiante en el curso
        this.setLocationRelativeTo(null); hace que la ventana se inicie en el centro

        Después hay botones/labels que permiten moverse a otros frames de la parte del curso como tal del estudiante
        se debe de pasar siempre la materia por el constructor de cada frame con algunas posibles excepciones
    */
    private Materia materia;
    //Constructor
    public JAsistenciaEstudiante(Materia materia) {
          initComponents();
        this.setLocationRelativeTo(null);
        this.materia = materia;
        calcularAsistencia();
    }

    /*
        ------------- Metodo para calcular la asistencia del estudiante
     */
    private void calcularAsistencia() {
        //obtiene el estudiante actual
        Estudiante estudiante = Sistema.getEstudianteActual();
        //Verifica si el estudiante es un null
        if (estudiante == null) {
            JOptionPane.showMessageDialog(this, "Debe iniciar sesión.");
            return;
        }

        // Guarda en un arraylist las asistencias del estudiante
        ArrayList<Asistencia> lista = ArchivoAsistencias.cargar();
        if (lista.isEmpty()) {
            lblPorcentaje.setText("0%");
            lblEstado.setText("Sin registros de asistencia");
            lblEstado.setForeground(Color.BLACK);
            return;
        }

        //Inicializa estas variables que se usan al mostrar la asisencia
        int total = 0;
        int presentes = 0;
        int ausentes = 0;

        //Recorre la lista de asistencia de un estudiante y va agregando 1s a cada una de las variables anteriores
        // segun lo que sea el estado de la asistencia, siempre se suma 1 al total.
        for (Asistencia a : lista) {
            if (a.getIdEstudiante().equals(estudiante.getId()) &&
                materia.contieneEstudiante(estudiante.getId())) {
                total++;
                if (a.getEstado() == Asistencia.EstadoAsistencia.PRESENTE) {
                    presentes++;
                } else if (a.getEstado() == Asistencia.EstadoAsistencia.AUSENTE) {
                    ausentes++;
                }
            }
        }

        //calcula para saber que poner en el label
        if (total == 0) {
            lblPorcentaje.setText("0%");
            lblEstado.setText("Sin registros de asistencia");
            lblEstado.setForeground(Color.BLACK);
            return;
        }

        //Para poner el porcenaje de asistencia
        double porcentaje = (presentes * 100.0) / total;
        lblPorcentaje.setText(String.format("%.1f%%", porcentaje));

        //Si tiene 3 ausencias se pone en el label que perdio la materia, si no no se cambia esta parte del estado
        if (ausentes > 3) {
            lblEstado.setForeground(Color.RED);
            lblEstado.setText("Perdió la materia");
        } else {
            lblEstado.setForeground(Color.BLACK);
            lblEstado.setText("");
        }
    }//Fin metodo

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Menupop = new javax.swing.JPanel();
        jLabel_Modulos = new javax.swing.JLabel();
        jLabel_Anuncios = new javax.swing.JLabel();
        jLabel_PagInicio = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel_Asignaciones = new javax.swing.JLabel();
        jLabel_Calificaciones = new javax.swing.JLabel();
        jLabel_Asignaciones1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblPorcentaje = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_Grupos = new javax.swing.JLabel();
        jLabel_Cursos = new javax.swing.JLabel();
        jLabel_Tablero = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(1586, 1885));
        jPanel2.setName(""); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        Menupop.setBackground(new java.awt.Color(255, 255, 255));

        jLabel_Modulos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel_Modulos.setForeground(new java.awt.Color(153, 153, 153));
        jLabel_Modulos.setText("Modulos");
        jLabel_Modulos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Modulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_ModulosMouseClicked(evt);
            }
        });

        jLabel_Anuncios.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel_Anuncios.setForeground(new java.awt.Color(153, 153, 153));
        jLabel_Anuncios.setText("Anuncios");
        jLabel_Anuncios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Anuncios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_AnunciosMouseClicked(evt);
            }
        });

        jLabel_PagInicio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel_PagInicio.setForeground(new java.awt.Color(153, 153, 153));
        jLabel_PagInicio.setText("Pagina inicio");
        jLabel_PagInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_PagInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_PagInicioMouseClicked(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel_Asignaciones.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel_Asignaciones.setForeground(new java.awt.Color(153, 153, 153));
        jLabel_Asignaciones.setText("Asignaciones");
        jLabel_Asignaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Asignaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_AsignacionesMouseClicked(evt);
            }
        });

        jLabel_Calificaciones.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel_Calificaciones.setForeground(new java.awt.Color(153, 153, 153));
        jLabel_Calificaciones.setText("Calificaciones");
        jLabel_Calificaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Calificaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_CalificacionesMouseClicked(evt);
            }
        });

        jLabel_Asignaciones1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_Asignaciones1.setForeground(new java.awt.Color(63, 42, 85));
        jLabel_Asignaciones1.setText("Asistencias");
        jLabel_Asignaciones1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout MenupopLayout = new javax.swing.GroupLayout(Menupop);
        Menupop.setLayout(MenupopLayout);
        MenupopLayout.setHorizontalGroup(
            MenupopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenupopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenupopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Anuncios)
                    .addComponent(jLabel_Modulos)
                    .addComponent(jLabel_Asignaciones)
                    .addGroup(MenupopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(MenupopLayout.createSequentialGroup()
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel_Asignaciones1))
                        .addComponent(jLabel_Calificaciones))
                    .addComponent(jLabel_PagInicio))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        MenupopLayout.setVerticalGroup(
            MenupopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenupopLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel_PagInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Anuncios)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Modulos)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Asignaciones)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Calificaciones)
                .addGap(18, 18, 18)
                .addGroup(MenupopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenupopLayout.createSequentialGroup()
                        .addComponent(jLabel_Asignaciones1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenupopLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("jLabel5");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Hmenu.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel1.setText("Asistencias");

        jLabel3.setText("Porcentaje de Asistencia:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(Menupop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(Menupop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel3)))
                .addGap(31, 31, 31)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        jLabel4.setText("Profesor");

        lblPorcentaje.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPorcentaje.setText("0%");

        lblEstado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEstado.setText("\"No se ha perdido la materia\"");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(lblPorcentaje))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblEstado)))
                .addGap(737, 737, 737)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addComponent(lblPorcentaje)
                                .addGap(31, 31, 31)
                                .addComponent(lblEstado))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_Tablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_Cursos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_Grupos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addComponent(jLabel_Tablero, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Cursos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Grupos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    /*
       -------                                                                     ----------
       Labels que sirven como botones, los cuales llevan a otras "pestañas" del curso del estudiante
       En todos se crea un objeto del frame, se pone visible y se cierra la ventana actual
       -------                                                                     ----------
    */

    //Este lleva a poder ver los modulos del estudiante
    private void jLabel_ModulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_ModulosMouseClicked
        JModuloEstudiante JME = new JModuloEstudiante(materia);
        JME.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_ModulosMouseClicked

    //Este lleva a poder ver los anuncios del estudiante (por hacer)
    private void jLabel_AnunciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_AnunciosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_AnunciosMouseClicked

    //Este lleva a poder ver la página de inicio donde están todos los cursos
    private void jLabel_PagInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_PagInicioMouseClicked
        CursoEstudiante curso = new CursoEstudiante(materia);
        curso.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_PagInicioMouseClicked

    //Este lleva a poder ver las calificaciones del estudiante
    private void jLabel_CalificacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_CalificacionesMouseClicked
        // TODO add your handling code here:
        JCalificacionesMateria cali = new JCalificacionesMateria(materia);
        cali.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_CalificacionesMouseClicked

    //Este es para el boton del menu desplegable
    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        if (!Menupop.isVisible()) {
            this.Menupop.setVisible(true);
        }else{
            this.Menupop.setVisible(false);
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    //Este lleva a poder ver los grupos del estudiante (No está hecho aún)
    private void jLabel_GruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_GruposMouseClicked

    }//GEN-LAST:event_jLabel_GruposMouseClicked

    //Este lleva a poder ver los cursos del estudiante (No está hecho aún)
    private void jLabel_CursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_CursosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_CursosMouseClicked

    //Este lleva a poder ver los modulos del estudiante
    private void jLabel_TableroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_TableroMouseClicked
        if (materia == null) {
            materia = Sistema.getMateriaDemoPublica(); // o la materia actual del estudiante
        }
        CursoEstudiante cursoEst = new CursoEstudiante(materia);
        cursoEst.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_TableroMouseClicked

    //Este lleva a poder ver las asignaciones del estudiante
    private void jLabel_AsignacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_AsignacionesMouseClicked
        JAsignacionesEstudiante asignacionesEst = new JAsignacionesEstudiante(materia);
        asignacionesEst.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_AsignacionesMouseClicked

        /* Create and display the form */
      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Menupop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_Anuncios;
    private javax.swing.JLabel jLabel_Asignaciones;
    private javax.swing.JLabel jLabel_Asignaciones1;
    private javax.swing.JLabel jLabel_Calificaciones;
    private javax.swing.JLabel jLabel_Cursos;
    private javax.swing.JLabel jLabel_Grupos;
    private javax.swing.JLabel jLabel_Modulos;
    private javax.swing.JLabel jLabel_PagInicio;
    private javax.swing.JLabel jLabel_Tablero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblPorcentaje;
    // End of variables declaration//GEN-END:variables
}
