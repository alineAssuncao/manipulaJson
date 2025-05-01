import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonManipulation {

    //private static final String JSON_PATH = "src/resources/temp.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    //Metodo para criar ou adicionar um novo objeto JSON
    public static List<DadosJson> createJson(DadosJson novoObjeto, String JSON_PATH) {
        try {
            //Lê a lista atual do arquivo (se existir)
            List<DadosJson> objetos = readJson(JSON_PATH);

            //Adiciona o novo objeto
            objetos.add(novoObjeto);

            //Escreve a lista atualizada de volta no arquivo
            objectMapper.writeValue(new File(JSON_PATH), objetos);
            System.out.println("Objeto criado/adicionado com sucesso!");
            return objetos;

        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (StreamWriteException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Metodo para alterar um objeto existente pelo ID
    public static DadosJson changeJson(String id, DadosJson objetoAlterado, String JSON_PATH) {
        try {
            List<DadosJson> objetos = readJson(JSON_PATH);

            // Procura pelo objeto com o ID especificado
            boolean encontrado = false;
            for (int i = 0; i < objetos.size(); i++) {
                if (objetos.get(i).getId().equals(id)) {
                    objetos.set(i, objetoAlterado);
                    encontrado = true;
                    break;
                }
            }

            if (encontrado) {
                // Atualiza o arquivo
                objectMapper.writeValue(new File(JSON_PATH), objetos);
                System.out.println("Objeto alterado com sucesso!");
            } else {
                System.out.println("Objeto com ID " + id + " não encontrado.");
            }
        } catch (IOException e) {
            System.err.println("Erro ao alterar JSON.");
            e.printStackTrace();
        }
        return objetoAlterado;
    }

    // Metodo para consultar um objeto pelo ID
    public static DadosJson selectJson(String id, String JSON_PATH) {
        try {
            List<DadosJson> objetos = readJson(JSON_PATH);

            // Busca o objeto pelo ID
            for (DadosJson objeto : objetos) {
                if (objeto.getId().equals(id)) {
                    System.out.println("Objeto encontrado: " + objeto);
                    return objeto;
                }
            }

            System.out.println("Objeto com ID " + id + " não encontrado.");
        } catch (IOException e) {
            System.err.println("Erro ao consultar JSON.");
            e.printStackTrace();
        }

        return null;
    }

    // Metodo para excluir um objeto pelo ID
    public static DadosJson deleteJson(String id, String JSON_PATH) {
        try {
            List<DadosJson> objetos = readJson(JSON_PATH);

            // Remove o objeto pelo ID
            boolean removido = objetos.removeIf(objeto -> objeto.getId().equals(id));

            if (removido) {
                // Atualiza o arquivo
                objectMapper.writeValue(new File(JSON_PATH), objetos);
                System.out.println("Objeto com ID " + id + " excluído com sucesso!");
            } else {
                System.out.println("Objeto com ID " + id + " não encontrado.");
            }
        } catch (IOException e) {
            System.err.println("Erro ao excluir JSON.");
            e.printStackTrace();
        }
        return null;
    }

    // Metodo auxiliar para ler o JSON (carregar lista de objetos)
    private static List<DadosJson> readJson(String JSON_PATH) throws IOException {
        File file = new File(JSON_PATH);
        if (file.exists() && file.length() > 0) {
            // Lê o JSON do arquivo e converte para uma lista de objetos
            return objectMapper.readValue(file, new TypeReference<List<DadosJson>>() {});
        } else {
            // Se o arquivo não existir, retorna uma lista vazia
            return new ArrayList<>();
        }
    }
}

