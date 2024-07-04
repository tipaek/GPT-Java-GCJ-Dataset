import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static String result;
    private static int minimumLength;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            String output = nest(input);
            System.out.println("Case #" + i + ": " + output);
        }
        scanner.close();
    }

    private static String nest(String input) {
        result = "";
        minimumLength = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        generateNesting(sb, input, 0, 0);
        return result;
    }

    private static void generateNesting(StringBuilder current, String input, int index, int openBrackets) {
        if (index >= input.length() && openBrackets == 0) {
            if (result.isEmpty() || current.length() < result.length()) {
                result = current.toString();
                minimumLength = current.length();
            }
            return;
        }

        if (openBrackets < 0 || current.length() >= minimumLength) {
            return;
        }

        if (index < input.length()) {
            int nextDigit = Character.getNumericValue(input.charAt(index));
            if (openBrackets == nextDigit) {
                current.append(nextDigit);
                generateNesting(current, input, index + 1, openBrackets);
                current.deleteCharAt(current.length() - 1);
            }
        }

        if (index < input.length()) {
            int digit = Character.getNumericValue(input.charAt(index));
            if (openBrackets < digit) {
                current.append("(");
                generateNesting(current, input, index, openBrackets + 1);
                current.deleteCharAt(current.length() - 1);
            }
        }

        if (openBrackets > 0 && current.charAt(current.length() - 1) != '(') {
            current.append(")");
            generateNesting(current, input, index, openBrackets - 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}