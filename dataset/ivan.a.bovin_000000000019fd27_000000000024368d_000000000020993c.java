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
                int rowSum = 0;
                int columnSum = 0;
                for (int j = 0; j < N; ++j) {
                    rowSum += M[i][j] - j;
                    columnSum += M[j][i] - j;
                }
                if (rowSum != N) {
                    ++r;
                }
                if (columnSum != N) {
                    ++c;
                }
            }
            // Case #x: k r c
            System.out.format("Case #%d: %d %d %d%n", x + 1, k, r, c);
        }
    }
}
