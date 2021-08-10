import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class TestPlayground {
    public static void serialize(Node tree) throws IOException {


        String myJson = "";
        try{
            myJson = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(tree);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    public static Node deserialize(File input) throws IOException {

        String myJson = readUsingFiles("myJson.json");

        try{
            Node object = new ObjectMapper().readValue(myJson, Node.class);
            return object;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    private static String readUsingFiles(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
