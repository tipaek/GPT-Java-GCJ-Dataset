import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static int X, Y;
    public static String P;

    public static String solve() {
        int xp = X;
        int yp = Y;
        for (int i = 0; i <= P.length(); i++) {
            int distance = Math.abs(xp) + Math.abs(yp);
            if (i >= distance) {
                return String.valueOf(i);
            }
            if (i < P.length()) {
                char direction = P.charAt(i);
                switch (direction) {
                    case 'E':
                        xp++;
                        break;
                    case 'W':
                        xp--;
                        break;
                    case 'N':
                        yp++;
                        break;
                    case 'S':
                        yp--;
                        break;
                }
            }
        }
        return "IMPOSSIBLE";
    }

    public static final int DEBUG_TEST_CASE = 0;
    public static final boolean SIMULATE_TEST_CASES = false;
    public static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        if (!SIMULATE_TEST_CASES) {
            int tmax = in.nextInt();
            for (int t = 1; t <= tmax; ++t) {
                X = in.nextInt();
                Y = in.nextInt();
                P = in.next();

                if (DEBUG_TEST_CASE <= 0 || t == DEBUG_TEST_CASE) {
                    String result = solve();
                    System.out.println("Case #" + t + ": " + result);
                }
            }
        } else {
            // Simulating test cases
            /*
            int tmax = 10000000;
            for (int t = 1; t <= tmax; ++t) {
                N = "" + (long) Math.ceil(Math.random() * 100000 + 1);

                State res = solve();

                System.out.println("Case #" + t + ": " + N + " " + res.a + " " + res.b);

                assert !res.a.startsWith("0");
                assert !res.b.startsWith("0");
                assert !res.a.contains("4");
                assert !res.b.contains("4");
                assert Long.parseLong(res.a) + Long.parseLong(res.b) == Long.parseLong(N);
            }
            */
        }
    }
}