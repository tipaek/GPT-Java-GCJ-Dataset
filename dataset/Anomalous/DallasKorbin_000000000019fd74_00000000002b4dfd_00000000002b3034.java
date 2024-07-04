import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();
        
        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            int numberOfWords = scanner.nextInt();
            List<String> words = new ArrayList<>();
            
            for (int wordIndex = 0; wordIndex < numberOfWords; wordIndex++) {
                words.add(scanner.next());
            }
            
            String result = findMatchingPattern(words);
            System.out.println("Case #" + (testIndex + 1) + ": " + result);
        }
        
        scanner.close();
    }

    private static String findMatchingPattern(List<String> words) {
        String defaultAnswer = "*";
        
        for (String word : words) {
            String candidate = word.replace("*", "");
            if (isValidPattern(candidate, words)) {
                return candidate;
            }
        }
        
        return defaultAnswer;
    }

    private static boolean isValidPattern(String candidate, List<String> words) {
        for (String word : words) {
            String regex = word.replace("*", ".*");
            if (!Pattern.matches(regex, candidate)) {
                return false;
            }
        }
        
        return true;
    }
}