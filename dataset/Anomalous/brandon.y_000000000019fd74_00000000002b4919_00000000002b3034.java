import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numberOfPatterns = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            String longestRightPattern = "";
            boolean isImpossible = false;

            for (int j = 0; j < numberOfPatterns; j++) {
                String pattern = scanner.nextLine();
                String rightPattern = pattern.substring(1);

                if (rightPattern.length() > longestRightPattern.length()) {
                    if (rightPattern.contains(longestRightPattern)) {
                        longestRightPattern = rightPattern;
                    } else {
                        isImpossible = true;
                    }
                } else if (!longestRightPattern.contains(rightPattern)) {
                    isImpossible = true;
                }
            }

            String result = isImpossible ? "*" : longestRightPattern;
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }
}