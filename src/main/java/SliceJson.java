import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import java.io.File;
import java.io.IOException;

public class SliceJson {
    public SliceJson(String searchFile, String searchField) throws IOException {
        //Carregando o JSON de um arquivo
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode jsonArray = (ArrayNode) objectMapper.readTree(new File(searchFile));

        //Valor para busca dentro do Json (neste caso será o ID)
        String targeId = searchField;

        //Buscando o JSON com o valor especifico (ID)
        JsonNode resultNode = null;
        for (JsonNode node : jsonArray){
            if (node.path("id").asText().equals(targeId)){
                resultNode = node;
                break;
            }
        }

        //Exibindo resultado
        if (resultNode != null){
            System.out.println("Json encontrado:");
            System.out.println(resultNode.toPrettyString());
        } else {
            System.out.println("Nenhum JSson encontrado com ID: " + targeId);
        }
    }

}
