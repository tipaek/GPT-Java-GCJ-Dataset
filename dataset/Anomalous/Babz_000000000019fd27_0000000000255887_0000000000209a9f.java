import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.next();
            int[] intArray = convertToIntArray(input);
            String output = generateOutput(intArray);
            System.out.println("Case #" + i + ": " + output);
        }
    }

    private static int[] convertToIntArray(String number) {
        int[] result = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            result[i] = Character.getNumericValue(number.charAt(i));
        }
        return result;
    }

    private static String generateOutput(int[] input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            if (i == 0 || input[i] < input[i - 1]) {
                appendParentheses(output, input[i], true);
                output.append(input[i]);
                appendParentheses(output, input[i], false);
            } else if (input[i] > input[i - 1]) {
                int difference = input[i] - input[i - 1];
                StringBuilder temp = new StringBuilder();
                appendParentheses(temp, difference, true);
                temp.append(input[i]);
                appendParentheses(temp, difference, false);
                output.insert(output.lastIndexOf(String.valueOf(input[i - 1])) + 1, temp);
            } else {
                output.insert(output.length() - input[i], input[i]);
            }
        }
        return output.toString().replace(")(", "");
    }

    private static void appendParentheses(StringBuilder builder, int count, boolean isOpening) {
        char parenthesis = isOpening ? '(' : ')';
        for (int j = 0; j < count; j++) {
            builder.append(parenthesis);
        }
    }
}