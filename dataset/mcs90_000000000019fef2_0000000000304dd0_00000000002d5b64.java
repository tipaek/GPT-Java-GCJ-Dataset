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
            int R = in.nextInt();
            int S = in.nextInt();
            int n = (R - 1) * (S - 1);
            int[][] res = new int[n][2];
            int a = R * (S - 1);
            for (int i = 1; i <= n; ++i) {
                res[i - 1][0] = a--;
                res[i - 1][1] = R - 1;
                if (i % (S - 1) == 0) {
                    R--;
                }
            }
            out.println(String.format("Case #%d: %d", testNumber, n));
            for (int[] r : res) {
                out.println(r[0] + " " + r[1]);
            }
        }

    }
}

