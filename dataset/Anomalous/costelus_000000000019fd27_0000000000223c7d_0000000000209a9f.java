import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().processInput();
    }

    public void processInput() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline
        String[] outputs = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine();
            outputs[i] = generatePaddedString(input);
        }

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + outputs[i]);
        }
    }

    private String generatePaddedString(String input) {
        StringBuilder result = new StringBuilder();
        int openBrackets = 0;

        for (char ch : input.toCharArray()) {
            int digit = ch - '0';
            while (openBrackets < digit) {
                result.append("(");
                openBrackets++;
            }
            while (openBrackets > digit) {
                result.append(")");
                openBrackets--;
            }
            result.append(digit);
        }

        while (openBrackets > 0) {
            result.append(")");
            openBrackets--;
        }

        return result.toString();
    }
}