import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String number = scanner.next();
            List<Integer> digits = splitDigits(number);
            String solution = generateParentheses(digits);
            solution = removeAdjacentParentheses(solution);
            System.out.println("Case #" + i + ": " + solution);
        }
    }

    private static List<Integer> splitDigits(String number) {
        List<Integer> digits = new ArrayList<>();
        for (char ch : number.toCharArray()) {
            digits.add(Character.getNumericValue(ch));
        }
        return digits;
    }

    private static String generateParentheses(List<Integer> digits) {
        StringBuilder result = new StringBuilder();
        for (int digit : digits) {
            StringBuilder innerResult = new StringBuilder(String.valueOf(digit));
            for (int i = 0; i < digit; i++) {
                innerResult.insert(0, "(").append(")");
            }
            result.append(innerResult);
        }
        return result.toString();
    }

    private static String removeAdjacentParentheses(String input) {
        String result = input;
        while (result.contains(")(")) {
            result = result.replace(")(", "");
        }
        return result;
    }
}