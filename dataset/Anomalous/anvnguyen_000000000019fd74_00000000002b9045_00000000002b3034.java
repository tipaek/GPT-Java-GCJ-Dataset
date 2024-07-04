import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numPatterns = scanner.nextInt();
            String[] patterns = new String[numPatterns];

            for (int j = 0; j < numPatterns; j++) {
                patterns[j] = scanner.next();
            }

            System.out.println("Case #" + testCase + ": " + findPattern(patterns));
        }
    }

    public static String findPattern(String[] patterns) {
        String finalPattern = "*";

        for (String pattern : patterns) {
            String regexPattern = pattern.replace("*", "(.*)");
            String regexFinal = finalPattern.replace("*", "(.*)");

            if (pattern.matches(regexFinal) || pattern.replace("*", "").matches(regexFinal)) {
                finalPattern = pattern;
                continue;
            }

            if (finalPattern.matches(regexPattern) || finalPattern.replace("*", "").matches(regexPattern)) {
                continue;
            }

            return "*";
        }

        return finalPattern.replace("*", "");
    }
}