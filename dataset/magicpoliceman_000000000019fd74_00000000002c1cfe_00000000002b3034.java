import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCases; i++) {
            int wordsNum = Integer.parseInt(reader.readLine());
            String[] words = new String[wordsNum];
            for (int r = 0; r < wordsNum; r++) {
                words[r] = reader.readLine();
            }

            String solution = findSolution(words);

            System.out.println("Case #" + i + ": " + solution);
        }
    }

    private static String findSolution(String[] words) {
        String longest = findLongest(words);
        longest = longest.substring(1);
        if (!longest.isEmpty() && matchesAllPatterns(words, longest)) {
            return longest;
        }
        return "*";
    }

    private static boolean matchesAllPatterns(String[] words, String longest) {
        for (String word : words) {
            word = word.substring(1);
            if (!longest.contains(word)) {
                return false;
            }
        }
        return true;
    }

    private static String findLongest(String[] words) {
        int max = 0;
        String longest = "";
        for (String word : words) {
            if (word.length() > max) {
                longest = word;
                max = longest.length();
            }
        }
        return longest;
    }
}