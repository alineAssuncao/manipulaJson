import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        String pathDefault = "src/resources/";

        CompareJson compareJson;
        compareJson = new CompareJson();
        compareJson.CompareJson(pathDefault+"fileOrig.json", pathDefault+"fileNew.json", new String[]{"id", "timestamp"});

/*
        SliceJson sliceJson;
        sliceJson = new SliceJson();
        sliceJson.SliceJson(pathDefault+"arrayJson.json", "sdsdf");


        //Manipulação para criação e manipulação de um JSON

        //Criando um mapa para as comidas favoritas
        Map<String, String> comidasFavoritas = new HashMap<>();
        comidasFavoritas.put("primeiro", "brigadeiro");
        comidasFavoritas.put("segundo", "hamburguer");

        // Exemplo de uso dos métodos
        DadosJson novoObjeto = new DadosJson("abc123", "Aline", "40", comidasFavoritas, "gym");

        // Criar/Adicionar objeto
        JsonManipulation.createJson(novoObjeto, pathDefault+"temp.json");

        // Consultar objeto
        JsonManipulation.selectJson("abc123", pathDefault + "temp.json");

        // Alterar objeto
        DadosJson objetoAlterado = new DadosJson("abc123", "Aline Assuncao", "42",comidasFavoritas, "gym");
        JsonManipulation.changeJson("abc123", objetoAlterado, pathDefault+"temp.json");

        // Consultar objeto alterado
        JsonManipulation.selectJson("abc123", pathDefault+"temp.json");

        // Excluir objeto
        JsonManipulation.deleteJson("abc123", pathDefault+"temp.json");


 */

    }
}