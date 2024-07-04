import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 1; i <= T; i++) {
            StringBuilder result = new StringBuilder();
            String N = scanner.next();

            for (int index = 0; index < N.length(); index++) {
                char digitChar = N.charAt(index);
                int digit = digitChar - '0';
                int requiredParentheses = digit;

                int backIndex = result.length() - 1;
                while (backIndex >= 0 && requiredParentheses > 0) {
                    if (result.charAt(backIndex) == ')') {
                        backIndex--;
                        requiredParentheses--;
                        continue;
                    }
                    int currentNumber = result.charAt(backIndex) - '0';
                    if (currentNumber <= requiredParentheses) {
                        break;
                    }
                }

                if (backIndex >= 0) {
                    result.insert(backIndex + 1, encloseWithParentheses(String.valueOf(digit), requiredParentheses));
                } else {
                    result = new StringBuilder(encloseWithParentheses(String.valueOf(digit), requiredParentheses));
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String encloseWithParentheses(String str, int count) {
        if (count <= 0) {
            return str;
        }
        return encloseWithParentheses("(" + str + ")", --count);
    }
}