import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());
        for (int i = 0; i < t; ++i) {
            solve(i+1, in);
        }
    }

    private static void solve(int test_nr, BufferedReader in) throws IOException {
        int[][] a = readMatrix(in);
        int n = a.length;
        int[] col = new int[n];

        int k = 0;
        for (int i = 0; i < n; ++i)
            k += a[i][i];

        int r = 0;
        for (int j = 0; j < n; ++j) {
            if (containsDuplicates(a[j]))
                r++;
        }

        int c = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j)
                col[j] = a[j][i];
            if (containsDuplicates(col))
                c++;
        }

        System.out.println(String.format("Case #%d: %d %d %d", test_nr, k, r, c));
    }

    private static boolean containsDuplicates(int[] a) {
        int n = a.length;
        boolean[] test = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int x = a[i]-1;
            if (test[x]) return true;
            test[x] = true;
        }
        return false;
    }

    private static int[][] readMatrix(BufferedReader in) throws IOException {
        int n = Integer.parseInt(in.readLine());
        int[][] res = new int[n][n];
        for (int j = 0; j < n; ++j) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < n; ++i) {
                res[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        return res;
    }
}
