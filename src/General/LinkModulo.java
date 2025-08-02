package General;

public class LinkModulo extends ObjetoModulo {
    private String url;
    private String Titulo;

    public LinkModulo(String Titulo,String url) {
        this.url = url;
        this.Titulo = Titulo;
    }

    public String getTipo() {
        return "Link";
    }

    public String getContenido() {
        return url;
    }

    public String getTitulo() {
        return Titulo;
    }
}
