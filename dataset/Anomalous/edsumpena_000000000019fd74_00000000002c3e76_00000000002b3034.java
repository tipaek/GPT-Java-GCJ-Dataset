import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int patternCount = scanner.nextInt();
            List<String> patterns = new ArrayList<>();
            
            for (int i = 0; i < patternCount; i++) {
                patterns.add(scanner.next());
            }
            
            System.out.println("Case #" + t + ": " + getPossibleName(patterns));
        }
    }

    private static String getPossibleName(List<String> patterns) {
        String shortestPattern = findShortestPattern(patterns);
        patterns.remove(shortestPattern);
        
        List<Integer> shortestAsteriskPositions = getAsteriskPositions(shortestPattern);
        String result = "";
        
        for (String pattern : patterns) {
            List<Integer> patternAsteriskPositions = getAsteriskPositions(pattern);
            String combinedPattern = combinePatterns(shortestPattern, shortestAsteriskPositions, pattern, patternAsteriskPositions);
            
            if (combinedPattern.equals("*")) {
                return "*";
            }
            
            if (combinedPattern.length() > result.length()) {
                result = combinedPattern;
            }
        }
        
        return result.replace("*", "");
    }

    private static String findShortestPattern(List<String> patterns) {
        String shortestPattern = patterns.get(0);
        
        for (String pattern : patterns) {
            if (pattern.length() < shortestPattern.length()) {
                shortestPattern = pattern;
            }
        }
        
        return shortestPattern;
    }

    private static List<Integer> getAsteriskPositions(String pattern) {
        List<Integer> positions = new ArrayList<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == '*') {
                positions.add(i);
            }
        }
        
        return positions;
    }

    private static String combinePatterns(String shortestPattern, List<Integer> shortestAsteriskPositions, String pattern, List<Integer> patternAsteriskPositions) {
        StringBuilder combinedPattern = new StringBuilder();
        
        for (int i = 0; i < shortestAsteriskPositions.size(); i++) {
            int start = 0;
            int end = shortestPattern.length();
            
            String beforeAsterisk = shortestPattern.substring(start, shortestAsteriskPositions.get(i));
            String afterAsterisk = shortestPattern.substring(shortestAsteriskPositions.get(i) + 1, end);
            
            if (pattern.contains(beforeAsterisk) && pattern.contains(afterAsterisk)) {
                int beforeIndex = pattern.indexOf(beforeAsterisk) + beforeAsterisk.length();
                int afterIndex = pattern.indexOf(afterAsterisk);
                
                combinedPattern.append(beforeAsterisk)
                               .append(pattern, beforeIndex, afterIndex)
                               .append(afterAsterisk);
            } else {
                return "*";
            }
        }
        
        return combinedPattern.toString();
    }
}