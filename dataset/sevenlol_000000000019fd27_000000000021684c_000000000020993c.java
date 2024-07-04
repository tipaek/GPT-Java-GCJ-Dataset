import java.io.*;
import java.util.*;

/**
 * Solution
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        try {
            solve(sc);
        } finally {
            sc.close();
        }
    }

    private static void solve(Scanner sc) {
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int[][] mat = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    mat[j][k] = sc.nextInt();
                }
            }
            solve(i, mat, N);
        }
    }

    private static void solve(int T, int[][] mat, int N) {
        System.out.printf("Case #%d: ", T);
        int trace = 0;
        boolean[][] row = new boolean[N][N + 1];
        boolean[][] col = new boolean[N][N + 1];
        Set<Integer> dupRow = new HashSet<>();
        Set<Integer> dupCol = new HashSet<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (row[i][mat[i][j]]) {
                    dupRow.add(i);
                }
                if (col[j][mat[i][j]]) {
                    dupCol.add(j);
                }
                row[i][mat[i][j]] = col[j][mat[i][j]] = true;
                if (i == j) {
                    trace += mat[i][j];
                }
            }
        }
        System.out.printf("%d %d %d\n", trace, dupRow.size(), dupCol.size());
    }
}