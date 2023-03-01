import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class JsonFileCreate {

    public static void main(String[] args) {

        try (FileWriter writer = new FileWriter("user.json")){

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            User [] users = new UserReader().methodReaderTxtFile();
            String json = "";
            for (int i = 0; i < users.length; i++) {
                if (i==0)   json +="[ " + gson.toJson(users[i]) + " ,";
                else if (i==users.length-1) json += gson.toJson(users[i]) + " ]";
                else  json += gson.toJson(users[i]) + " ,";

            }
            writer.write(json);
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}