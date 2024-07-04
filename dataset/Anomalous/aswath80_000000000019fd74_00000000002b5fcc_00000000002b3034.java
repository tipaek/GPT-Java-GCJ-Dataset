import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCaseCount; t++) {
            int patternCount = scanner.nextInt();
            scanner.nextLine();
            String[] patterns = new String[patternCount];
            int maxPatternLength = 0;

            for (int i = 0; i < patternCount; i++) {
                String pattern = scanner.nextLine().trim();
                maxPatternLength = Math.max(maxPatternLength, pattern.length());
                patterns[i] = pattern;
            }

            for (int i = 0; i < patternCount; i++) {
                patterns[i] = padPattern(patterns[i], maxPatternLength);
            }

            processTestCase(t, patterns, maxPatternLength);
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
                System.out.println(String.format("Case #%d: *", testCaseNumber));
                return;
            } else if (solutionChar == '*') {
                System.out.println(String.format("Case #%d: %s", testCaseNumber, result.toString()));
                return;
            } else {
                result.insert(0, solutionChar);
            }
        }

        System.out.println(String.format("Case #%d: %s", testCaseNumber, result.toString()));
    }

    private static char findSolutionChar(String[] patterns, int position) {
        char resultChar = '*';

        for (String pattern : patterns) {
            char currentChar = pattern.charAt(position);

            if (resultChar == '*' && currentChar == '*') {
                continue;
            } else if (resultChar == '*' && currentChar != '*') {
                resultChar = currentChar;
            } else if (resultChar != '*' && currentChar == '*') {
                continue;
            } else if (resultChar != '*' && currentChar != resultChar) {
                return '$';
            }
        }

        return resultChar;
    }
}