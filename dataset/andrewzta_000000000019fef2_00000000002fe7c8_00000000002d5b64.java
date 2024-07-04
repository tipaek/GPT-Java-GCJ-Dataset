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
        JoinTheRanks solver = new JoinTheRanks();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class JoinTheRanks {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int r = in.nextInt();
            int s = in.nextInt();

            out.println("Case #" + testNumber + ": " + (s - 1) * (r - 1));
            for (int i = 0; i < r - 1; i++) {
                for (int j = 1; j < s; j++) {
                    out.println(((r - i) * (s - 1) - j + 1) + " " + (r - i - 1));
                }
            }
        }

    }
}

