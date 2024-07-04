import java.util.Scanner;

public class Solution {

    private static final String OPEN_PARENTHESIS = "(";
    private static final String CLOSE_PARENTHESIS = ")";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        
        for (int i = 1; i <= cases; i++) {
            String input = scanner.next();
            String formatted = formatParenthesis(input);
            System.out.printf("Case #%d: %s\n", i, formatted);
        }
    }

    private static String formatParenthesis(String number) {
        StringBuilder result = new StringBuilder();
        int lastNumber = 0;
        int openParentheses = 0;

        for (char c : number.toCharArray()) {
            int currentNumber = Character.getNumericValue(c);

            if (currentNumber > lastNumber) {
                result.append(repeat(OPEN_PARENTHESIS, currentNumber - lastNumber));
                openParentheses += currentNumber - lastNumber;
            } else if (currentNumber < lastNumber) {
                result.append(repeat(CLOSE_PARENTHESIS, lastNumber - currentNumber));
                openParentheses -= lastNumber - currentNumber;
            }

            result.append(currentNumber);
            lastNumber = currentNumber;
        }

        result.append(repeat(CLOSE_PARENTHESIS, openParentheses));
        return result.toString();
    }

    private static String repeat(String str, int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(str);
        }
        return result.toString();
    }
}