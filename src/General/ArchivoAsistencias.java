/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package General;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author jadia
 */
public class ArchivoAsistencias {

    private static final String ARCHIVO = "asistencia.txt";

    public static void guardar(ArrayList<Asistencia> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     public static ArrayList<Asistencia> cargar() {
        ArrayList<Asistencia> lista;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            lista = (ArrayList<Asistencia>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            lista = new ArrayList<>(); // Si el archivo no existe o está vacío
        }

        // ---------- Datos por defecto para María Fernández ----------
        String idMaria = "mfernandez"; // Cambia por el ID real de María Fernández
        boolean tieneMaria = lista.stream()
                .anyMatch(a -> a.getIdEstudiante().equalsIgnoreCase(idMaria));

        if (!tieneMaria) {
            Calendar cal = Calendar.getInstance();

            // 5 asistencias como PRESENTE
            for (int i = 0; i < 5; i++) {
                cal.set(2025, Calendar.AUGUST, i + 1);
                lista.add(new Asistencia(idMaria, cal.getTime(), Asistencia.EstadoAsistencia.PRESENTE));
            }

            // 1 asistencia como AUSENTE
            cal.set(2025, Calendar.AUGUST, 6);
            lista.add(new Asistencia(idMaria, cal.getTime(), Asistencia.EstadoAsistencia.AUSENTE));

            guardar(lista); // Guardar cambios
        }
        // ------------------------------------------------------------

        return lista;
    }
}