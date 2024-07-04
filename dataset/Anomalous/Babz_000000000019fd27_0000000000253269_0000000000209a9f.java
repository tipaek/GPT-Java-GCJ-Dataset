import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.next();
            System.out.println(input);
            String output = formatOutput(convertToIntArray(input));
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

    private static String formatOutput(int[] input) {
        StringBuilder output = new StringBuilder();
        
        for (int i = 0; i < input.length; i++) {
            if (i == 0) {
                appendParentheses(output, input[i]);
            } else {
                int difference = input[i] - input[i - 1];
                if (difference > 0) {
                    appendParentheses(output, difference);
                } else if (difference < 0) {
                    closeParentheses(output, -difference);
                }
            }
            output.append(input[i]);
        }
        
        closeParentheses(output, input[input.length - 1]);
        return output.toString();
    }

    private static void appendParentheses(StringBuilder output, int count) {
        for (int j = 0; j < count; j++) {
            output.append('(');
        }
    }

    private static void closeParentheses(StringBuilder output, int count) {
        for (int j = 0; j < count; j++) {
            output.append(')');
        }
    }
}