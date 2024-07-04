import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.next());
        
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int wordCount = Integer.parseInt(scanner.next());
            List<String> patterns = new ArrayList<>();
            
            for (int i = 0; i < wordCount; i++) {
                String word = scanner.next();
                patterns.add(word.replace("*", ".*"));
            }

            String longestPattern = Collections.max(patterns, Comparator.comparingInt(String::length));
            String longestPatternStripped = longestPattern.replace(".*", "");
            
            boolean isMatch = true;
            String resultPattern = longestPatternStripped;
            
            for (String pattern : patterns) {
                String strippedPattern = pattern.replace(".*", "");
                resultPattern = longestPattern.replace(".*", strippedPattern);
                Pattern compiledPattern = Pattern.compile(pattern);
                Matcher matcher = compiledPattern.matcher(resultPattern);
                
                if (!matcher.matches()) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) {
                System.out.println("Case #" + caseNumber + ": " + resultPattern);
            } else {
                System.out.println("Case #" + caseNumber + ": *");
            }
        }
    }
}