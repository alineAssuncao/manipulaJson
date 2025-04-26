import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        String pathDefault = "src/resources/";

        CompareJson compareJson = new CompareJson(pathDefault+"fileOrig.json", pathDefault+"fileNew.json", new String[]{"id"});

        SliceJson sliceJson = new SliceJson(pathDefault+"arrayJson.json", "sdsdf");
    }
}