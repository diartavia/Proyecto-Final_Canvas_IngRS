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
 public class TareasDatos {
    private String nombre;
    private String fechaInicio;
    private String fechaFinal;
    private int puntos;
    private String descripcion;


    public TareasDatos(String nombre, String fechaInicio, String fechaFinal, int puntos, String descripcion) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.puntos = puntos;
        this.descripcion = descripcion;
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
    public static TareasDatos fromFileString(String linea) {
        String[] partes = linea.split("\\|");
        if (partes.length < 5) return null;
        try {
            return new TareasDatos(
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
    public static List<TareasDatos> cargarTareas() {
        List<TareasDatos> lista = new ArrayList<>();
        File archivo = new File("tareas.txt");

        if (!archivo.exists()) {
            return lista;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                TareasDatos tarea = TareasDatos.fromFileString(linea);
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
    public static void guardarTareas(List<TareasDatos> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("tareas.txt"))) {
            for (TareasDatos tarea : lista) {
                bw.write(tarea.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

