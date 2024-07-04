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
        Expogo solver = new Expogo();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Expogo {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            long x = in.nextLong();
            long y = in.nextLong();
            long nextPow2 = (Math.abs(x) + Math.abs(y));
            long p2 = 0;
            long cnt = 1;
            while (cnt < nextPow2) {
                p2++;
                cnt *= 2;
            }
            //out.println(p2);
            StringBuilder sb = new StringBuilder();
            while (p2 > 0) {
                long cur = 1L << (p2 - 1);
                if (Math.abs(x) > Math.abs(y)) {
                    if (x > 0) {
                        x -= cur;
                        sb.append("E");
                    } else {
                        x += cur;
                        sb.append("W");
                    }
                } else {
                    if (y > 0) {
                        y -= cur;
                        sb.append("N");
                    } else {
                        y += cur;
                        sb.append("S");
                    }
                }
                p2--;
            }
            if (x == 0 && y == 0 && p2 == 0) {
                out.println("Case #" + testNumber + ": " + sb.reverse().toString());
            } else {
                out.println("Case #" + testNumber + ": IMPOSSIBLE");
            }

        }

    }
}

