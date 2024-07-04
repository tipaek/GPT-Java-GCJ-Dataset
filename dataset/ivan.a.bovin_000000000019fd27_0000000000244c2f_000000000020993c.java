import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // test cases
        final int T = input.nextInt();
        for (int x = 0; x < T; ++x) {
            // matrix size
            final int N = input.nextInt();
            final int[][] M = new int[N][N];
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    // matrix element
                    M[i][j] = input.nextInt();
                }
            }
            // --
            int k = 0;
            int r = 0;
            int c = 0;
            for (int i = 0; i < N; ++i) {
                k += M[i][i];
                boolean[] row = new boolean[N];
                boolean badRow = false;
                boolean[] col = new boolean[N];
                boolean badCol = false;
                for (int j = 0; j < N; ++j) {
                    int ir = M[i][j] - 1;
                    if (row[ir]) {
                        badRow = true;
                    } else {
                        row[ir] = true;
                    }
                    int ic = M[j][i] - 1;
                    if (col[ic]) {
                        badCol = true;
                    } else {
                        col[ic] = true;
                    }
                }
                if (badRow) {
                    ++r;
                }
                if (badCol) {
                    ++c;
                }
            }
            // Case #x: k r c
            System.out.format("Case #%d: %d %d %d%n", x + 1, k, r, c);
        }
    }
}
