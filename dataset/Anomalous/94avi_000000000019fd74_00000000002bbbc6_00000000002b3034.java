import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCaseCount = Integer.parseInt(br.readLine().trim());

            for (int test = 1; test <= testCaseCount; test++) {
                int n = Integer.parseInt(br.readLine().trim());
                List<String> words = new ArrayList<>();
                List<String> patterns = new ArrayList<>();
                String longestWord = "";

                for (int i = 0; i < n; i++) {
                    String word = br.readLine().trim();
                    words.add(word);
                    
                    String cleanedWord = word.replace("*", "");
                    if (cleanedWord.length() > longestWord.length()) {
                        longestWord = cleanedWord;
                    }

                    StringBuilder pattern = new StringBuilder();
                    for (char ch : word.toCharArray()) {
                        if (ch == '*') {
                            pattern.append(".*");
                        } else {
                            pattern.append(ch);
                        }
                    }
                    patterns.add(pattern.toString());
                }

                if (allPatternsMatch(longestWord, patterns)) {
                    System.out.println("Case #" + test + ": " + longestWord);
                } else {
                    System.out.println("Case #" + test + ": *");
                }
            }
        }
    }

    private static boolean allPatternsMatch(String text, List<String> patterns) {
        for (String pattern : patterns) {
            if (!Pattern.matches(pattern, text)) {
                return false;
            }
        }
        return true;
    }
}