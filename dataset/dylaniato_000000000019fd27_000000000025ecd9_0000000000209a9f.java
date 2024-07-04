import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cases; i++) {
            String[] digitStrings = scanner.nextLine().split("");
            Integer[] digits = new Integer[digitStrings.length];
            Arrays.stream(digitStrings)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList())
                    .toArray(digits);
            System.out.println(String.format("Case #%s: %s", i + 1, nestingDepths(digits)));
        }
    }

    private static String nestingDepths(Integer[] digits) {
        StringBuilder result = new StringBuilder();
        int currentOpenBrackets = 0;
        for (int i = 0; i < digits.length; i++) {
            int currentDigit = digits[i];
            if (currentDigit > currentOpenBrackets) {
                // open currentDigit - currentOpenBrackets parenthesis
                for (int j = 0; j < currentDigit - currentOpenBrackets; j++) {
                    result.append("(");
                    currentOpenBrackets++;
                }
            } else if (currentDigit < currentOpenBrackets) {
                // close currentOpenBrackets - currentDigit parenthesis
                for (int j = 0; j < currentOpenBrackets - currentDigit; j++) {
                    result.append(")");
                    currentOpenBrackets--;
                }
            }
            // add the current digit
            result.append(currentDigit);
        }

        while (currentOpenBrackets > 0) {
            result.append(")");
            currentOpenBrackets--;
        }

        return result.toString();
    }


}
