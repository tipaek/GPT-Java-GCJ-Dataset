import java.util.Scanner;

public class Solution {

    private void appendCharacters(StringBuilder sb, int count, char character) {
        for (int i = 0; i < count; i++) {
            sb.append(character);
        }
    }

    public String solve(String digits) {
        StringBuilder result = new StringBuilder();
        int previousDigit = 0;

        for (int i = 0; i < digits.length(); i++) {
            char currentChar = digits.charAt(i);
            int currentDigit = Character.getNumericValue(currentChar);

            int difference = currentDigit - previousDigit;
            if (difference > 0) {
                appendCharacters(result, difference, '(');
            } else {
                appendCharacters(result, -difference, ')');
            }

            result.append(currentChar);
            previousDigit = currentDigit;
        }

        appendCharacters(result, previousDigit, ')');

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; t++) {
            String digits = scanner.nextLine();
            String result = solution.solve(digits);
            System.out.println("Case #" + t + ": " + result);
        }

        scanner.close();
    }
}