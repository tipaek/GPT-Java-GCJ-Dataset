import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            StringBuilder result = new StringBuilder();
            int numberOfPatterns = scanner.nextInt();
            List<String> patterns = new ArrayList<>();
            List<Character> prefix = new ArrayList<>();
            List<Character> suffix = new ArrayList<>();
            boolean isImpossible = false;
            
            for (int j = 0; j < numberOfPatterns; j++) {
                if (isImpossible) break;
                
                String pattern = scanner.next();
                patterns.add(pattern);
                
                if (!pattern.startsWith("*")) {
                    for (int k = 0; k < Math.min(prefix.size(), pattern.indexOf("*")); k++) {
                        if (prefix.get(k) != pattern.charAt(k)) {
                            isImpossible = true;
                            break;
                        }
                    }
                    for (int k = prefix.size(); k < pattern.indexOf("*"); k++) {
                        prefix.add(pattern.charAt(k));
                    }
                }
                
                if (!pattern.endsWith("*")) {
                    for (int k = 0; k < Math.min(suffix.size(), pattern.length() - 1 - pattern.lastIndexOf("*")); k++) {
                        int pos = pattern.length() - 1 - k;
                        if (suffix.get(k) != pattern.charAt(pos)) {
                            isImpossible = true;
                            break;
                        }
                    }
                    for (int k = pattern.length() - 1 - suffix.size(); k > pattern.lastIndexOf("*"); k--) {
                        suffix.add(pattern.charAt(k));
                    }
                }
            }
            
            if (!isImpossible) {
                for (Character character : prefix) {
                    result.append(character);
                }
                for (String pattern : patterns) {
                    int start = pattern.indexOf("*");
                    int end = pattern.lastIndexOf("*");
                    for (int k = start + 1; k < end; k++) {
                        if (pattern.charAt(k) != '*') {
                            result.append(pattern.charAt(k));
                        }
                    }
                }
                for (int k = suffix.size() - 1; k >= 0; k--) {
                    result.append(suffix.get(k));
                }
            } else {
                result.append("*");
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }
}