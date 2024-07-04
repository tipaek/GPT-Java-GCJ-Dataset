import java.io.*;
import java.util.*;

public class Solution {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final PrintWriter OUT = new PrintWriter(System.out);
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final long MOD = 1000000000L;
    private static final double LN2 = Math.log(2);
    private double[] logFac;

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int testCases = SCANNER.nextInt();
        for (int i = 1; i <= testCases; i++) {
            OUT.printf("Case #%d: %s%n", i, solution.solve());
        }
        OUT.flush();
        System.exit(0);
    }

    private String solve() {
        int x = SCANNER.nextInt();
        int y = SCANNER.nextInt();
        char[] directions = SCANNER.next().toCharArray();
        int steps = directions.length;

        if (x == 0 && y == 0) {
            return "0";
        }

        for (int i = 1; i <= steps; i++) {
            char direction = directions[i - 1];
            switch (direction) {
                case 'E': x++; break;
                case 'S': y--; break;
                case 'W': x--; break;
                case 'N': y++; break;
            }
            if (Math.abs(x) + Math.abs(y) <= i) {
                return Integer.toString(i);
            }
        }

        return "IMPOSSIBLE";
    }
}