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
            int x = in.nextInt();
            int y = in.nextInt();
            String s = in.next();
            int t = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < s.length(); i++) {
                if (Math.abs(x) + Math.abs(y) <= t) {
                    min = Math.min(min, t);
                }
                t++;
                switch (s.charAt(i)) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
            }
            if (Math.abs(x) + Math.abs(y) <= t) {
                min = Math.min(min, t);
            }
            out.printf("Case #%d: " + (min == Integer.MAX_VALUE ? "IMPOSSIBLE" : String.valueOf(min)) + "\n", testNumber);
        }

    }
}

