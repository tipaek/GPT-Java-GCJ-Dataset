import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            String inputString = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;

            for (int j = 0; j < inputString.length(); j++) {
                int currentDigit = Character.getNumericValue(inputString.charAt(j));

                while (openParentheses < currentDigit) {
                    result.append("(");
                    openParentheses++;
                }

                while (openParentheses > currentDigit) {
                    result.append(")");
                    openParentheses--;
                }

                result.append(inputString.charAt(j));
            }

            while (openParentheses > 0) {
                result.append(")");
                openParentheses--;
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }
    }
}