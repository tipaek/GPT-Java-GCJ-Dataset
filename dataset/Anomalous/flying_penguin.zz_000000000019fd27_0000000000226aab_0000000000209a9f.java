import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            String input = scanner.next();
            String transformedString = transformString(input);
            String result = balanceParentheses(transformedString);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String transformString(String input) {
        for (int i = 0; i < 10; i++) {
            String replacement = String.valueOf(i);
            for (int j = 0; j < i; j++) {
                replacement = "(" + replacement + ")";
            }
            input = input.replaceAll(Integer.toString(i), replacement);
        }
        return input;
    }

    private static String balanceParentheses(String input) {
        String result = "";
        int leftParentheses = 0;
        int rightParentheses = 0;
        StringBuilder builder = new StringBuilder();
        
        int startIndex = findFirstNonParenthesisIndex(input);
        int endIndex = findLastNonParenthesisIndex(input);

        for (int i = startIndex; i <= endIndex; i++) {
            char currentChar = input.charAt(i);
            if (currentChar == ')') {
                rightParentheses++;
            } else if (currentChar == '(') {
                leftParentheses++;
            } else {
                if (rightParentheses >= leftParentheses) {
                    rightParentheses -= leftParentheses;
                    leftParentheses = 0;
                } else {
                    leftParentheses -= rightParentheses;
                    rightParentheses = 0;
                }
                appendParentheses(builder, leftParentheses, rightParentheses);
                result += builder.toString() + currentChar;
                leftParentheses = 0;
                rightParentheses = 0;
                builder.setLength(0);
            }
        }
        return input.substring(0, startIndex) + result + input.substring(endIndex + 1);
    }

    private static int findFirstNonParenthesisIndex(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != '(') {
                return i;
            }
        }
        return 0;
    }

    private static int findLastNonParenthesisIndex(String input) {
        for (int i = input.length() - 1; i >= 0; i--) {
            if (input.charAt(i) != ')') {
                return i;
            }
        }
        return input.length() - 1;
    }

    private static void appendParentheses(StringBuilder builder, int left, int right) {
        for (int k = 0; k < right; k++) {
            builder.append(")");
        }
        for (int k = 0; k < left; k++) {
            builder.append("(");
        }
    }
}