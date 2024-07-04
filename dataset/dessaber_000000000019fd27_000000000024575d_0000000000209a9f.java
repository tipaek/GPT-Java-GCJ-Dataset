import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k= 1; k <= t; ++k) {
            StringBuilder b = new StringBuilder();
            String str = in.nextLine();
            int prev = Character.getNumericValue(str.charAt(0));
            for (int m = 1; m <= prev; m++) {
                b.append('(');
            }
            b.append(prev);
            for (int i = 1; i < str.length(); i++) {
                int ww = Character.getNumericValue(str.charAt(i));
                if (ww < prev) {
                    int diff = prev - ww;
                    for (int j = 1; j <= diff; j++) {
                        b.append(')');
                    }
                } else if (ww > prev) {
                    int diff = ww - prev;
                    for (int j = 1; j <= diff; j++) {
                        b.append('(');
                    }
                }
                b.append(ww);
                prev = ww;
            }
            for (int j = 1; j <= prev; j++) {
                b.append(')');
            }
            System.out.println("Case #" + k + ": " + b);
        }
    }
}