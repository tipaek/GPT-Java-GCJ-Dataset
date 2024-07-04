import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out)) {
            Expogo solver = new Expogo();
            int testCount = Integer.parseInt(in.next());
            for (int i = 1; i <= testCount; i++) {
                solver.solve(i, in, out);
            }
        }
    }

    static class Expogo {
        private static final int[] DX = {-1, 0, 1, 0};
        private static final int[] DY = {0, 1, 0, -1};
        private static final char[] DIRECTIONS = {'E', 'S', 'W', 'N'};

        private boolean isGood(long x, long y) {
            return Math.abs(x % 2) != Math.abs(y % 2);
        }

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            long x = in.nextInt();
            long y = in.nextInt();

            StringBuilder ans = new StringBuilder();
            while (x != 0 || y != 0) {
                boolean moveFound = false;
                for (int d = 0; d < 4; d++) {
                    long nx = x + DX[d];
                    long ny = y + DY[d];
                    if (nx == 0 && ny == 0) {
                        moveFound = true;
                        ans.append(DIRECTIONS[d]);
                        x = nx / 2;
                        y = ny / 2;
                        break;
                    }
                }
                if (!moveFound) {
                    for (int d = 0; d < 4; d++) {
                        long nx = x + DX[d];
                        long ny = y + DY[d];
                        if (nx % 2 != 0 || ny % 2 != 0) {
                            continue;
                        }
                        if (!isGood(nx / 2, ny / 2)) {
                            continue;
                        }
                        moveFound = true;
                        ans.append(DIRECTIONS[d]);
                        x = nx / 2;
                        y = ny / 2;
                        break;
                    }
                }
                if (!moveFound) {
                    out.println("Case #" + testNumber + ": IMPOSSIBLE");
                    return;
                }
            }
            out.println("Case #" + testNumber + ": " + ans);
        }
    }
}