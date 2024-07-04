
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    static String solve(int X, int Y, String M) {
        for (char c : M.toCharArray()) {
            switch (c) {
                case 'S':
                    Y--;
                    break;
                case 'N':
                    Y++;
                    break;
                case 'E':
                    X++;
                    break;
                case 'W':
                    X--;
                    break;
            }
        }

        int walksMax = Math.abs(X) + Math.abs(Y);

        if (walksMax > M.length()) {
            return "IMPOSSIBLE";
        } else {
            return M.length() + "";
        }
    }

    public static void main(String[] args) {
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            int X = in.nextInt();
            int Y = in.nextInt();
            String M = in.next();

            String flag = "";
            flag = solve(X, Y, M);

            String res = "Case #" + t + ": " + flag;
            System.out.println(res);
        }
    }
}
