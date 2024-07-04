import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            String S = in.next();

            String Sx = "(";

            char last = S.charAt(0);
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                if (last != c) {
                    Sx += ")" + "(" + c;
                }
                Sx += c;
                last = c;
            }
            Sx += ")";

            Sx = Sx.replaceAll("\\(0", "0").replaceAll("0\\)", "0");

            String res = "Case #" + t + ": " + Sx;
            System.out.println(res);
        }
    }
}