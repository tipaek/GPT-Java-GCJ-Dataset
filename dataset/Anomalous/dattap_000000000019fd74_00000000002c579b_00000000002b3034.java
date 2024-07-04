import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int N = Integer.parseInt(scanner.nextLine());
            String[] patterns = new String[N];
            String[] originalPatterns = new String[N];

            for (int i = 0; i < N; i++) {
                patterns[i] = scanner.nextLine();
                originalPatterns[i] = patterns[i];
            }

            String longestSuffix = "";
            boolean foundInitialSuffix = false;
            boolean validSuffix = false;

            for (int i = 0; i < N; i++) {
                if (patterns[i].charAt(0) == '*') {
                    String currentSuffix = patterns[i].substring(1);

                    if (!foundInitialSuffix && i == 0) {
                        longestSuffix = currentSuffix;
                        foundInitialSuffix = true;
                    } else {
                        if (longestSuffix.contains(currentSuffix)) {
                            validSuffix = true;
                        } else if (currentSuffix.contains(longestSuffix)) {
                            longestSuffix = currentSuffix;
                            validSuffix = true;
                        } else {
                            longestSuffix = "";
                            validSuffix = false;
                        }
                    }
                }
            }

            if (longestSuffix.isEmpty()) {
                System.out.println("Case #" + testCase + ": *");
            } else {
                System.out.println("Case #" + testCase + ": " + longestSuffix);
            }
        }

        scanner.close();
    }
}