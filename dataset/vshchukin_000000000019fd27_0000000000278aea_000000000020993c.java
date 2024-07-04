import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.BitSet;

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
        Vestigium solver = new Vestigium();
        solver.solve(1, in, out);
        out.close();
    }

    static class Vestigium {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int noCases = in.nextInt();
            for (int i = 1; i <= noCases; i++) {
                int n = in.nextInt();
                int[][] matrix = new int[n][n];
                for (int j = 0; j < n; j++) {
                    Arrays.setAll(matrix[j], k -> in.nextInt());
                }
                long sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += matrix[k][k];
                }
                int numDupeCols = 0;
                int numDupeRows = 0;
                for (int k = 0; k < n; k++) {
                    BitSet cols = new BitSet(n);
                    BitSet rows = new BitSet(n);
                    for (int kk = 0; kk < n; kk++) {
                        cols.set(matrix[kk][k]);
                        rows.set(matrix[k][kk]);
                    }
                    if (cols.cardinality() < n) {
                        numDupeCols++;
                    }
                    if (rows.cardinality() < n) {
                        numDupeRows++;
                    }
                }
                out.printf("Case #%d: %d %d %d\n", i, sum, numDupeRows, numDupeCols);

            }
        }

    }
}

