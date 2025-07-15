package CursoProfesor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

 public class Asignacion {

// ------------------ Atributos principales ------------------ //
    private String nombre;
    private String fechaInicio;
    private String fechaFinal;
    private int puntos;
    private String descripcion;

    // ------------------ Constructores ------------------ //

    /**
     * Constructor completo.
     */
    public Asignacion(String nombre, String fechaInicio, String fechaFinal, int puntos, String descripcion) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.puntos = puntos;
        this.descripcion = descripcion;
    }

    /**
     * Constructor vacío requerido para ciertas operaciones como serialización o frameworks.
     */
    public Asignacion() {
    }

    // ------------------ Getters ------------------ //
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

    // ------------------ Persistencia en archivo ------------------ //

    /**
     * Convierte esta asignación en una línea de texto, lista para ser guardada en archivo.
     * Se utiliza el carácter "|" como separador.
     */
    public String toFileString() {
        return nombre + "|" + fechaInicio + "|" + fechaFinal + "|" + puntos + "|" + descripcion.replace("\n", "\\n");
    }

    /**
     * Convierte una línea leída de archivo en un objeto Asignacion.
     *
     * @param linea Línea de texto con los campos separados por '|'.
     * @return Objeto Asignacion o null si hay error de formato.
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

    /**
     * Carga todas las asignaciones desde el archivo "tareas.txt".
     *
     * @return Lista de asignaciones cargadas.
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
                Asignacion asignacion = Asignacion.fromFileString(linea);
                if (asignacion != null) {
                    lista.add(asignacion);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    /**
     * Guarda una lista completa de asignaciones en el archivo "tareas.txt".
     *
     * @param lista Lista de asignaciones a guardar.
     */
    public static void guardarTareas(List<Asignacion> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("tareas.txt"))) {
            for (Asignacion asignacion : lista) {
                bw.write(asignacion.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ------------------ Métodos auxiliares ------------------ //

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
     * Dos asignaciones se consideran iguales si tienen el mismo nombre.
     * Esto permite evitar duplicados en listas.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Asignacion other = (Asignacion) obj;
        return nombre != null && nombre.equals(other.nombre);
    }

    @Override
    public int hashCode() {
        return nombre != null ? nombre.hashCode() : 0;
    }
}

