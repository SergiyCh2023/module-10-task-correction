import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordsCounter {

    private HashMap<String, Integer> wordsMap = new HashMap<>();
    private ArrayList<Map.Entry<String, Integer>> wordsMapList = new ArrayList<>();

    public void readFile() {
        StringBuilder sb = new StringBuilder();
        try (FileReader reader = new FileReader("src\\words.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                sb.append((char)c);
            }
        } catch (IOException e) {
            System.out.println("Don't find the file");
        }

        someMethod(sb);
        Iterator<Map.Entry<String, Integer>> iterator = wordsMap.entrySet().iterator();
        while (iterator.hasNext()) {
         wordsMapList.add(iterator.next());
        }

        WordsCompare wordsCompare = new WordsCompare();
        Collections.sort(wordsMapList, wordsCompare);
        System.out.println(wordsMapList);

    }


    class WordsCompare implements Comparator <Map.Entry<String, Integer>> {
        public int compare (Map.Entry<String, Integer> one, Map.Entry<String, Integer> two) {
            return two.getValue().compareTo(one.getValue());
        }
    }


    private void someMethod (StringBuilder sb) {
        StringBuilder sx = new StringBuilder(sb.toString().replaceAll("[\\.,\\s+;\\n\\t]", " "));
        String [] array = sx.toString().replaceAll("\\s+", " ").toLowerCase().split(" "); // можно і не приводити до нижнього регістру, в завданні там ітак маленькі літери мають бути

        int counter =0;
        for (int i = 0; i < array.length; i++) {
            String b = array [i];
            for ( String a : array ) {
                if (b.equals(a)) counter++;
            }
            wordsMap.put(b,counter);
            counter =0;
        }
    }

}
