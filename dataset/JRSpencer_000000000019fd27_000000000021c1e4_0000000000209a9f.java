import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String S = in.next();
            String output = "";
            boolean prevOne = false;
            for (int j = 0; j < S.length(); j++) {
                if (S.charAt(j) == '1' && !prevOne) {
                    output += "(" + S.charAt(j);
                    prevOne = true;
                } else if (S.charAt(j) == '0' && prevOne) {
                    output += ")" + S.charAt(j);
                    prevOne = false;
                } else {
                    output += S.charAt(j);
                }
                if (j == S.length() - 1 && prevOne) {
                    output += ")";
                }
            }
            System.out.println(String.format("Case #%d: %s", i, output));
        }
    }
}
