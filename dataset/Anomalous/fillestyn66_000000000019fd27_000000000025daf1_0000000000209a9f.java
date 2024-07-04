import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";
    private static int position = 0;
    private static int depth = 0;

    private static void addParentheses(StringBuilder result, String bracket, int count, int pos) {
        for (int i = 0; i < count; i++) {
            result.insert(pos, bracket);
        }
    }

    private static void process(StringBuilder result, int value) {
        if (depth == value) {
            result.insert(position, value);
            position++;
        } else if (depth < value) {
            int offset = value - depth;
            addParentheses(result, LEFT_PARENTHESIS, offset, position);
            position += offset;
            result.insert(position, value);
            position++;
            addParentheses(result, RIGHT_PARENTHESIS, offset, position);
            depth = value;
        } else {
            int offset = position + depth - value;
            result.insert(offset, value);
            position = offset + 1;
            depth = value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 1; i <= testCases; i++) {
            String inputLine = scanner.nextLine();
            StringBuilder result = new StringBuilder(500);
            depth = 0;
            position = 0;
            inputLine.chars().forEach(c -> process(result, Character.getNumericValue(c)));
            System.out.println("Case #" + i + ": " + result.toString());
        }
        
        scanner.close();
    }
}