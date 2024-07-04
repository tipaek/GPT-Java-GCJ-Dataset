import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int patternCount = scanner.nextInt();
            String[] patterns = new String[patternCount];

            for (int i = 0; i < patternCount; i++) {
                patterns[i] = scanner.next();
            }

            processPatterns(patternCount, patterns, caseNumber);
            caseNumber++;
        }
    }

    private static void processPatterns(int patternCount, String[] patterns, int caseNumber) {
        Arrays.sort(patterns);
        boolean isMatchFound = false;

        for (int i = 0; i < patternCount; i++) {
            String currentPattern = new StringBuilder(patterns[i].substring(1)).reverse().toString();
            boolean isValid = true;

            for (int j = 0; j < patternCount; j++) {
                String otherPattern = new StringBuilder(patterns[j].substring(1)).reverse().toString();
                if (!currentPattern.startsWith(otherPattern)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println("Case #" + caseNumber + ": " + patterns[i].substring(1));
                isMatchFound = true;
                break;
            }
        }

        if (!isMatchFound) {
            System.out.println("Case #" + caseNumber + ": *");
        }
    }
}