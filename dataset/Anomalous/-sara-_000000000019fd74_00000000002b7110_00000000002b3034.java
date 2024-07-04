import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int patternCount = scanner.nextInt();
            scanner.nextLine();
            String[] patterns = new String[patternCount];

            for (int j = 0; j < patternCount; j++) {
                patterns[j] = scanner.nextLine();
            }

            String longestPrefix = "";
            String longestSuffix = "";
            boolean isValid = true;

            for (String pattern : patterns) {
                String prefix = pattern.substring(0, pattern.indexOf('*'));
                String suffix = pattern.substring(pattern.indexOf('*') + 1);

                if (prefix.length() > longestPrefix.length()) {
                    if (prefix.startsWith(longestPrefix)) {
                        longestPrefix = prefix;
                    } else {
                        isValid = false;
                        break;
                    }
                } else if (!longestPrefix.startsWith(prefix)) {
                    isValid = false;
                    break;
                }

                if (suffix.length() > longestSuffix.length()) {
                    if (suffix.endsWith(longestSuffix)) {
                        longestSuffix = suffix;
                    } else {
                        isValid = false;
                        break;
                    }
                } else if (!longestSuffix.endsWith(suffix)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println("Case #" + caseNum + ": " + longestPrefix + longestSuffix);
            } else {
                System.out.println("Case #" + caseNum + ": *");
            }
        }
        
        scanner.close();
    }
}