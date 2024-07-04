import java.util.*;
import java.io.*;

public class Solution {

    public static void processWords(String[] words, int caseNumber) {
        Arrays.sort(words);
        
        String longestWord = words[words.length - 1].substring(1);
        
        for (int i = 0; i < words.length - 1; i++) {
            if (!words[i].equals(longestWord.substring(0, longestWord.length()))) {
                System.out.println("Case #" + caseNumber + ": *");
                return;
            }
        }
        
        System.out.println("Case #" + caseNumber + ": " + longestWord);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        for (int i = 0; i < testCases; i++) {
            int wordCount = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            String[] words = new String[wordCount];
            for (int j = 0; j < wordCount; j++) {
                words[j] = scanner.nextLine();
            }
            processWords(words, i + 1);
        }
        scanner.close();
    }
}