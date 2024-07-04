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
        int xor = 0;
        for (int i=1; i<=n; i++) {
            xor ^= i;
        }
        int[] xorArray = new int[n];
        for (int i=1; i<=n; i++) {
            xorArray[i-1] = xor;
        }

        for (int i=1; i<=n; i++) {
            int x = xor;
            for (int j=1; j<=n; j++) {
                int curNum = m[i-1][j-1];
                if (i==j) res[0] += curNum;

                x ^= curNum;
                xorArray[j-1] ^= curNum;
            }
            if (x!=0) {
                res[1]++;
            }
        }
        for (int i=1; i<=n; i++) {
            if (xorArray[i-1] != 0) {
                res[2]++;
            }
        }
        return res;
    }
}