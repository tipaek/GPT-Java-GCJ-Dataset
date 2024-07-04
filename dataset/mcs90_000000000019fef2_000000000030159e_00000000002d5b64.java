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
            int x = in.nextInt();
            int y = in.nextInt();
            out.println(String.format("Case #%d: %d", testNumber, (x - 1) * (y - 1)));
        }

    }
}

