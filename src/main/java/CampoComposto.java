// Classe auxiliar para o campo CampoC
class CampoComposto {
    private String primeiro;
    private String segundo;

    // Construtores, Getters e Setters
    public CampoComposto() {}

    public CampoComposto(String primeiroAlim, String segundoAlim) {
        this.primeiro = primeiroAlim;
        this.segundo = segundoAlim;
    }

    public String getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(String primeiro) {
        this.primeiro = primeiro;
    }

    public String getSegundo() {
        return segundo;
    }

    public void setSegundo(String segundo) {
        this.segundo = segundo;
    }

    @Override
    public String toString() {
        return "comidasFavoritas{" +
                "primeiro=" + primeiro +
                ", segundo=" + segundo +
                '}';
    }
}