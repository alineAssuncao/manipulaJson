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
        JsonNode rootNode = objectMapper .readTree(new File(searchFile));

        //Caso tenho o JSON seja um Array
        //ArrayNode jsonArray = (ArrayNode) objectMapper.readTree(new File(searchFile));

        //Valor para busca dentro do Json (neste caso será o ID)
        String targeId = searchField;

        //Caso o JSON seja um array
        if (rootNode.isArray()){
            for (JsonNode node : rootNode){
                if (node.path("id").asText().equals(targeId)){
                    System.out.println("JSON encontrado:");
                    System.out.println(node.toPrettyString());
                    return;
                }
            }
        }
        //Caso o JSON seja um objeto
        else if (rootNode.isObject()){
            if (rootNode.path("id").asText().equals(targeId)){
                System.out.println("JSON encontrado:");
                System.out.println(rootNode.toPrettyString());
            } else {
                System.out.println("Nenhum JSON encontrado com ID: " + targeId);
            }
        } else{
            System.out.println("O formato do JSON não é válido.");
        }

    }

}
