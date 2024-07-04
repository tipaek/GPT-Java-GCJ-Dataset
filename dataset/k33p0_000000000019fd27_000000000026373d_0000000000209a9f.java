import java.util.*;
import java.io.*;
public class Solution {
    public static String formString(String s) {
        String x = "";
        StringBuilder output = new StringBuilder();
        // form first number
        x += s.charAt(0);
        int value = Integer.parseInt(x);
        for (int a = 0; a < value; a++) {
            output.append("(");
        }
        output.append(value);
        int prev = value;

        // for the remaining of the string
        for (int i = 1; i < s.length(); i++) {
            x = ""; //reset
            x += s.charAt(i);
            value = Integer.parseInt(x);
            if (value > prev) {
                for (int j = 0; j < value - prev; j++) {
                     output.append("(");
                }
            } else {
                for (int k = 0; k < prev - value; k++) {
                    output.append(")");
                }
            }
            output.append(value);
            prev = value;
        }

        // at the end output )
        for (int i = 0; i < prev; i++) {
            output.append(")");
        }
        return output.toString();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            System.out.println("Case #" + i + ": " + formString(s));
        }
    }
}
