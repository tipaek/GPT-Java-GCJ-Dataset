import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCaseCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCaseCount; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            String inputString = scanner.nextLine();
            int openParentheses = 0;

            for (char ch : inputString.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                while (openParentheses > digit) {
                    System.out.print(")");
                    openParentheses--;
                }
                while (openParentheses < digit) {
                    System.out.print("(");
                    openParentheses++;
                }
                System.out.print(digit);
            }

            while (openParentheses > 0) {
                System.out.print(")");
                openParentheses--;
            }
            System.out.println();
        }
    }
}