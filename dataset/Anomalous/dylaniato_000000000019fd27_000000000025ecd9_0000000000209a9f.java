import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cases; i++) {
            String input = scanner.nextLine();
            Integer[] digits = new Integer[input.length()];
            for (int j = 0; j < input.length(); j++) {
                digits[j] = Character.getNumericValue(input.charAt(j));
            }
            System.out.printf("Case #%d: %s%n", i + 1, nestingDepths(digits));
        }
    }

    private static String nestingDepths(Integer[] digits) {
        StringBuilder result = new StringBuilder();
        int currentOpenBrackets = 0;

        for (int digit : digits) {
            if (digit > currentOpenBrackets) {
                for (int j = 0; j < digit - currentOpenBrackets; j++) {
                    result.append("(");
                }
            } else if (digit < currentOpenBrackets) {
                for (int j = 0; j < currentOpenBrackets - digit; j++) {
                    result.append(")");
                }
            }
            currentOpenBrackets = digit;
            result.append(digit);
        }

        while (currentOpenBrackets > 0) {
            result.append(")");
            currentOpenBrackets--;
        }

        return result.toString();
    }
}