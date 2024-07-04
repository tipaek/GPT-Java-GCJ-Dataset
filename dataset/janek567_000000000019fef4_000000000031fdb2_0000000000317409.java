import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testCase = 1; testCase <= t; ++testCase) {
            solve(in, testCase);
        }
    }

    static void solve(Scanner in, int testCase) {
        int X = in.nextInt();
        int Y = in.nextInt();
        String M = in.next();

        for (int i = 0; i < M.length(); i++) {
            switch (M.charAt(i)) {
                case 'N':
                    Y += 1;
                    break;
                case 'S':
                    Y -= 1;
                    break;
                case 'W':
                    X -= 1;
                    break;
                case 'E':
                    X += 1;
                    break;
            }
            if (Math.abs(X) + Math.abs(Y) <= (i + 1)) {
                ot(testCase, String.valueOf(i + 1));
                return;
            }
        }

        ot(testCase, "IMPOSSIBLE");
    }


    static void ot(int testCase, String s) {
        System.out.println(String.format("Case #%d: %s", testCase, s));
    }
}