import java.util.Scanner;

public class Solution {

    private static int maxPow(long v) {
        int res = 0;
        while (v != 0) {
            v >>= 1;
            ++res;
        }
        return res;
    }

    private static boolean trySolve(long x, long y, char[] str, int bit) {
        if (bit == -1) {
            return x == 0 && y == 0;
        }

        long absX = Math.abs(x);
        long absY = Math.abs(y);
        if ((absX & (1 << bit)) != 0 && (absY & (1 << bit)) == 0) {
            if (x > 0) {
                str[bit] = 'E';
                return trySolve(x - (1 << bit), y, str, bit - 1);
            } else {
                str[bit] = 'W';
                return trySolve(x + (1 << bit), y, str, bit - 1);
            }
        } else {
            if (y > 0) {
                str[bit] = 'N';
                return trySolve(x, y - (1 << bit), str, bit - 1);
            } else {
                str[bit] = 'S';
                return trySolve(x, y + (1 << bit), str, bit - 1);
            }
        }
    }

    static String solve(long x, long y) {
        int maxXpow = maxPow(Math.abs(x));
        int maxYPow = maxPow(Math.abs(y));
        char[] solution = new char[Math.max(maxXpow, maxYPow) + 1];
        if (trySolve(x, y, solution, Math.max(maxXpow, maxYPow))) {
            return new String(solution);
        } else if (trySolve(x, y, solution, Math.max(maxXpow, maxYPow) - 1)) {
            return new String(solution);
        } else  return null;
    }

    public static void main(String[] params) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < t; ++i) {
            String[] in = scanner.nextLine().split(" ");
            long x = Long.valueOf(in[0]);
            long y = Long.valueOf(in[1]);
            String solution = solve(x, y);
            System.out.println(String.format("Case #%d: %s", i + 1, solution == null ? "IMPOSSIBLE" : solution));
        }
    }
}
