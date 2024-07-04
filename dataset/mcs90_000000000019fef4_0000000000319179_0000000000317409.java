import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        OverexcitedFan solver = new OverexcitedFan();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class OverexcitedFan {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int X = in.nextInt();
            int Y = in.nextInt();
            String tour = in.next();

            int res = 50000;
            for (int i = 0; i <= tour.length(); i++) {
                if (Math.abs(X) + Math.abs(Y) <= i) {
                    res = i;
                    break;
                }
                if (i == tour.length()) {
                    break;
                }
                if (tour.charAt(i) == 'N') {
                    ++Y;
                } else if (tour.charAt(i) == 'S') {
                    --Y;
                } else if (tour.charAt(i) == 'E') {
                    ++X;
                } else if (tour.charAt(i) == 'W') {
                    --X;
                }
            }

            out.println(String.format("Case #%d: %s", testNumber, res == 50000 ? "IMPOSSIBLE" : res));
        }

    }
}

