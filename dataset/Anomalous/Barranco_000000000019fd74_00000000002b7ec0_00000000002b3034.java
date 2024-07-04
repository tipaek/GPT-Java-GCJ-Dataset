import java.util.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.next());
        
        for (int currentCase = 1; currentCase <= numberOfCases; currentCase++) {
            int numberOfWords = Integer.parseInt(scanner.next());
            List<String> patterns = new ArrayList<>();
            
            for (int i = 0; i < numberOfWords; i++) {
                String word = scanner.next();
                patterns.add(word.replace("*", ".*"));
            }
            
            String longestPattern = Collections.max(patterns, Comparator.comparing(String::length));
            String longestPatternWithoutRegex = longestPattern.replace(".*", "");
            
            boolean matchesAll = patterns.stream()
                .allMatch(pattern -> Pattern.compile(pattern).matcher(longestPatternWithoutRegex).matches());
            
            if (matchesAll) {
                System.out.println("Case #" + currentCase + ": " + longestPatternWithoutRegex);
            } else {
                System.out.println("Case #" + currentCase + ": *");
            }
        }
        
        scanner.close();
    }
}