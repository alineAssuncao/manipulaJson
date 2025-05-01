import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class ManipuladorJsonTest {

    private JsonManipulation manipulador ;
    private DadosJson dadosJson;
    private CompareJson comparar;
    private SliceJson buscaJsonEspec;
    private String jsonBase;
    Map<String, String> comidasFavoritas = new HashMap<>();
    private String pathDefault = "src/resources/";
    private String pathDefaultUnit = "src/resources/tempUnit/";

    @BeforeEach
    void setUp() throws IOException {
        manipulador = new JsonManipulation();
        comparar = new CompareJson();
        buscaJsonEspec = new SliceJson();

        comidasFavoritas.put("primeiro", "brigadeiro");
        comidasFavoritas.put("segundo", "hamburguer");

        // Exemplo de uso dos métodos
        dadosJson = new DadosJson("abc123", "Aline", "40", comidasFavoritas, "gym");

    }

    @Test
    void testCriar() throws IOException {
        FileWriter limpa = new FileWriter(pathDefaultUnit+"tempC.json");
        limpa.write("");
        List<DadosJson> criaJson = manipulador.createJson(dadosJson, pathDefaultUnit+"tempC.json");
        System.out.println(criaJson);

        // Verifica que a lista contém apenas um elemento
        assertEquals(1, criaJson.size());
        assertEquals(dadosJson, criaJson.get(0)); // Compara o objeto diretamente
    }

    @Test
    void testLer() {
        DadosJson resultado = manipulador.selectJson(dadosJson.getId(), pathDefaultUnit+"tempR.json");

        assertNotNull(resultado);
        assertEquals("abc123", resultado.getId());
    }

    @Test
    void testAtualizar() {
        //Cria o JSON novo
        List<DadosJson> criaJson = manipulador.createJson(dadosJson, pathDefaultUnit+"tempU.json");
        System.out.println(criaJson);

        //Modifica
        DadosJson objetoAlterado = new DadosJson("abc123", "Aline Assuncao", "42",comidasFavoritas, "gym");
        DadosJson atualiza = manipulador.changeJson(dadosJson.getId(), objetoAlterado, pathDefaultUnit+"tempU.json");

        assertNotNull(atualiza);
        assertEquals("Aline Assuncao", atualiza.getNome());
    }

    @Test
    void testDeletar() {
        //Cria o JSON novo
        List<DadosJson> criaJson = manipulador.createJson(dadosJson, pathDefaultUnit+"tempD.json");
        System.out.println(criaJson);

        DadosJson deleta = manipulador.deleteJson(dadosJson.getId(), pathDefaultUnit+"tempD.json");

        assertNull(deleta);
    }

    @Test
    void testComparar() {
        String result = comparar.CompareJson(pathDefault+"fileOrig.json", pathDefault+"fileNew.json", new String[]{"id"});
        assertEquals("Sucesso", result);
    }

    @Test
    void testSlice() throws IOException {
        String result = buscaJsonEspec.SliceJson(pathDefault+"arrayJson.json", "sdsdf");
        assertEquals("Sucesso", result);
    }

}