import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases > 0) {
            int patternCount = scanner.nextInt();
            String[] patterns = new String[patternCount];

            for (int i = 0; i < patternCount; i++) {
                patterns[i] = scanner.next();
            }

            processPatterns(patternCount, patterns, caseNumber);
            testCases--;
            caseNumber++;
        }
    }

    static void processPatterns(int patternCount, String[] patterns, int caseNumber) {
        Arrays.sort(patterns);
        boolean isMatchFound = false;

        for (int i = 0; i < patternCount; i++) {
            isMatchFound = false;
            StringBuilder sb = new StringBuilder(patterns[i].substring(1));
            String reversedPattern = sb.reverse().toString();

            for (int j = 0; j < patternCount; j++) {
                String reversedCheckPattern = new StringBuilder(patterns[j].substring(1)).reverse().toString();

                if (!reversedPattern.startsWith(reversedCheckPattern)) {
                    isMatchFound = false;
                    break;
                } else {
                    isMatchFound = true;
                }
            }

            if (isMatchFound) {
                System.out.println("Case #" + caseNumber + ": " + patterns[i]);
                return;
            }
        }

        System.out.println("Case #" + caseNumber + ": *");
    }
}