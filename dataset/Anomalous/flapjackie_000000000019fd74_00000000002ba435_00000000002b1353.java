import java.util.*;
import java.io.*;

public class Solution {
    static int r, k;
    static PrintWriter out;
    static long[][] pascalTriangle;

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner(System.in);
        out = new PrintWriter(System.out);
        pascalTriangle = new long[501][501];
        initializePascalTriangle(500, 500);
        int T = sc.nextInt();

        for (int ca = 1; ca <= T; ca++) {
            long n = sc.nextLong();
            long sum = 1;
            out.printf("Case #%d:\n", ca);
            r = 0;
            k = 0;
            printPosition(r, k);
            r++;
            k++;

            while (n >= sum + pascalTriangle[r][k] + 1) {
                sum += pascalTriangle[r][k];
                printPosition(r, k);
                r++;
            }
            r--;
            k--;

            while (n > sum) {
                sum += pascalTriangle[r][k];
                printPosition(r, k);
                r++;
            }
        }
        out.close();
    }

    static void printPosition(int r, int k) {
        out.println((r + 1) + " " + (k + 1));
    }

    static void initializePascalTriangle(int n, int k) {
        for (int i = 0; i <= n; i++) {
            pascalTriangle[i][0] = 1;
            pascalTriangle[i][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];
            }
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream i) {
            br = new BufferedReader(new InputStreamReader(i));
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