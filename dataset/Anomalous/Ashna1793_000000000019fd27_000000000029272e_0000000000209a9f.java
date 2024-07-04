import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {

    private static String result = "";
    private static int minLength;

    private static String nest(String input) {
        result = "";
        minLength = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder(input.length() * 2);
        generateNesting(sb, input, 0, 0);
        return result;
    }

    private static void generateNesting(StringBuilder current, String input, int index, int openBrackets) {
        if (index >= input.length() && openBrackets == 0) {
            if (result.isEmpty() || current.length() < result.length()) {
                result = current.toString();
                minLength = current.length();
            }
            return;
        }

        if (openBrackets < 0 || current.length() >= minLength) {
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
                current.append('(');
                generateNesting(current, input, index, openBrackets + 1);
                current.deleteCharAt(current.length() - 1);
            }
        }

        if (openBrackets > 0 && current.charAt(current.length() - 1) != '(') {
            current.append(')');
            generateNesting(current, input, index, openBrackets - 1);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide the input file as an argument.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            int testCases = Integer.parseInt(br.readLine());
            for (int i = 1; i <= testCases; i++) {
                String input = br.readLine();
                String result = nest(input);
                System.out.println("Case #" + i + ": " + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}