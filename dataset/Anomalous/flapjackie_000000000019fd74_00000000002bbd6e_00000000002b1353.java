import java.util.*;
import java.io.*;

public class Solution {
    static int row, col;
    static PrintWriter out;
    static long[][] pascalTriangle;

    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner(System.in);
        out = new PrintWriter(System.out);
        pascalTriangle = new long[501][501];
        computePascalTriangle(500, 500);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            long n = scanner.nextInt();
            long sum = 1;
            out.printf("Case #%d:\n", caseNum);
            row = 0;
            col = 0;
            printPosition(row, col);

            row++;
            col++;
            if (n == 2) {
                printPosition(row, col);
                continue;
            }

            while (n >= sum + pascalTriangle[row][col] + 1) {
                sum += pascalTriangle[row][col];
                printPosition(row, col);
                row++;
            }
            row--;
            col--;

            while (n > sum) {
                sum += pascalTriangle[row][col];
                printPosition(row, col);
                row++;
            }
        }
        out.close();
    }

    static void printPosition(int row, int col) {
        out.println((row + 1) + " " + (col + 1));
    }

    static long computePascalTriangle(int n, int k) {
        for (int i = 0; i <= n; i++) {
            pascalTriangle[i][0] = 1;
            pascalTriangle[i][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];
            }
        }
        return pascalTriangle[n][k];
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream input) {
            br = new BufferedReader(new InputStreamReader(input));
            st = new StringTokenizer("");
        }

        public String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}