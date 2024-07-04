import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        int caseNumber = 1;
        
        while (testCases-- > 0) {
            int n = scanner.nextInt();
            String[] patterns = new String[n];

            for (int i = 0; i < n; i++) {
                patterns[i] = scanner.next();
            }

            if (patterns[0].charAt(0) == '*') {
                String shortestPattern = patterns[0];
                for (int i = 1; i < n; i++) {
                    if (patterns[i].length() < shortestPattern.length()) {
                        shortestPattern = patterns[i];
                    }
                }

                boolean isValid = true;
                for (int i = 0; i < n; i++) {
                    int minIndex = shortestPattern.length() - 1;
                    int patternIndex = patterns[i].length() - 1;

                    while (minIndex != 0 && patternIndex != 0) {
                        if (shortestPattern.charAt(minIndex) == '*') {
                            break;
                        }

                        if (shortestPattern.charAt(minIndex) != patterns[i].charAt(patternIndex)) {
                            isValid = false;
                            break;
                        }
                        minIndex--;
                        patternIndex--;
                    }

                    if (!isValid) {
                        break;
                    }
                }

                if (isValid) {
                    int longestPatternIndex = 0;
                    for (int i = 1; i < n; i++) {
                        if (patterns[longestPatternIndex].length() < patterns[i].length()) {
                            longestPatternIndex = i;
                        }
                    }
                    System.out.println("CASE #" + caseNumber + ": " + patterns[longestPatternIndex].substring(1));
                } else {
                    System.out.println("CASE #" + caseNumber + ": *");
                }
                caseNumber++;
            }
        }
        scanner.close();
    }
}