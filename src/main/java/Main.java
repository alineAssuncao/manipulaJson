import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String pathDefault = "src/resources/";

        CompareJson compareJson = new CompareJson(pathDefault+"fileOrig.json", pathDefault+"fileNew.json", new String[]{"id"});

        SliceJson sliceJson = new SliceJson(pathDefault+"arrayJson.json", "sdsdf");

        // Exemplo de uso dos métodos
        DadosJson novoObjeto = new DadosJson("abc123", "Aline", "40",
                new CampoComposto("brigadeiro", "hamburguer"), "gym");

        // Criar/Adicionar objeto
        JsonManipulation.createJson(novoObjeto);

        // Consultar objeto
        JsonManipulation.selectJson("abc123");

        // Alterar objeto
        DadosJson objetoAlterado = new DadosJson("abc123", "Aline Assuncao", "42",
                new CampoComposto("brigadeiro", "hamburguer"), "gym");
        JsonManipulation.changeJson("abc123", objetoAlterado);

        // Consultar objeto alterado
        JsonManipulation.selectJson("abc123");

        // Excluir objeto
        JsonManipulation.deleteJson("abc123");
    }
}