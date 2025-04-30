import java.util.Map;

// Classe modelo para o JSON
class DadosJson {
    private String id;
    private String nome;
    private String idade;
    private Map<String, String> comidasFavoritas; // Usando um Map para comidasFavoritas
    private String cidade;

    // Construtores, Getters e Setters
    public DadosJson() {}

    public DadosJson(String id, String nome, String idade, Map<String, String> comidasFavoritas, String cidade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.comidasFavoritas = comidasFavoritas;
        this.cidade = cidade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public Map<String, String> getComidasFavoritas() {
        return comidasFavoritas;
    }

    public void setComidasFavoritas(Map<String, String> comidasFavoritas) {
        this.comidasFavoritas = comidasFavoritas;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "DadosJson{" +
                "id:'" + id + '\'' +
                ", nome:'" + nome + '\'' +
                ", idade:'" + idade + '\'' +
                ", comidasFavoritas:" + comidasFavoritas +
                ", cidade:'" + cidade + '\'' +
                '}';
    }
}

