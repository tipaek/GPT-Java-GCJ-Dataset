import java.util.*;
import java.io.*;

public class Solution {

    private static String compute(String s) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (int i = 0; i < s.length(); i++) {
            int n = Integer.parseInt( String.valueOf(s.charAt(i)) );
            if (n > level) {
                while (level != n) {
                    sb.append("(");
                    level++;
                }
            } if (n < level) {
                while (level != n) {
                    sb.append(")");
                    level--;
                }
            }
            sb.append(n);
            level = n;
        }
        while (level > 0) {
            sb.append(")");
            level--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();

            System.out.println("Case #" + i + ": " + compute(s));
        }
    }

}
