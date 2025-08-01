package General;

public class LinkModulo extends ObjetoModulo {
    private String url;

    public LinkModulo(String url) {
        this.url = url;
    }

    public String getTipo() {
        return "Link";
    }

    public String getContenido() {
        return url;
    }
}
