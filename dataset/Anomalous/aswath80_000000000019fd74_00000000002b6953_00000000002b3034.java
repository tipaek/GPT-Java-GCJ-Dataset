import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] patterns = new String[n];
            int maxLength = 0;

            for (int i = 0; i < n; i++) {
                String pattern = scanner.nextLine().trim();
                maxLength = Math.max(maxLength, pattern.length());
                patterns[i] = pattern;
            }

            for (int i = 0; i < n; i++) {
                patterns[i] = padPattern(patterns[i], maxLength);
            }

            processTestCase(t, patterns, maxLength);
        }
    }

    private static String padPattern(String pattern, int maxLength) {
        StringBuilder paddedPattern = new StringBuilder();
        int paddingLength = maxLength - pattern.length();
        
        for (int i = 0; i < paddingLength; i++) {
            paddedPattern.append('*');
        }
        
        paddedPattern.append(pattern);
        return paddedPattern.toString();
    }

    private static void processTestCase(int testCaseNumber, String[] patterns, int maxLength) {
        StringBuilder result = new StringBuilder();

        for (int i = maxLength - 1; i >= 0; i--) {
            char solutionChar = findSolutionChar(patterns, i);
            
            if (solutionChar == '$') {
                System.out.printf("Case #%d: *%n", testCaseNumber);
                return;
            } else if (solutionChar == '*') {
                result.insert(0, 'A');
            } else {
                result.insert(0, solutionChar);
            }
        }

        System.out.printf("Case #%d: %s%n", testCaseNumber, result.toString());
    }

    private static char findSolutionChar(String[] patterns, int position) {
        char solutionChar = '*';

        for (String pattern : patterns) {
            char currentChar = pattern.charAt(position);

            if (solutionChar == '*' && currentChar != '*') {
                solutionChar = currentChar;
            } else if (solutionChar != '*' && currentChar != '*' && solutionChar != currentChar) {
                return '$';
            }
        }

        return solutionChar;
    }
}