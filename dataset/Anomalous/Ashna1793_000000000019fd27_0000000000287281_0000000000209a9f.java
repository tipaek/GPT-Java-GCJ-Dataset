import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static String result = "";

    private static String nest(String input) {
        result = "";
        generateNesting("", input, 0, 0);
        return result;
    }

    private static void generateNesting(String current, String input, int index, int openBrackets) {
        if (index >= input.length() && openBrackets == 0) {
            if (result.isEmpty() || current.length() < result.length()) {
                result = current;
            }
            return;
        }

        if (openBrackets < 0) return;

        int digit = 0;
        if (index < input.length()) {
            digit = Character.getNumericValue(input.charAt(index));
        }

        if (openBrackets < digit && index < input.length()) {
            generateNesting(current + "(", input, index, openBrackets + 1);
        }

        if (openBrackets > 0 && current.charAt(current.length() - 1) != '(') {
            generateNesting(current + ")", input, index, openBrackets - 1);
        }

        if (index < input.length()) {
            int nextDigit = Character.getNumericValue(input.charAt(index));
            if (openBrackets == nextDigit) {
                generateNesting(current + nextDigit, input, index + 1, openBrackets);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            String result = nest(input);
            System.out.println("Case #" + i + ": " + result);
        }
        scanner.close();
    }
}