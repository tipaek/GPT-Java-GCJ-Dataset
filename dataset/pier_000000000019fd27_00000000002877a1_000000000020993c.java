import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int[][] M = new int[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    M[r][c] = sc.nextInt();
                }
            }
            int trace = calculateTrace(M);
            int rows = repeatedRows(M);
            int cols = repeatedCols(M);
            System.out.println("Case #" + i + " " + trace + " " + rows + " " + cols);
        }
    }

    static int calculateTrace(int[][] M) {
        int sum = 0;
        for (int d = 0; d < M.length; d++) {
            sum += M[d][d];
        }
        return sum;
    }

    static int numRepeatedValues(int[] a) {
        int repeated = 0;
        for (int v : a) {
            int n = 0;
            for (int z : a) {
                if (z == v) {
                    n++;
                }
            }
            if (n > 1) {
                repeated++;
            }
        }
        return repeated;
    }

    static int repeatedRows(int[][] M) {
        int ris = 0;
        for (int r = 0; r < M.length; r++) {
            if (numRepeatedValues(M[r]) > 0) {
                ris++;
            }
        }
        return ris;
    }

    static int[] getColumn(int[][] M, int col) {
        int[] ris = new int[M.length];
        for (int r = 0; r < M.length; r++) {
            ris[r] = M[r][col];
        }
        return ris;
    }

    static int repeatedCols(int[][] M) {
        int ris = 0;
        for (int c = 0; c < M.length; c++) {
            int[] col = getColumn(M, c);
            if (numRepeatedValues(col) > 0) {
                ris++;
            }
        }
        return ris;
    }
}