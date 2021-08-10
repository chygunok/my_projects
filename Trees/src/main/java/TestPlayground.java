import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class TestPlayground {

    public static void serialize(Node tree) throws IOException{

        String myJson = "";
        try{
            myJson = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(tree);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try{
            FileWriter writer = new FileWriter("myJson.json", false);
            writer.write(myJson);
            writer.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static Node deserialize(File input) throws IOException {

        String myJson = readUsingBufferedReader("myJson.json");

        Node object = new ObjectMapper().readValue(myJson, Node.class);
        return object;

    }

    private static String readUsingBufferedReader(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader( new FileReader(fileName));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        while( ( line = reader.readLine() ) != null ) {
            stringBuilder.append( line );
            stringBuilder.append( ls );
        }

        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }
}

