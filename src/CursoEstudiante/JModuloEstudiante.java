package CursoEstudiante;

import General.LinkModulo;
import General.Materia;
import General.Modulo;
import General.ObjetoModulo;
import General.TextoModulo;
import General.VentanaPrincipalEstudiante;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JModuloEstudiante extends javax.swing.JFrame {

    /*
        - Nota Developer 1:
        Clase para la interfaz gráfica que muestra los módulos de una materia para un estudiante.
        Esta clase construye dinámicamente la interfaz de usuario con paneles anidados.
        En este frame, el estudiante ve el contenido de la materia organizado en módulos.
        Se usa **BoxLayout** para una alineación vertical, y **Box.createRigidArea**
        para agregar espaciado entre los componentes, lo que ayuda a organizar la UI.
     */
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JModuloEstudiante.class.getName());
    private Materia materiaActual;

    // Constructor principal
    public JModuloEstudiante(Materia materia) {
        // Asigna el objeto 'materia' pasado al constructor a la variable de instancia.
        this.materiaActual = materia;
        // Inicializa los componentes de la interfaz de usuario creados por el diseñador.
        initComponents();
        // Centra la ventana en la pantalla.
        this.setLocationRelativeTo(null);
        // Llama al método para cargar los módulos de la materia.
        this.cargarModulos();
    }


    /*
        Método para cargar dinámicamente los módulos de la materia en el panel
     */
    public void cargarModulos() {
        // Elimina todos los componentes existentes en el panel, asegurando que no haya duplicados.
        jPanel5.removeAll();
        // Establece el gestor de diseño para que los componentes se apilen verticalmente.
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.Y_AXIS));

        // Verifica que la materia y sus módulos no sean nulos antes de intentar iterar.
        if (materiaActual != null && materiaActual.getModulos() != null) {
            // Itera sobre cada 'Modulo' en la lista de módulos de la materia.
            for (Modulo modulo : materiaActual.getModulos()) {
                // Llama al método auxiliar para crear un panel para cada módulo.
                JPanel panelModulo = crearPanelModulo(modulo);
                // Alinea el panel del módulo a la izquierda dentro del BoxLayout.
                panelModulo.setAlignmentX(Component.LEFT_ALIGNMENT);
                // Agrega el panel del módulo al panel principal.
                jPanel5.add(panelModulo);
                // Agrega un espacio rígido de 15 píxeles de altura para separar los módulos.
                jPanel5.add(Box.createRigidArea(new java.awt.Dimension(0, 15)));
            }
        }

        // Vuelve a calcular el diseño del panel para que los nuevos componentes sean visibles.
        jPanel5.revalidate();
        // Vuelve a pintar el panel para actualizar la interfaz gráfica.
        jPanel5.repaint();
    }

    /*
        Método auxiliar para crear un panel visual para un 'Modulo' específico.
     */
    private JPanel crearPanelModulo(Modulo modulo) {
        JPanel panelPrincipal = new JPanel();
        // Usa BoxLayout vertical para apilar los elementos del módulo.
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        // Agrega un borde para delimitar visualmente el panel del módulo.
        panelPrincipal.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        // Etiqueta para el título del módulo.
        JLabel labelNombre = new JLabel("  " + modulo.getTitulo());
        labelNombre.setFont(new java.awt.Font("Dialog", 1, 14));
        panelPrincipal.add(Box.createRigidArea(new java.awt.Dimension(0, 5)));
        panelPrincipal.add(labelNombre);
        panelPrincipal.add(Box.createRigidArea(new java.awt.Dimension(400, 5)));

        // Recorre la lista de elementos (Texto, Link, etc.) dentro del módulo.
        for (ObjetoModulo elemento : modulo.getElementos()) {
            // Llama a otro método auxiliar para crear el panel de cada elemento.
            panelPrincipal.add(crearPanelElemento(elemento));
            panelPrincipal.add(Box.createRigidArea(new java.awt.Dimension(0, 5)));
        }

        return panelPrincipal;
    }

    /*
     Método auxiliar para crear un panel visual para un 'ObjetoModulo' específico.
     */
    private JPanel crearPanelElemento(ObjetoModulo elemento) {
        JPanel panelElemento = new JPanel();
        // Usa BoxLayout horizontal para colocar el ícono y el texto en la misma línea.
        panelElemento.setLayout(new BoxLayout(panelElemento, BoxLayout.X_AXIS));
        panelElemento.setBackground(new java.awt.Color(245, 245, 245));
        // Establece un borde vacío para crear espacio interno.
        panelElemento.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 5));

        JLabel labelIcono = new JLabel();
        JLabel labelTexto = new JLabel(elemento.getTitulo());
        labelTexto.setFont(new java.awt.Font("Dialog", 0, 12));

        // Comprueba el tipo de objeto para asignar el ícono y el comportamiento correctos.
        if (elemento instanceof TextoModulo) {
            // Si es un objeto de texto, carga el ícono de texto.
            labelIcono.setIcon(new ImageIcon(getClass().getResource("/Imagenes/texto.png")));
            // Aquí se debería añadir la lógica para mostrar el contenido del texto.
        } else if (elemento instanceof LinkModulo) {
            // Si es un objeto de enlace, carga el ícono de enlace.
            labelIcono.setIcon(new ImageIcon(getClass().getResource("/Imagenes/link.png")));
            // Cambia el color del texto a azul y el cursor a una mano para indicar que es un enlace.
            labelTexto.setForeground(java.awt.Color.BLUE);
            labelTexto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            // Aquí se debería añadir la lógica para abrir el enlace.
        }

        panelElemento.add(labelIcono);
        panelElemento.add(Box.createRigidArea(new java.awt.Dimension(10, 0))); // Espacio entre ícono y texto.
        panelElemento.add(labelTexto);
        panelElemento.add(Box.createHorizontalGlue()); // Empuja los componentes a la izquierda, llenando el espacio restante.

        return panelElemento;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel_Grupos = new javax.swing.JLabel();
        jLabel_Cursos = new javax.swing.JLabel();
        jLabel_Tablero = new javax.swing.JLabel();
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
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(1586, 1885));
        jPanel2.setName(""); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 314, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        Menupop.setBackground(new java.awt.Color(255, 255, 255));

        jLabel_Modulos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_Modulos.setForeground(new java.awt.Color(63, 42, 85));
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

        jLabel_Asignaciones1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel_Asignaciones1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel_Asignaciones1.setText("Asistencias");
        jLabel_Asignaciones1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Asignaciones1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Asignaciones1MouseClicked(evt);
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
                    .addComponent(jLabel_Asignaciones)
                    .addComponent(jLabel_Calificaciones)
                    .addGroup(MenupopLayout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel_Modulos))
                    .addComponent(jLabel_PagInicio)
                    .addComponent(jLabel_Asignaciones1))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        MenupopLayout.setVerticalGroup(
            MenupopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenupopLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel_PagInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(MenupopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenupopLayout.createSequentialGroup()
                        .addComponent(jLabel_Anuncios)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_Modulos))
                    .addGroup(MenupopLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Asignaciones)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Calificaciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Asignaciones1)
                .addContainerGap(12, Short.MAX_VALUE))
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

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Modulos");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(84, 84, 84)
                        .addComponent(jLabel1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Menupop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Menupop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 923, Short.MAX_VALUE))
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

    //Para ir a grupos estudiante (no esta todavia)
    private void jLabel_GruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_GruposMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_GruposMouseClicked

    //Para ir a cursos estudiante (no esta todavia)
    private void jLabel_CursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_CursosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_CursosMouseClicked

    //Para ir a la ventana principal
    private void jLabel_TableroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_TableroMouseClicked
        // TODO add your handling code here:
        VentanaPrincipalEstudiante VPE = new VentanaPrincipalEstudiante();
        VPE.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_TableroMouseClicked

    //Para ir a modulos estudiante (no esta todavia)
    private void jLabel_ModulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_ModulosMouseClicked
        JModuloEstudiante modulo = new JModuloEstudiante(materiaActual);
        this.dispose();
        modulo.setVisible(true);
    }//GEN-LAST:event_jLabel_ModulosMouseClicked

    private void jLabel_AnunciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_AnunciosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_AnunciosMouseClicked

    //Para ir a la pagina de inicio del curso
    private void jLabel_PagInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_PagInicioMouseClicked
        CursoEstudiante curso = new CursoEstudiante(materiaActual);
        curso.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_PagInicioMouseClicked

    //Para ir a calificaciones estudiante
    private void jLabel_CalificacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_CalificacionesMouseClicked
        // TODO add your handling code here:
        JCalificacionesMateria cali = new JCalificacionesMateria(materiaActual);
        cali.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_CalificacionesMouseClicked

    //para el menu desplegable
    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        if (!Menupop.isVisible()) {
            this.Menupop.setVisible(true);
        }else{
            this.Menupop.setVisible(false);
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    //Para ir a las asistencias
    private void jLabel_Asignaciones1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Asignaciones1MouseClicked
       if (materiaActual != null) {
        JAsistenciaEstudiante asistencia = new JAsistenciaEstudiante(materiaActual);
        asistencia.setVisible(true);
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, "No hay materia seleccionada.");
    }
    }//GEN-LAST:event_jLabel_Asignaciones1MouseClicked

    //para ver las asignaciones
    private void jLabel_AsignacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_AsignacionesMouseClicked
        // TODO add your handling code here:
        JAsignacionesEstudiante asignacionesEst = new JAsignacionesEstudiante(materiaActual);
        asignacionesEst.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_AsignacionesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Menupop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
