import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        String pathDefault = "src/resources/";

        CompareJson compareJson = new CompareJson(pathDefault+"fileOrig.json", pathDefault+"fileNew.json", new String[]{"id"});

        SliceJson sliceJson = new SliceJson(pathDefault+"arrayJson.json", "sdsdf");

        //Manipulação para criação e manipulação de um JSON

        //Criando um mapa para as comidas favoritas
        Map<String, String> comidasFavoritas = new HashMap<>();
        comidasFavoritas.put("primeiro", "brigadeiro");
        comidasFavoritas.put("segundo", "hamburguer");

        // Exemplo de uso dos métodos
        DadosJson novoObjeto = new DadosJson("abc123", "Aline", "40", comidasFavoritas, "gym");

        // Criar/Adicionar objeto
        JsonManipulation.createJson(novoObjeto);

        // Consultar objeto
        JsonManipulation.selectJson("abc123");

        // Alterar objeto
        DadosJson objetoAlterado = new DadosJson("abc123", "Aline Assuncao", "42",comidasFavoritas, "gym");
        JsonManipulation.changeJson("abc123", objetoAlterado);

        // Consultar objeto alterado
        JsonManipulation.selectJson("abc123");

        // Excluir objeto
        JsonManipulation.deleteJson("abc123");
    }
}