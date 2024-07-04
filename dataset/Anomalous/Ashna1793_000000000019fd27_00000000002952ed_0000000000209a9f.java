import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    private static String result = "";
    private static int minimumLength;

    private static String nest(String input) {
        result = "";
        minimumLength = Integer.MAX_VALUE;
        StringBuilder stringBuilder = new StringBuilder(input.length() * 2);
        generateNesting(stringBuilder, input, 0, 0);
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

        if (openBrackets < 0 || current.length() >= minimumLength) return;

        if (index < input.length()) {
            int nextDigit = Character.getNumericValue(input.charAt(index));
            if (openBrackets == nextDigit) {
                current.append(nextDigit);
                generateNesting(current, input, index + 1, openBrackets);
                current.deleteCharAt(current.length() - 1);
            }
        }

        int digit = 0;
        if (index < input.length()) {
            digit = Character.getNumericValue(input.charAt(index));
        }

        if (openBrackets < digit && index < input.length()) {
            current.append("(");
            generateNesting(current, input, index, openBrackets + 1);
            current.deleteCharAt(current.length() - 1);
        }

        if (openBrackets > 0 && current.charAt(current.length() - 1) != '(') {
            current.append(")");
            generateNesting(current, input, index, openBrackets - 1);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(bufferedReader.readLine());
            for (int i = 1; i <= testCases; i++) {
                String input = bufferedReader.readLine();
                String nestedString = nest(input);
                System.out.println("Case #" + i + ": " + nestedString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}