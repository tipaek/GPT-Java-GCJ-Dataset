import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static long[] powers = new long[50];

    public static void main(String[] args) throws IOException {
        powers[0] = 1;
        for (int i = 1; i < powers.length; i++) {
            powers[i] = (long) Math.pow(2, i);
        }

        BufferedReader in = inputReader();
        int kases = toInt(in.readLine());

        for (int kase = 1; kase<= kases; kase++) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            long x = toLong(tokenizer.nextToken());
            long y = toLong(tokenizer.nextToken());

            long sum = Math.abs(x) + Math.abs(y);

            if (isPower(sum)) {
                System.out.println("Case #" + kase + ": IMPOSSIBLE");
                break;
            }

            int maxPossibleMoves = nextPower(sum);
            String solution = "";
            dfs(solution, 0, 0, x, y, maxPossibleMoves, 0, kase);
        }
    }

    private static void dfs(String string, long cX, long cY, long x, long y, int remainingMoves, int i, int kase) {
        if (remainingMoves < 0) {
            return;
        }

        if (x == cX && y == cY) {
            System.out.println("Case #" + kase + ": " + string);
        }

        if (y != 0) {
            // south, north
            dfs(string + "S", cX, cY - powers[i], x, y, remainingMoves - 1, i + 1, kase);
            dfs(string + "N", cX, cY + powers[i], x, y, remainingMoves - 1, i + 1, kase);
        }

        if (x != 0) {
            // east, west
            dfs(string + "E", cX + powers[i], cY, x, y, remainingMoves - 1, i + 1, kase);
            dfs(string + "W", cX - powers[i], cY, x, y, remainingMoves - 1, i + 1, kase);
        }
    }

    private static int toInt(final String str) {
        return Integer.parseInt(str);
    }

    private static long toLong(final String str) {
        return Long.parseLong(str);
    }

    private static BufferedReader inputReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    private static boolean isPower(long n) {
        return (n & (n - 1)) == 0;
    }

    private static int nextPower(long n) {
        return n == 0 ? 0 : 64 - Long.numberOfLeadingZeros(n - 1);
    }
}