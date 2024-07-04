import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k = 1; k <= t; ++k) {
                String s = in.next();
                int curr_digit = -1;
                int last_digit = -1;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    int digit = Integer.parseInt(s, i, i + 1, 10);
                    curr_digit = digit;
                    if (last_digit == -1) {
                        for (int j = 0; j < digit; j++) {
                            sb.append("(");
                        }
                        sb.append(curr_digit);
                    } else {
                        if (last_digit < curr_digit) {
                            for (int j = 0; j < curr_digit - last_digit; j++) {
                                sb.append("(");
                            }

                        }
                        if (last_digit > curr_digit) {
                            for (int j = 0; j < last_digit - curr_digit; j++) {
                                sb.append(")");
                            }
                        }
                        sb.append(curr_digit);

                    }
                    last_digit = curr_digit;
                }
                for (int j = 0; j < last_digit; j++) {
                    sb.append(")");
                }
                //int m = in.nextInt();
                System.out.println("Case #" + k + ": " + sb.toString());
            }
      }
    }