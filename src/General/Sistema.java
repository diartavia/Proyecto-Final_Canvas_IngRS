package General;

import CursoProfesor.Asignacion;
import java.util.ArrayList;


public class Sistema {

    private static Profesor profesorActual;
    private static Estudiante estudianteActual;

    // Materia demo global para fácil acceso desde otras ventanas
    private static Materia materiaDemoPublica;

    // Listas generales de todos los usuarios del sistema
    private static ArrayList<Profesor> todosLosProfesores = new ArrayList<>();
    private static ArrayList<Estudiante> todosLosEstudiantes = new ArrayList<>();

    // ------------------ Getters y Setters ------------------ //

    public static Profesor getProfesorActual() {
        return profesorActual;
    }

    public static void setProfesorActual(Profesor p) {
        profesorActual = p;
    }

    public static Estudiante getEstudianteActual() {
        return estudianteActual;
    }

    public static void setEstudianteActual(Estudiante e) {
        estudianteActual = e;
    }

    public static Materia getMateriaDemoPublica() {
        return materiaDemoPublica;
    }

    public static void setMateriaDemoPublica(Materia materia) {
        materiaDemoPublica = materia;
    }

    public static ArrayList<Profesor> getProfesores() {
        return todosLosProfesores;
    }

    public static void setProfesores(ArrayList<Profesor> lista) {
        todosLosProfesores = lista;
    }

    public static ArrayList<Estudiante> getEstudiantes() {
        return todosLosEstudiantes;
    }

    public static void setEstudiantes(ArrayList<Estudiante> lista) {
        todosLosEstudiantes = lista;
    }

    /**
     * Carga datos iniciales de ejemplo en memoria para pruebas o demo.
     */
    public static void cargarDatosIniciales() {
    // 1. Crear profesor principal
    Profesor profesorDemo = new Profesor(
        "p001", "Luis Ramírez", "lramirez@ulacit.ed.cr", "1234"
    );

    // 2. Crear materia asignada al profesor
    Materia materiaDemo = new Materia(
        "mat101",
        "Programación Orientada a Objetos",
        "Ing. Software",
        "Lunes 9:00 - 12:00",
        "Grupo 1",
        profesorDemo.getId()
    );
    materiaDemoPublica = materiaDemo;

    // 3. Crear estudiantes (sin asignarlos a ningún grupo)
    Estudiante est1 = new Estudiante("20231234", "María", "Fernández", "mfernandez@ulacit.ed.cr", "pass123");
    Estudiante est2 = new Estudiante("20235678", "Juan", "Gómez", "jgomez@ulacit.ed.cr", "pass456");

    // 4. Agregar los estudiantes a la materia (no a grupos)
    materiaDemo.agregarEstudiante(est1);
    materiaDemo.agregarEstudiante(est2);

    // 5. Agregar asignación de ejemplo
    Asignacion tarea = new Asignacion("Tarea 1", "01-08-2025", "08-08-2025", 100, "Implementar clase Sistema");
    materiaDemo.agregarAsignaciones(tarea);

    // 6. Asociar la materia al profesor
    profesorDemo.agregarMateria(materiaDemo);

    // 7. Definir profesor actual y registrar listas globales
    setProfesorActual(profesorDemo);
    todosLosProfesores.add(profesorDemo);
    todosLosEstudiantes.add(est1);
    todosLosEstudiantes.add(est2);
}
    
    public static Estudiante buscarEstudiantePorId(String id) {
    for (Estudiante e : todosLosEstudiantes) {
        if (e.getId().equalsIgnoreCase(id)) {
            return e;
        }
    }
    return null;
}
}