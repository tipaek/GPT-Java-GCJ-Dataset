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
        NestingDepth solver = new NestingDepth();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class NestingDepth {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String s = in.next();
            int[] v = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                v[i] = (int) s.charAt(i) - (int) '0';
            }
            StringBuilder r = new StringBuilder();
            int c = 0;
            for (int i = 0; i < v.length; i++) {
                while (c < v[i]) {
                    r.append('(');
                    c++;
                }
                while (c > v[i]) {
                    r.append(')');
                    c--;
                }
                r.append(v[i]);
            }
            while (c > 0) {
                r.append(')');
                c--;
            }
            out.println("Case #" + testNumber + ": " + r);
        }

    }
}

