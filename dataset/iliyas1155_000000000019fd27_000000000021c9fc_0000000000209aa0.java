import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = scanner.nextInt();
        for(int testCase=1; testCase<=cases; testCase++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] matrix = new int[n][n];
            boolean ok = tryAll(k, n, new boolean[n][n], new boolean[n][n], matrix, 0, 0);
            if (ok) {
                StringBuilder sb = new StringBuilder();
                for (int a = 0; a < n; a++) {
                    for (int b = 0; b < n; b++) {
                        sb.append(matrix[a][b]);
                        sb.append(' ');
                    }
                    sb.append('\n');
                }
                System.out.println("Case #" + testCase + ": POSSIBLE");
                System.out.print(sb.toString());
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }

    static boolean tryAll(int sum, int n, boolean[][] rows, boolean[][] cols, int[][] matrix, int i, int j) {
        if(i==n-1 && j==n && sumIsFine(sum, matrix)) {
            return true;
        }
        if(i<n-1 && j==n) {
            return tryAll(sum, n, rows, cols, matrix, i+1, 0);
        }
        if(i>=n || j>=n) return false;
        for(int num=0; num<n; num++) if(!rows[i][num] && !cols[j][num]) {
            rows[i][num] = true;
            cols[j][num] = true;
            matrix[i][j] = num+1;
            boolean ok = tryAll(sum, n, rows, cols, matrix, i, j+1);
            if(ok) return true;
            rows[i][num] = false;
            cols[j][num] = false;
            matrix[i][j] = 0;
        }
        return false;
    }

    static boolean sumIsFine(int sum, int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            sum -= matrix[i][i];
        }
        return sum==0;
    }
}

