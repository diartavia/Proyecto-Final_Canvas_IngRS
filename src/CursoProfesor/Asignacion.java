/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CursoProfesor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jadia
 */
 public class Asignacion {
     
     /*
     
         //----------- Atributos ----------------------//
    private String Nombre,Descripcion;
    private Date fechaInicio, fechaFinal;
    private boolean EnGrupo;
    private double calificacion;
    private int id_categoria; //Esto porque aveces las notas se agrupan en diferentes categorias omo lo puede ser proyecto final, etc...
    private Grupo grupoactual;
    private Materia materiaactual;

    public Asignacion(String Nombre, String Descripcion, Date fechaInicio, Date fechaFinal, boolean EnGrupo, double calificacion, int id_categoria, Grupo grupoactual, Materia materiaactual) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.EnGrupo = EnGrupo;
        this.calificacion = calificacion;
        this.id_categoria = id_categoria;
        this.grupoactual = grupoactual;
        this.materiaactual = materiaactual;
    }

     */
    private String nombre;
    private String fechaInicio;
    private String fechaFinal;
    private int puntos;
    private String descripcion;


    public Asignacion(String nombre, String fechaInicio, String fechaFinal, int puntos, String descripcion) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.puntos = puntos;
        this.descripcion = descripcion;
    }
    
    public Asignacion() {
    }
    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Convierte la tarea en una línea de texto para guardar en archivo,
     * usando '|' como separador y reemplazando saltos de línea en descripción.
     */
    public String toFileString() {
        return nombre + "|" + fechaInicio + "|" + fechaFinal + "|" + puntos + "|" + descripcion.replace("\n", "\\n");
    }

    /**
     * Convierte una línea del archivo en un objeto TareasDatos
     * @param linea línea con datos separados por '|'
     * @return objeto TareasDatos o null si hay error
     */
    public static Asignacion fromFileString(String linea) {
        String[] partes = linea.split("\\|");
        if (partes.length < 5) return null;
        try {
            return new Asignacion(
                partes[0],
                partes[1],
                partes[2],
                Integer.parseInt(partes[3]),
                partes[4].replace("\\n", "\n")
            );
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Tarea:\n" +
               "Nombre: " + nombre + "\n" +
               "Inicio: " + fechaInicio + "\n" +
               "Final: " + fechaFinal + "\n" +
               "Puntos: " + puntos + "\n" +
               "Descripción:\n" + descripcion;
    }

    /**
     * Carga todas las tareas desde el archivo "tareas.txt"
     * @return lista de tareas, vacía si no hay archivo o error
     */
    public static List<Asignacion> cargarTareas() {
        List<Asignacion> lista = new ArrayList<>();
        File archivo = new File("tareas.txt");

        if (!archivo.exists()) {
            return lista;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Asignacion tarea = Asignacion.fromFileString(linea);
                if (tarea != null) {
                    lista.add(tarea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    /**
     * Guarda toda la lista de tareas en el archivo "tareas.txt",
     * sobrescribiendo el archivo anterior.
     * @param lista lista de tareas a guardar
     */
    public static void guardarTareas(List<Asignacion> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("tareas.txt"))) {
            for (Asignacion tarea : lista) {
                bw.write(tarea.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

