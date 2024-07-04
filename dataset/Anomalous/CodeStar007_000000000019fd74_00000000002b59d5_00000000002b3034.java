import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int numberOfPatterns = scanner.nextInt();
            String[] patterns = new String[numberOfPatterns];

            for (int i = 0; i < numberOfPatterns; i++) {
                patterns[i] = scanner.next();
            }

            processPatterns(numberOfPatterns, patterns, caseNumber);
            caseNumber++;
        }
    }

    private static void processPatterns(int numberOfPatterns, String[] patterns, int caseNumber) {
        Arrays.sort(patterns);
        String basePattern = patterns[0];

        for (int i = 0; i < numberOfPatterns; i++) {
            if (!basePattern.contains(patterns[i].substring(1))) {
                System.out.println("Case #" + caseNumber + ": *");
                return;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + basePattern);
    }
}