import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(
                new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String digits = in.next();
            StringBuilder result = new StringBuilder();
            for(int j = 0; j < digits.length(); j++) {
                int digit = digits.charAt(j) - '0';
                for(int k = 0; k < digit; k++) {
                    result.append('(');
                }
                result.append(digit);
                for(int k = 0; k < digit; k++) {
                    result.append(')');
                }
            }
            int j = 0;
            while(j < result.length()) {
                if(result.charAt(j) == ')' && result.charAt(j + 1) == '(') {
                    result.deleteCharAt(j);
                    result.deleteCharAt(j);
                    j -= 2;
                }
                j++;
            }
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}
