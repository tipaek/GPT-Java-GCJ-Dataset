import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String input = in.next();
            int[] digits = createArray(input);

            int prev = 0;
            StringBuffer output = new StringBuffer();
            for (int digit : digits) {
                if (digit > prev) {
                    output.append(String.join("", Collections.nCopies(digit - prev, "(")));
                }
                if (digit < prev) {
                    output.append(String.join("", Collections.nCopies(prev - digit, ")")));
                }
                output.append(digit);
                prev = digit;
            }

            // append closing parentheses if necessary
            if (digits[digits.length-1] >0 ){
                output.append(String.join("", Collections.nCopies(digits[digits.length-1], ")")));
            }
            System.out.println("Case #" + i + ": " + output);
        }
    }

    static int[] createArray(String s) {
        int[] result = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = s.charAt(i) - 0x30;
        }
        return result;
    }
}