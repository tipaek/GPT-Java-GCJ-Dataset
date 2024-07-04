import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private static String appendParent(int last, int current) {
        String ret = "";
        int sub = current - last;
        String sign = "";
        if (sub < 0) {
            sign = ")";
        } else if (sub > 0) {
            sign = "(";
        }

        for (int i = 0; i < Math.abs(sub); i++) {
            ret += sign;
        }
        ret += current + "";

        return ret;
    }

    public static void main(String[] args) {
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            String S = in.next();
            S += "0";
//            System.out.println(S);

            String Sx = "";
            char last = '0';
            for (int i = 0; i < S.length(); i++) {
                Sx += appendParent(last - '0', S.charAt(i) - '0');
                last = S.charAt(i);
//                System.out.println(last);
            }

            String res = "Case #" + t + ": " + Sx.substring(0, Sx.length() - 1);
            System.out.println(res);
        }
    }
}
