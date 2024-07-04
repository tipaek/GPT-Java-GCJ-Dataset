import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";
    private static int position = 0;
    private static int depth = 0;

    private static void addParentheses(StringBuilder result, String bracket, int count) {
        for (int i = 0; i < count; i++) {
            result.append(bracket);
        }
    }

    private static void process(StringBuilder result, int value) {
        if (depth == value) {
            result.insert(position, value);
            position++;
        } else if (depth < value) {
            addParentheses(result, LEFT_PARENTHESIS, value - depth);
            result.append(value);
            position = result.length();
            addParentheses(result, RIGHT_PARENTHESIS, value - depth);
            depth = value;
        } else {
            result.insert(position - (depth - value), value);
            position = position - (depth - value) + 1;
            depth = value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= testCases; i++) {
            String inputLine = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            depth = 0;
            position = 0;
            inputLine.chars().forEach(c -> process(result, Character.getNumericValue(c)));
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}