import java.util.*;
import java.io.*;
public class Solution {

    public static String print(String s) {
        StringBuilder p = new StringBuilder();

        int open = 0;

        for (int i = 0; i < s.length(); i++) {
            int temp = Character.getNumericValue(s.charAt(i));
            while (open > temp) {
                p.append(")");
                open--;
            }
            while (temp > open) {
                p.append("(");
                open++;
            }
            p.append(s.charAt(i));
        }
        while (open > 0) {
            p.append(")");
            open--;
        }
        return p.toString();
    }




    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            String p = print(s);
            System.out.println("Case #" + i + ": " + p);
        }
    }
}
  