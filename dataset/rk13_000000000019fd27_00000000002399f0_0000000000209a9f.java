import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(
                in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();


            int cd = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <= s.length(); j++) {
                boolean end = j == s.length();
                int digit = end ? 0 : s.charAt(j) - '0';
                while (cd < digit) {
                    sb.append('(');
                    cd++;
                }
                while (cd > digit) {
                    sb.append(')');
                    cd--;
                }

                if (!end) {
                    sb.append(digit);
                }
            }

            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }
}
