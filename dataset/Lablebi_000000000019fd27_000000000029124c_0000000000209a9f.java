import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            StringBuilder newString = new StringBuilder();
            char[] digits = s.toCharArray();
            int parenthesesToClose = 0;
            int actualDigit = 0;
            for (int j = 0; j < digits.length; j++) {
                char digit = digits[j];
                int value = Character.getNumericValue(digit);
                if (value > actualDigit) {
                    int open = value - actualDigit;
                    for (int count = 0; count < open; count++) {
                        newString.append("(");
                    }
                    parenthesesToClose += open;
                } else if (value < actualDigit) {
                    int close = actualDigit - value;
                    for (int count = 0; count < close; count++) {
                        newString.append(")");
                    }
                    parenthesesToClose -= close;
                }
                newString.append(digit);
                actualDigit = value;
            }
            for (int count = 0; count < parenthesesToClose; count++) {
                newString.append(")");
            }
            System.out.println("Case #" + i + ": " + newString.toString());
        }
    }
}