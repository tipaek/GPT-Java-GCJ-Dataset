import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String str = in.next();

            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < str.length(); k++) {

                if (str.charAt(k) == '0') {
                    sb.append('0');
                    continue;
                }

                if (str.charAt(k) == '1' && k == 0) {
                    sb.append('(');
                    sb.append('1');
                    if ( k == str.length()-1) {
                        sb.append(')');
                    } else if (str.charAt(k+1) == '0') {
                        sb.append(')');
                    }
                } else if ((str.charAt(k) == '1') && (k == str.length() - 1)) {
                    if (str.charAt(k-1) == '0') {
                        sb.append('(');
                    }
                    sb.append('1');
                    sb.append(')');
                } else if (str.charAt(k) == '1' && str.charAt(k-1) == '0') {
                    sb.append('(');
                    sb.append('1');
                    if (str.charAt(k) == '1' && str.charAt(k+1) == '0') {
                        sb.append(')');
                    }
                } else {
                    sb.append('1');
                    if (str.charAt(k+1) == '0') {
                        sb.append(')');
                    }
                }
            }

            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }
}
