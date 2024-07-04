import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentOpenParentheses = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                while (currentOpenParentheses < digit) {
                    result.append('(');
                    currentOpenParentheses++;
                }

                while (currentOpenParentheses > digit) {
                    result.append(')');
                    currentOpenParentheses--;
                }

                result.append(ch);
            }

            while (currentOpenParentheses > 0) {
                result.append(')');
                currentOpenParentheses--;
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }

        scanner.close();
    }
}