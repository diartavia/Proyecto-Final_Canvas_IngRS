/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asistencias;

/**
 *
 * @author jadia
 */
import java.io.*;
import java.util.List;

public class ArchivoUtil {

    public static <T> void guardarLista(String nombreArchivo, List<T> lista) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(lista);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> cargarLista(String nombreArchivo) throws IOException, ClassNotFoundException {
        File f = new File(nombreArchivo);
        if (!f.exists()) return null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return (List<T>) ois.readObject();
        }
    }
}