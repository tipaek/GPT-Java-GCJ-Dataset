import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        processInput();
    }

    static void processInput() {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            String number = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (int j = 0; j < number.length(); j++) {
                int digit = Character.getNumericValue(number.charAt(j));
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

            System.out.printf("Case #%d: %s%n", i, result.toString());
        }
    }
}