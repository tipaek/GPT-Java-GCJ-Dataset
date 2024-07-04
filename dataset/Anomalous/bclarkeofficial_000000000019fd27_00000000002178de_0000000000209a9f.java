import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            String inputLine = scanner.nextLine();

            for (char ch : inputLine.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                int depthDifference = digit - currentDepth;

                if (depthDifference > 0) {
                    result.append("(".repeat(depthDifference));
                } else if (depthDifference < 0) {
                    result.append(")".repeat(-depthDifference));
                }

                result.append(ch);
                currentDepth = digit;
            }

            result.append(")".repeat(currentDepth));
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}