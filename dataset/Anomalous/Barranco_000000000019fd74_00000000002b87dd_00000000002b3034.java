import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.next());
        
        for (int currentCase = 1; currentCase <= numberOfCases; currentCase++) {
            int wordCount = Integer.parseInt(scanner.next());
            List<String> patterns = new ArrayList<>();
            
            for (int i = 0; i < wordCount; i++) {
                String word = scanner.next();
                patterns.add(word.replace("*", ".*"));
            }
            
            String longestPattern = Collections.max(patterns, Comparator.comparingInt(String::length));
            String longestPatternWithoutRegex = longestPattern.replace(".*", "");
            
            boolean isMatch = true;
            for (String pattern : patterns) {
                Pattern regexPattern = Pattern.compile(pattern);
                Matcher matcher = regexPattern.matcher(longestPatternWithoutRegex);
                
                if (!matcher.matches()) {
                    isMatch = false;
                    break;
                }
            }
            
            if (isMatch) {
                System.out.println("Case #" + currentCase + ": " + longestPatternWithoutRegex);
            } else {
                System.out.println("Case #" + currentCase + ": *");
            }
        }
        
        scanner.close();
    }
}