import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCases = Integer.parseInt(scanner.next());
        
        for (int caseNumber = 1; caseNumber <= totalCases; caseNumber++) {
            int wordCount = Integer.parseInt(scanner.next());
            List<String> words = new ArrayList<>();
            
            for (int i = 0; i < wordCount; i++) {
                words.add(scanner.next());
            }
            
            String longestWord = Collections.max(words, Comparator.comparingInt(String::length));
            boolean isValid = true;
            
            for (String word : words) {
                String suffix = word.substring(1);
                String longestWordSuffix = longestWord.substring(longestWord.length() - suffix.length());
                
                if (!longestWordSuffix.equals(suffix)) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                System.out.println("Case #" + caseNumber + ": " + longestWord.substring(1));
            } else {
                System.out.println("Case #" + caseNumber + ": *");
            }
        }
    }
}