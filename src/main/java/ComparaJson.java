import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class ComparaJson {

    public ComparaJson(String fileOrig, String fileNew, String[] fieldsDisregard){
        String pathDefault = "src/resources/";
        final String fileOrigPath = pathDefault + fileOrig;
        final String fileNewPath = pathDefault + fileNew;

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            //Lendo os arquivos JSON
            JsonNode rootNodeOrig = objectMapper.readTree(new File(fileOrigPath));
            JsonNode rootNodeNew = objectMapper.readTree(new File(fileNewPath));

            //Removendo os campos que não serão comparados
            for (int i = 0; i < fieldsDisregard.length; i++) {
                ((ObjectNode) rootNodeOrig).remove(fieldsDisregard[i]);
                ((ObjectNode) rootNodeNew).remove(fieldsDisregard[i]);
            }

            //Compara os JSONs
            if (!rootNodeOrig.equals(rootNodeNew)){
                System.out.println("FALHA! Os JSONs são diferentes. Diferenças: ");
                Iterator<String> fieldNames = rootNodeOrig.fieldNames();
                while (fieldNames.hasNext()){
                    String fieldName = fieldNames.next();
                    JsonNode valueOrig = rootNodeOrig.get(fieldName);
                    JsonNode valueNew = rootNodeNew.get(fieldName);
                    if (!valueOrig.equals(valueNew)){
                        System.out.println("Campo diferente: " + fieldName);
                        System.out.println("Arquivo Original: " + valueOrig);
                        System.out.println("Arquivo Novo: " + valueNew);
                    }
                }
            } else {
                System.out.println("Os JSONs são iguais (exceto o(s) campo(s): " + Arrays.toString(fieldsDisregard));
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler os arquivos JSON: " + e.getMessage());
        }
    }

}
