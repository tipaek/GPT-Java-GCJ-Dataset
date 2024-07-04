import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nTestCases = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        String inputs[] = new String[nTestCases];
        for (int i = 0; i < nTestCases; i++) {
            inputs[i] = in.nextLine();
        }

        for (int i = 0; i < inputs.length; i++) {
            generateParenthesizedString(i + 1, inputs[i]);
        }
    }

    private static void generateParenthesizedString(int nCase, String input) {
        int nCloseParenthesisRemaining = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int digit = Integer.parseInt(input.charAt(i) + "");

            if (digit > nCloseParenthesisRemaining) {
                int parenToBeOpened =  digit - nCloseParenthesisRemaining;
                nCloseParenthesisRemaining += parenToBeOpened;
                while (parenToBeOpened > 0) {
                    builder.append("(");
                    parenToBeOpened--;
                }
                builder.append(digit);
            } else {
                if (digit < nCloseParenthesisRemaining) {
                    int parenToBeClosed = nCloseParenthesisRemaining - digit;
                    nCloseParenthesisRemaining -= parenToBeClosed;
                    while (parenToBeClosed > 0) {
                        builder.append(")");
                        parenToBeClosed--;
                    }
                    builder.append(digit);
                } else {
                    if ( digit == nCloseParenthesisRemaining) {
                        builder.append(digit);
                    }
                }
            }
        }

        while (nCloseParenthesisRemaining > 0) {
            builder.append(")");
            nCloseParenthesisRemaining--;
        }
        System.out.println("Case #" + nCase + ": " + builder.toString());
    }
}
