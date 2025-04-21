package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Classe para leitura e comparação de arquivos Json utilizando a biblioteca Jackson
 */
public class App {
    public static void main(String[] args) {

        try {
            //criar o objeto mapper
            ObjectMapper objectMapper = new ObjectMapper();

            //caminho do arquivo Json
            File arquivoJsonOrig = new File("src/resources/file_orig.json");
            File arquivoJsonNovo = new File("src/resources/file_novo.json");
            JsonNode raizNodeOrig, raizNodeNovo = null;

            //lendo o Json dos arquivos
            raizNodeOrig = objectMapper.readTree(arquivoJsonOrig);
            raizNodeNovo = objectMapper.readTree(arquivoJsonNovo);

            //remover o campo "id" de ambos os objetos antes da comparação.
            // Caso tenham mais campos que serão diferentes os mesmos devems ser incluidos aqui.
            ((ObjectNode) raizNodeOrig).remove("id");
            ((ObjectNode) raizNodeNovo).remove("id");

            //compara os JSONs e exibe as diferenças
            if(!raizNodeOrig.equals(raizNodeNovo)) {
                System.out.println("FALHA! Os JSONs são diferentes. Diferenças: ");
                Iterator<String> fieldNames = raizNodeOrig.fieldNames();
                while(fieldNames.hasNext()){
                    String fieldName = fieldNames.next();
                    JsonNode valueOrig = raizNodeOrig.get(fieldName);
                    JsonNode valueNovo = raizNodeNovo.get(fieldName);

                    if (!valueOrig.equals(valueNovo)){
                        System.out.println("Campo diferente: " + fieldName);
                        System.out.println("Arquivo Original: " + valueOrig +
                                            "\nArquivo Novo: " + valueNovo);
                    }
                }
            } else {
                System.out.println("Os JSONs são iguais (exceto o campo 'id').");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}