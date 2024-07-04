import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            int N = Integer.parseInt(scanner.nextLine());
            String[] patterns = new String[N];

            for (int i = 0; i < N; i++) {
                patterns[i] = scanner.nextLine();
            }

            String longestSuffix = "";
            boolean foundFirstSuffix = false;
            boolean foundSecondSuffix = false;

            for (String pattern : patterns) {
                if (pattern.charAt(0) == '*') {
                    String currentSuffix = pattern.substring(1);

                    if (!foundFirstSuffix) {
                        longestSuffix = currentSuffix;
                        foundFirstSuffix = true;
                    } else {
                        if (longestSuffix.contains(currentSuffix)) {
                            longestSuffix = currentSuffix;
                            foundSecondSuffix = true;
                        } else if (currentSuffix.contains(longestSuffix)) {
                            longestSuffix = currentSuffix;
                            foundSecondSuffix = true;
                        }
                    }
                }
            }

            if (foundFirstSuffix && !foundSecondSuffix && N > 1) {
                longestSuffix = "";
            }

            if (longestSuffix.isEmpty()) {
                System.out.println("Case #" + caseNumber + ": *");
            } else {
                System.out.println("Case #" + caseNumber + ": " + longestSuffix);
            }
        }
    }
}