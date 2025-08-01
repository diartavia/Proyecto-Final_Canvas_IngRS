package General;

public class TextoModulo extends ObjetoModulo {
    private String texto;

    public TextoModulo(String texto) {
        this.texto = texto;
    }

    public String getTipo() {
        return "Texto";
    }

    public String getContenido() {
        return texto;
    }
}
