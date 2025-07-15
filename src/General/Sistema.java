package General;


public class Sistema {

    public static Profesor profesorActual;
    public static Estudiante estudianteActual;

    // O métodos más controlados:
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

}
