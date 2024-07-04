import java.util.*;

public class NestingDepth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String numberStr = scanner.next();
            List<Integer> numbers = splitToDigits(numberStr);
            String solution = generateParentheses(numbers);
            solution = removeAdjacentParentheses(solution);
            System.out.println("Case #" + caseNum + ": " + solution);
        }
    }

    public static List<Integer> splitToDigits(String numberStr) {
        List<Integer> digits = new ArrayList<>();
        for (char ch : numberStr.toCharArray()) {
            digits.add(Character.getNumericValue(ch));
        }
        return digits;
    }

    public static String generateParentheses(List<Integer> digits) {
        StringBuilder result = new StringBuilder();
        for (int digit : digits) {
            StringBuilder nested = new StringBuilder(String.valueOf(digit));
            for (int i = 0; i < digit; i++) {
                nested.insert(0, "(").append(")");
            }
            result.append(nested);
        }
        return result.toString();
    }

    public static String removeAdjacentParentheses(String str) {
        while (str.contains(")(")) {
            str = str.replace(")(", "");
        }
        return str;
    }
}