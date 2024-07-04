import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character after the integer input
        StringBuilder resultOutput = new StringBuilder();

        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            String inputLine = scanner.nextLine();
            StringBuilder caseResult = new StringBuilder();
            int currentDepth = 0;

            for (char digitChar : inputLine.toCharArray()) {
                int digit = Character.getNumericValue(digitChar);

                if (digit > currentDepth) {
                    caseResult.append("(".repeat(digit - currentDepth));
                } else if (digit < currentDepth) {
                    caseResult.append(")".repeat(currentDepth - digit));
                }

                currentDepth = digit;
                caseResult.append(digit);
            }

            caseResult.append(")".repeat(currentDepth));

            resultOutput.append("Case #").append(caseIndex + 1).append(": ").append(caseResult).append("\n");
        }

        System.out.print(resultOutput);
    }
}