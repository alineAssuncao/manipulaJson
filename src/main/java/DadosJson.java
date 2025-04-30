// Classe modelo para o JSON
class DadosJson {
    private String id;
    private String nome;
    private String idade;
    private CampoComposto comidasFavoritas;
    private String cidade;

    // Construtores, Getters e Setters
    public DadosJson() {}

    public DadosJson(String id, String nome, String idade, CampoComposto comidasFavoritas, String campoD) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        comidasFavoritas = comidasFavoritas;
        cidade = campoD;
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

    public CampoComposto getComidasFavoritas() {
        return comidasFavoritas;
    }

    public void setComidasFavoritas(CampoComposto comidasFavoritas) {
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
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", idade='" + idade + '\'' +
                ", comidasFavoritas=" + comidasFavoritas +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}

