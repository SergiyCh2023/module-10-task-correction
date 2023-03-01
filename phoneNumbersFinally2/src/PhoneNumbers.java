import java.io.*;

public class PhoneNumbers {

    public void readFile() {
        StringBuilder sb = new StringBuilder();
        String path = "src\\test.txt";
        try (FileReader reader = new FileReader(path)) {
            int c;
            while ((c = reader.read()) != -1) {
                sb.append((char) c );
            }
        } catch (IOException e) {
            e.getMessage();
        }

        checkingMethod(sb);
    }


    private void checkingMethod (StringBuilder sb) {
        String [] array = sb.toString().split("\n");
        for (String a : array) {
           if (a.matches("\\d{3}-\\d{3}-\\d{4}||\\d{3}-\\d{3}-\\d{4}+\\r||\\(\\d{3}\\) \\d{3}-\\d{4}\\r||\\(\\d{3}\\) \\d{3}-\\d{4}")) System.out.println(a);
        }
    }

}
