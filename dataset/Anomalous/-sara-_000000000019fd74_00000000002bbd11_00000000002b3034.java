import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int patternCount = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            String[] patterns = new String[patternCount];
            
            for (int i = 0; i < patternCount; i++) {
                patterns[i] = scanner.nextLine();
            }

            String longestPrefix = "";
            String longestSuffix = "";
            boolean isValid = true;

            for (String pattern : patterns) {
                String[] parts = pattern.split("\\*", 2);
                String prefix = parts[0];
                String suffix = parts.length > 1 ? parts[1] : "";

                if (prefix.length() > longestPrefix.length()) {
                    if (!prefix.startsWith(longestPrefix)) {
                        isValid = false;
                        break;
                    }
                    longestPrefix = prefix;
                } else if (!longestPrefix.startsWith(prefix)) {
                    isValid = false;
                    break;
                }

                if (suffix.length() > longestSuffix.length()) {
                    if (!suffix.endsWith(longestSuffix)) {
                        isValid = false;
                        break;
                    }
                    longestSuffix = suffix;
                } else if (!longestSuffix.endsWith(suffix)) {
                    isValid = false;
                    break;
                }
            }

            String result = isValid ? longestPrefix + longestSuffix : "*";
            System.out.println("Case #" + caseNumber + ": " + result);
        }
        
        scanner.close();
    }
}