import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserReader {
    StringBuilder sb = new StringBuilder();

    public User[] methodReaderTxtFile() {
        String path = "src\\main\\java\\file.txt";
        try ( FileReader reader = new FileReader(path);) {
            int c;
            while ((c=reader.read()) !=-1) {
                sb.append((char) c );
            }
        } catch (IOException ex) {
            System.out.println("file not found");
        }

        return createArrayUserData();
    }

    private User[] createArrayUserData() {

        String [] arrrayString = sb.toString().split("\\s");
        String b1 = ""; String b2 = "";
        int counter =0;
        User [] users = new User[2];
        for (String a : arrrayString) {

            if (!a.equals("name") && !a.equals("age")) {
                if (a.matches("\\D+")) b1 = a;
                else if (a.matches("\\d+")) b2 = a;
            }
            if (!b1.equals("") && !b2.equals(""))  {
                users [counter++] = new User(b1, Integer.parseInt(b2));
                b1 = ""; b2 = "";
            }
        }
        return users;
    }
}
