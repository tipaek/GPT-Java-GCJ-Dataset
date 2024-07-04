import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int patternCount = scanner.nextInt();
            String[] patterns = new String[patternCount];
            
            for (int j = 0; j < patternCount; j++) {
                patterns[j] = scanner.next();
            }
            
            String result = findPattern(patterns);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String findPattern(String[] patterns) {
        String longestPrefix = "";
        String longestSuffix = "";
        List<List<String>> splitPatterns = new ArrayList<>();

        for (String pattern : patterns) {
            String[] splitPattern = pattern.split("\\*");
            List<String> patternList = new ArrayList<>();
            
            for (String part : splitPattern) {
                patternList.add(part);
            }
            
            if (pattern.endsWith("*")) {
                patternList.add("");
            }
            
            splitPatterns.add(patternList);
            
            if (splitPattern[0].length() > longestPrefix.length()) {
                longestPrefix = splitPattern[0];
            }
            
            if (splitPattern[splitPattern.length - 1].length() > longestSuffix.length()) {
                longestSuffix = splitPattern[splitPattern.length - 1];
            }
        }

        List<String> middleParts = new ArrayList<>();
        int totalLength = longestPrefix.length() + longestSuffix.length();

        for (List<String> patternList : splitPatterns) {
            String prefix = patternList.get(0);
            String suffix = patternList.get(patternList.size() - 1);
            
            if (!longestPrefix.startsWith(prefix) || !longestSuffix.endsWith(suffix)) {
                return "*";
            }

            for (int j = 1; j < patternList.size() - 1; j++) {
                String part = patternList.get(j);
                boolean found = false;
                
                for (int k = 0; k < middleParts.size(); k++) {
                    String existingPart = middleParts.get(k);
                    
                    if (existingPart.contains(part)) {
                        found = true;
                        break;
                    }
                    
                    if (part.contains(existingPart)) {
                        middleParts.set(k, part);
                        totalLength += (part.length() - existingPart.length());
                        found = true;
                        break;
                    }
                }
                
                if (!found) {
                    middleParts.add(part);
                    totalLength += part.length();
                }
                
                if (totalLength > 10000) {
                    return "*";
                }
            }
        }

        StringBuilder result = new StringBuilder(longestPrefix);
        
        for (String middlePart : middleParts) {
            result.append(middlePart);
        }
        
        result.append(longestSuffix);
        return result.toString();
    }
}