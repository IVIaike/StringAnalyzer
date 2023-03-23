import java.util.*;
import java.util.Scanner; //импорт сканнера
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите предложение");
        String str = scanner.nextLine();

        String[] words = str.split(" ");
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            String lowerCaseWord = word.toLowerCase();
            if (wordCount.containsKey(lowerCaseWord)) {
                wordCount.put(lowerCaseWord, wordCount.get(lowerCaseWord) + 1);
            } else {
                wordCount.put(lowerCaseWord,1);
            }
        }
        System.out.println("В тексте " + words.length + " слов. ТОР10:");
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
        sortedWords.sort(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()));
        for (Map.Entry<String, Integer> entry : sortedWords) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}