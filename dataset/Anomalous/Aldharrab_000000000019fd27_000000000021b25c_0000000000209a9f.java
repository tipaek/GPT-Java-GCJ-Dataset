import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numEntries = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numEntries; i++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                while (openParentheses < digit) {
                    result.append('(');
                    openParentheses++;
                }
                while (openParentheses > digit) {
                    result.append(')');
                    openParentheses--;
                }
                result.append(digit);
            }

            while (openParentheses > 0) {
                result.append(')');
                openParentheses--;
            }

            System.out.println(result.toString());
        }

        scanner.close();
    }
}