import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int j = 1; j <= n; ++j) {
                for (int k = 1; k <= n; ++k) {
                    matrix[j-1][k-1] = in.nextInt();
                }
            }
            int[] result = checkMatrix(n, matrix);
            System.out.println("Case "+i+": "+result[0]+" "+result[1]+" "+result[2]);

        }
    }

    private static int[] checkMatrix(int n, int[][] m) {
        int[] res = new int[3];
        outer:
        for (int i=1; i<=n; i++) {
            boolean[] appear = new boolean[n];
            res[0] += m[i-1][i-1];
            for (int j=1; j<=n; j++) {
                int curNum = Math.abs(m[i-1][j-1]);
                if (appear[curNum-1]) {
                    res[1]++;
                    continue outer;
                } else {
                    appear[curNum-1] = true;
                }
            }
        }

        outer:
        for (int i=1; i<=n; i++) {
            boolean[] appear = new boolean[n];
            for (int j=1; j<=n; j++) {
                int curNum = Math.abs(m[j-1][i-1]);
                if (appear[curNum-1]) {
                    res[2]++;
                    continue outer;
                } else {
                    appear[curNum-1] = true;
                }
            }
        }
        return res;
    }
}