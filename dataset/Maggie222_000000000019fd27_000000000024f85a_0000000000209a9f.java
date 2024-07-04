import static java.lang.System.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // Scanner has functions to read ints, longs, strings, chars, etc.
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(in)));
        int caseNum = Integer.valueOf(input.nextLine());
        for(int i = 1; i <= caseNum; i ++) {
            String digits = input.nextLine();

            String result = solve(digits);
            out.println("Case #" + i + ": " + result);
        }
    }

    private static String solve(String digits) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < digits.length(); i ++) {
            int diff = digits.charAt(i) -  (i == 0 ? '0' : digits.charAt(i - 1));
            if(diff < 0) {
                while(diff != 0) {
                    result.append(')');
                    diff ++;
                }

            } else if(diff > 0) {
                while(diff != 0) {
                    result.append('(');
                    diff --;
                }
            }
            result.append(digits.charAt(i));
        }

        int right = digits.charAt(digits.length() - 1) - '0';
        while(right > 0) {
            result.append(')');
            right --;
        }
        return result.toString();
    }
}
