import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Set;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Vestigium solver = new Vestigium();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class Vestigium {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int a[][] = new int[n][n];
            int out1 = 0;
            for (int i = 0; i < n; i++) {
                for (int h = 0; h < n; h++) {
                    a[i][h] = in.nextInt();
                    if (i == h) {
                        out1 += a[i][h];
                    }
                }
            }
            int outRow = 0;
            int outCol = 0;
            for (int i = 0; i < n; i++) {
                boolean repRow = false;
                boolean repCol = false;
                Set<Integer> sRow = new HashSet<>();
                Set<Integer> sCol = new HashSet<>();
                for (int h = 0; h < n; h++) {
                    if (sRow.contains(a[i][h])) {
                        repRow = true;
                    }
                    if (sCol.contains(a[h][i])) {
                        repCol = true;
                    }
                    sRow.add(a[i][h]);
                    sCol.add(a[h][i]);
                }
                outRow += repRow ? 1 : 0;
                outCol += repCol ? 1 : 0;
            }
            out.println(String.format("Case #%d: %d %d %d", testNumber, out1, outRow, outCol));
        }
    }

    static class InputReader {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

