import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int numberOfPatterns = Integer.parseInt(scanner.nextLine());
            String[] patterns = new String[numberOfPatterns];
            
            for (int patternIndex = 0; patternIndex < numberOfPatterns; patternIndex++) {
                patterns[patternIndex] = scanner.nextLine();
            }
            
            System.out.println(solvePatterns(patterns, caseIndex));
        }
        
        scanner.close();
    }

    private static String solvePatterns(String[] patterns, int caseIndex) {
        List<List<String>> splitPatterns = new ArrayList<>();
        
        for (String pattern : patterns) {
            String[] parts = pattern.split("\\*");
            List<String> patternParts = new ArrayList<>(Arrays.asList(parts));
            
            if (pattern.charAt(0) == '*') {
                patternParts.add(0, "#");
            }
            if (pattern.charAt(pattern.length() - 1) == '*') {
                patternParts.add("#");
            }
            
            splitPatterns.add(patternParts);
        }
        
        String longestPrefix = "";
        String longestSuffix = "";
        
        for (List<String> patternParts : splitPatterns) {
            String prefix = patternParts.get(0);
            String suffix = patternParts.get(patternParts.size() - 1);
            
            if (!prefix.equals("#") && prefix.length() > longestPrefix.length()) {
                longestPrefix = prefix;
            }
            if (!suffix.equals("#") && suffix.length() > longestSuffix.length()) {
                longestSuffix = suffix;
            }
        }
        
        for (List<String> patternParts : splitPatterns) {
            String prefix = patternParts.get(0);
            String suffix = patternParts.get(patternParts.size() - 1);
            
            if (!prefix.equals("#") && !longestPrefix.startsWith(prefix)) {
                return String.format("Case #%d: *", caseIndex + 1);
            }
            if (!suffix.equals("#") && !longestSuffix.endsWith(suffix)) {
                return String.format("Case #%d: *", caseIndex + 1);
            }
        }
        
        StringBuilder middlePart = new StringBuilder();
        
        for (List<String> patternParts : splitPatterns) {
            for (int partIndex = 1; partIndex < patternParts.size() - 1; partIndex++) {
                middlePart.append(patternParts.get(partIndex));
            }
        }
        
        String result = longestPrefix.equals("#") ? "" : longestPrefix;
        result += middlePart.toString();
        result += longestSuffix.equals("#") ? "" : longestSuffix;
        
        return String.format("Case #%d: %s", caseIndex + 1, result);
    }
}