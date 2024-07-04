import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCases = scanner.nextInt();

        for (int currentCase = 1; currentCase <= numberOfCases; currentCase++) {
            int numberOfPatterns = scanner.nextInt();
            String[] patterns = new String[numberOfPatterns];

            for (int i = 0; i < numberOfPatterns; i++) {
                patterns[i] = scanner.next();
            }

            String longestPattern = "";

            for (String pattern : patterns) {
                if (pattern.length() > longestPattern.length()) {
                    longestPattern = pattern;
                }
            }

            boolean isValid = true;

            for (String pattern : patterns) {
                if (!longestPattern.contains(pattern.substring(1))) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println("Case #" + currentCase + ": " + longestPattern.substring(1));
            } else {
                System.out.println("Case #" + currentCase + ": *");
            }
        }
    }
}