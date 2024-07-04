import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int patternsCount = scanner.nextInt();
            
            Set<String> prefixes = new HashSet<>();
            Set<String> suffixes = new HashSet<>();
            String longestPrefix = "";
            String longestSuffix = "";
            
            for (int i = 0; i < patternsCount; i++) {
                String pattern = scanner.next();
                String prefix = pattern.substring(0, pattern.indexOf('*'));
                String suffix = pattern.substring(pattern.indexOf('*') + 1);
                
                if (!prefix.isEmpty()) {
                    prefixes.add(prefix);
                    if (prefix.length() > longestPrefix.length()) {
                        longestPrefix = prefix;
                    }
                }
                
                if (!suffix.isEmpty()) {
                    suffixes.add(suffix);
                    if (suffix.length() > longestSuffix.length()) {
                        longestSuffix = suffix;
                    }
                }
            }
            
            String combinedPattern = longestPrefix + longestSuffix;
            boolean isValid = true;
            
            for (String prefix : prefixes) {
                if (!combinedPattern.startsWith(prefix)) {
                    isValid = false;
                    break;
                }
            }
            
            for (String suffix : suffixes) {
                if (!combinedPattern.endsWith(suffix)) {
                    isValid = false;
                    break;
                }
            }
            
            if (!isValid) {
                combinedPattern = "*";
            }
            
            System.out.println("Case #" + caseNumber + ": " + combinedPattern);
        }
        
        scanner.close();
    }
}