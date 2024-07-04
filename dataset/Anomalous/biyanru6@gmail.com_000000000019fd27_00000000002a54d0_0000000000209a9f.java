import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            for (char character : input.toCharArray()) {
                int digit = Character.getNumericValue(character);
                result.append("(".repeat(digit))
                      .append(character)
                      .append(")".repeat(digit));
            }
            System.out.println("Case #" + i + ": " + simplify(result));
        }
    }

    private static String simplify(StringBuilder input) {
        StringBuilder simplified = new StringBuilder();
        boolean[] toAppend = new boolean[input.length()];
        toAppend[0] = true;

        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isDigit(currentChar)) {
                toAppend[i] = true;
            } else if (currentChar == '(' && input.charAt(i - 1) == ')') {
                toAppend[i] = false;
                toAppend[i - 1] = false;
            } else {
                toAppend[i] = true;
            }
        }

        for (int i = 0; i < input.length(); i++) {
            if (toAppend[i]) {
                simplified.append(input.charAt(i));
            }
        }

        return input.length() != simplified.length() ? simplify(simplified) : input.toString();
    }
}