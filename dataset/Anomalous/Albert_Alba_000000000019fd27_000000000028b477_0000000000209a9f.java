import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCaseCount = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input

        for (int i = 0; i < testCaseCount; i++) {
            String inputString = scanner.nextLine();
            System.out.print("Case #" + (i + 1) + ": ");
            int openParentheses = 0;

            for (int j = 0; j < inputString.length(); j++) {
                int currentDigit = inputString.charAt(j) - '0';

                while (openParentheses < currentDigit) {
                    System.out.print("(");
                    openParentheses++;
                }
                while (openParentheses > currentDigit) {
                    System.out.print(")");
                    openParentheses--;
                }
                System.out.print(currentDigit);
            }

            while (openParentheses > 0) {
                System.out.print(")");
                openParentheses--;
            }
            System.out.println();
        }

        scanner.close();
    }
}