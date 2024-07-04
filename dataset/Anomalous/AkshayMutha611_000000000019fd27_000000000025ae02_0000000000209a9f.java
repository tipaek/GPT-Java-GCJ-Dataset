import java.util.Scanner;

public class Solution {
    private int t;
    private String inputString, outputString;
    private final char openingBracket = '(';
    private final char closingBracket = ')';

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.takeInputAndSolve();
    }

    private void takeInputAndSolve() {
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();

        for (int testCase = 0; testCase < t; testCase++) {
            inputString = scanner.next();
            outputString = generateOutputString(inputString);
            System.out.println("Case #" + (testCase + 1) + ": " + outputString);
        }
    }

    private String generateOutputString(String input) {
        StringBuilder output = new StringBuilder();
        int length = input.length();

        if (length == 1) {
            int num = Character.getNumericValue(input.charAt(0));
            appendBrackets(output, num, openingBracket);
            output.append(num);
            appendBrackets(output, num, closingBracket);
        } else {
            for (int i = 0; i < length; i++) {
                int num = Character.getNumericValue(input.charAt(i));
                if (i == 0) {
                    handleFirstCharacter(output, num, input.charAt(i + 1));
                } else if (i == length - 1) {
                    output.append(num);
                    appendBrackets(output, num, closingBracket);
                } else {
                    handleMiddleCharacter(output, num, input.charAt(i + 1));
                }
            }
        }
        return output.toString();
    }

    private void handleFirstCharacter(StringBuilder output, int num, char nextChar) {
        int nextNum = Character.getNumericValue(nextChar);
        appendBrackets(output, num, openingBracket);
        output.append(num);
        appendBrackets(output, Math.abs(num - nextNum), num < nextNum ? openingBracket : closingBracket);
    }

    private void handleMiddleCharacter(StringBuilder output, int num, char nextChar) {
        int nextNum = Character.getNumericValue(nextChar);
        output.append(num);
        appendBrackets(output, Math.abs(num - nextNum), num < nextNum ? openingBracket : closingBracket);
    }

    private void appendBrackets(StringBuilder output, int count, char bracketType) {
        for (int i = 0; i < count; i++) {
            output.append(bracketType);
        }
    }
}