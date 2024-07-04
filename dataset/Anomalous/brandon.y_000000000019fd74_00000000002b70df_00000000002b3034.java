import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int patternCount = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            String longestSuffix = "";
            boolean isImpossible = false;

            for (int i = 0; i < patternCount; i++) {
                String pattern = scanner.nextLine();
                String suffix = pattern.substring(1);

                if (suffix.length() > longestSuffix.length()) {
                    if (suffix.contains(longestSuffix)) {
                        longestSuffix = suffix;
                    } else {
                        isImpossible = true;
                    }
                } else {
                    if (longestSuffix.contains(suffix)) {
                        if (!longestSuffix.endsWith(suffix)) {
                            isImpossible = true;
                        }
                    } else {
                        isImpossible = true;
                    }
                }
            }

            String result = isImpossible ? "*" : longestSuffix;
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}