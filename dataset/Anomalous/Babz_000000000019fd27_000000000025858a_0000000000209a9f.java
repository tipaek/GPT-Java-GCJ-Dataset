import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.next();
            String output = formatOutput(convertToIntArray(input));
            System.out.println("Case #" + i + ": " + output);
        }
    }

    public static int[] convertToIntArray(String number) {
        int[] result = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            result[i] = Character.getNumericValue(number.charAt(i));
        }
        return result;
    }

    public static String formatOutput(int[] input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            if (i == 0 || input[i] < input[i - 1]) {
                appendParentheses(output, input[i]);
                output.append(input[i]);
                appendParentheses(output, -input[i]);
            } else if (input[i] > input[i - 1]) {
                int diff = input[i] - input[i - 1];
                appendParentheses(output, diff);
                output.append(input[i]);
            } else {
                output.append(input[i]);
            }
        }
        return removeAdjacentParentheses(output.toString());
    }

    public static void appendParentheses(StringBuilder output, int count) {
        for (int j = 0; j < Math.abs(count); j++) {
            output.append(count > 0 ? "(" : ")");
        }
    }

    public static String removeAdjacentParentheses(String input) {
        return input.replace(")(", "");
    }
}