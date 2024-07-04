import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCases = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character after the integer input

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            processCase(caseNumber, scanner);
        }
    }

    private static void processCase(int caseNumber, Scanner scanner) {
        String inputString = scanner.nextLine();
        StringBuilder output = new StringBuilder();

        int openParens = 0;
        for (char ch : inputString.toCharArray()) {
            int digit = Character.getNumericValue(ch);

            while (openParens > digit) {
                output.append(")");
                openParens--;
            }
            while (openParens < digit) {
                output.append("(");
                openParens++;
            }
            output.append(digit);
        }

        while (openParens > 0) {
            output.append(")");
            openParens--;
        }

        System.out.printf("Case #%d: %s%n", caseNumber, output.toString());
    }
}