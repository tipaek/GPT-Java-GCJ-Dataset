import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }

    public Solution() throws IOException {}

    private void run() throws IOException {
        solve();
        out.close();
    }

    private void solve() throws IOException {
        int t = nextInt();
        for (int it = 0; it < t; it++) {
            int n = nextInt();
            int[][] matrix = new int[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    matrix[r][c] = nextInt();
                }
            }
//Arrays.deepToString(matrix)

            int k = getTrace(matrix);
            int r = numRepeatedRows(matrix, n);
            int c = numRepeatedCols(matrix, n);
            System.out.println(
                    "Case #1: " + k  + " " + r + " "  + c
            );

        }
    }

    private int getTrace(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum+= matrix[i][i];
        }
        return sum;
    }

    private int numRepeatedRows(int[][] matrix, int n) {
        int res = 0;

        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            int[] freq = new int[n];

            for (int v : row) {
                if (++freq[v-1] > 1) {
                    res++;
                    break;
                }
            }
        }

        return res;
    }

    private int numRepeatedCols(int[][] matrix, int n) {
        int res = 0;

        int r= 0;
        int c = 0;

        while (c < n) {
            int[] freq = new int[n];
            while (r < n) {
                if (++freq[matrix[r][c] - 1] > 1) {
                    res++;
                    break;
                }
                r++;
            }
            c++;
            r = 0;
        }

        return res;
    }


    String next() throws IOException  {
        while (st == null || !st.hasMoreTokens())  {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws IOException  {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException  {
        return Long.parseLong(next());
    }


}
