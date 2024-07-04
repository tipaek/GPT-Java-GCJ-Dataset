import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < testCases; i++) {
            String inputLine = scanner.nextLine();
            StringBuilder resultBuilder = new StringBuilder();
            int openParentheses = 0;

            for (char ch : inputLine.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                while (openParentheses < digit) {
                    resultBuilder.append("(");
                    openParentheses++;
                }

                while (openParentheses > digit) {
                    resultBuilder.append(")");
                    openParentheses--;
                }

                resultBuilder.append(digit);
            }

            while (openParentheses > 0) {
                resultBuilder.append(")");
                openParentheses--;
            }

            System.out.println("Case #" + (i + 1) + ": " + resultBuilder.toString());
        }

        scanner.close();
    }
}