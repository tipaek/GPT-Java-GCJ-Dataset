import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];
        
        for (int i = 0; i < testCases; i++) {
            int numPatterns = scanner.nextInt();
            results[i] = processPatterns(numPatterns, scanner);
        }
        
        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }

    private static String processPatterns(int numPatterns, Scanner scanner) {
        String[] patterns = new String[numPatterns];
        String combinedPattern = "";
        
        for (int i = 0; i < numPatterns; i++) {
            patterns[i] = scanner.next();
        }
        
        for (String pattern : patterns) {
            String cleanedPattern = pattern.replaceFirst("\\*", "");
            
            if (combinedPattern.length() >= cleanedPattern.length()) {
                if (!combinedPattern.endsWith(cleanedPattern)) {
                    return "*";
                }
            } else {
                if (!cleanedPattern.endsWith(combinedPattern)) {
                    return "*";
                }
                combinedPattern = cleanedPattern;
            }
        }
        
        return "A" + combinedPattern;
    }
}