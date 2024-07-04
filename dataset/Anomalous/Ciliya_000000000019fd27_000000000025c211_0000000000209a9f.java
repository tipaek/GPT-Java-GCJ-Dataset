import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            String input = scanner.nextLine();
            StringBuilder output = new StringBuilder();

            int currentDepth = 0;
            for (char ch : input.toCharArray()) {
                int digit = ch - '0';

                // Adjust the number of opening brackets
                while (currentDepth < digit) {
                    output.append('(');
                    currentDepth++;
                }
                // Adjust the number of closing brackets
                while (currentDepth > digit) {
                    output.append(')');
                    currentDepth--;
                }
                output.append(digit);
            }

            // Close any remaining open brackets
            while (currentDepth > 0) {
                output.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + caseNum + ": " + output.toString());
        }

        scanner.close();
    }
}