import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numberOfCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;

            for (char ch : input.toCharArray()) {
                int currentDigit = Character.getNumericValue(ch);

                while (openParentheses < currentDigit) {
                    result.append("(");
                    openParentheses++;
                }
                while (openParentheses > currentDigit) {
                    result.append(")");
                    openParentheses--;
                }

                result.append(ch);
            }

            while (openParentheses > 0) {
                result.append(")");
                openParentheses--;
            }

            System.out.println("Case #" + caseIndex + ": " + result.toString());
        }

        scanner.close();
    }
}