package General;

public class TextoModulo extends ObjetoModulo {
    private String texto;
    private String Titulo;

    public TextoModulo(String Titulo, String texto) {
        this.texto = texto;
        this.Titulo = Titulo;
    }

    public String getTipo() {
        return "Texto";
    }

    public String getContenido() {
        return texto;
    }
    
    public String getTitulo(){
        return Titulo;
    }
}
