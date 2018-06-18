/**
 * Created by Not Me on 17.06.2018.
 */
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileInputStream;

public class Main
{
    public static void main(String[] args) {
        try {
            System.out.println("Введите путь к файлу");
            Scanner src = new Scanner(System.in);
            String fileName = src.nextLine();

            FileInputStream inFile = new FileInputStream(fileName);
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            String s = new String(str);

            String[] words = s.toLowerCase().replaceAll("[-.?!)(,:]", "").split("\\s");
            Map<String, Integer> counterMap = new HashMap<>();
            for (String word : words) {
                if (!word.isEmpty()) {
                    Integer count = counterMap.get(word);
                    if (count == null) {
                        count = 0;
                    }
                    counterMap.put(word, ++count);
                }
            }

            for (String word : counterMap.keySet()) {
                System.out.println(word + ": " + counterMap.get(word));
            }
        }
        catch (Exception e)
        {

        }
    }
}