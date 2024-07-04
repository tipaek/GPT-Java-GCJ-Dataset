import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        processInput();
    }

    private static void processInput() {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String number = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (int index = 0; index < number.length(); index++) {
                int digit = number.charAt(index) - '0';
                int depthChange = digit - currentDepth;

                if (depthChange > 0) {
                    result.append("(".repeat(depthChange));
                } else if (depthChange < 0) {
                    result.append(")".repeat(-depthChange));
                }

                result.append(digit);
                currentDepth = digit;
            }

            if (currentDepth > 0) {
                result.append(")".repeat(currentDepth));
            }

            System.out.printf("Case #%d: %s%n", caseNumber, result.toString());
        }
    }
}