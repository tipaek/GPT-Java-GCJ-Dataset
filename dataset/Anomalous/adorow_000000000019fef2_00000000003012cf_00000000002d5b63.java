import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    private static Scanner in;
    private static PrintStream out;

    private static final String CASE_N = "Case #";
    private static final String COLON_SPACE = ": ";
    private static final int MAX = 1_000_000_000;
    private static final int attemptLimit = 300;
    private static final int[][] potential_centers = {
        {0, 0},
        {-500_000_000, -500_000_000},
        {-500_000_000, 500_000_000},
        {500_000_000, -500_000_000},
        {500_000_000, 500_000_000}
    };

    private static int attempt;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        out = System.out;

        int T = in.nextInt();
        int A = in.nextInt();
        int B = in.nextInt();

        for (int t = 1; t <= T; t++) {
            solve(A, B);
        }
        out.flush();
    }

    private static void solve(int minR, int maxR) {
        int diff = MAX - minR + 1;
        attempt = 0;

        for (int x = -diff; x <= diff; x++) {
            for (int y = -diff; y <= diff; y++) {
                String result = exchange(x, y);
                if (isCenter(result)) return;
            }
        }
        System.exit(3);
    }

    private static String exchange(int x, int y) {
        write(x, y);
        return read();
    }

    private static boolean isCenter(String str) {
        return "CENTER".equals(str);
    }

    private static boolean isHit(String str) {
        return "HIT".equals(str);
    }

    private static boolean isMiss(String str) {
        return "MISS".equals(str);
    }

    private static String read() {
        String answer = in.next();
        if ("WRONG".equals(answer)) {
            System.exit(1);
        }
        return answer;
    }

    private static void write(int x, int y) {
        if (attempt >= attemptLimit) {
            System.exit(2);
        }
        out.printf("%d %d%n", x, y);
        attempt++;
    }
}