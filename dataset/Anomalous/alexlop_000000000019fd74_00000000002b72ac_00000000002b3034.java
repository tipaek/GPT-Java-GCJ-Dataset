import java.util.*;
import java.io.*;

public class Solution {

    public static void processWords(String[] words, int caseNum) {
        Arrays.sort(words, Comparator.comparingInt(String::length));

        String lastWord = words[words.length - 1];
        String longestSubstring = lastWord.substring(1);

        for (int i = 0; i < words.length - 1; i++) {
            String currentSubstring = words[i].substring(1);
            int start = longestSubstring.length() - currentSubstring.length();
            if (!currentSubstring.equals(longestSubstring.substring(start))) {
                System.out.println("Case #" + caseNum + ": *");
                return;
            }
        }

        System.out.println("Case #" + caseNum + ": " + longestSubstring);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < testCases; i++) {
            int wordCount = Integer.parseInt(scanner.nextLine());
            String[] words = new String[wordCount];
            for (int j = 0; j < wordCount; j++) {
                words[j] = scanner.nextLine();
            }
            processWords(words, i);
        }
    }
}