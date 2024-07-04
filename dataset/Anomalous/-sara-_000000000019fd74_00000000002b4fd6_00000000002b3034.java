import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int patternCount = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            String[] patterns = new String[patternCount];
            for (int patternIndex = 0; patternIndex < patternCount; patternIndex++) {
                patterns[patternIndex] = scanner.nextLine();
            }
            
            String longestEndingPattern = "";
            boolean isValid = true;
            
            for (String pattern : patterns) {
                String ending = pattern.substring(pattern.indexOf('*') + 1);
                if (ending.length() > longestEndingPattern.length()) {
                    if (ending.contains(longestEndingPattern)) {
                        longestEndingPattern = ending;
                    } else {
                        isValid = false;
                        break;
                    }
                } else {
                    if (!longestEndingPattern.contains(ending)) {
                        isValid = false;
                        break;
                    }
                }
            }
            
            String result = isValid ? longestEndingPattern : "*";
            System.out.println("Case #" + caseIndex + ": " + result);
        }
        
        scanner.close();
    }
}