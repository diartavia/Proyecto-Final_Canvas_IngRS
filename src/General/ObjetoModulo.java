package General;

import java.io.Serializable;

public abstract class ObjetoModulo implements Serializable {
    public abstract String getTipo(); // "Texto", "Link", etc.
    public abstract String getTitulo(); // El valor que se muestra
    public abstract String getContenido(); // El valor que se muestra
}
