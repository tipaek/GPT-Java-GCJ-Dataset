import java.util.Scanner;

/**
 * @author zhxu
 */

public class Solution {
    public static void main(final String[] args) {
        Scanner in = new Scanner(System.in);
        final int testCases = in.nextInt();
        for (int i = 0; i < testCases; ++i) {
            final int N = in.nextInt();
            final int[][] matrix = new int[N][N];

            int trace = 0;
            int r = 0;
            int c = 0;

            for (int j = 0; j < N; ++j) {
                for (int k = 0; k < N; ++k) {
                    matrix[j][k] = in.nextInt();
                    if(j == k) {
                        trace += matrix[j][k];
                    }
                }
            }

            for(int[] row : matrix) {
                final boolean[] exist = new boolean[N + 1];
                for(int cell : row) {
                    if(exist[cell]) {
                        r++;
                        break;
                    }
                    else {
                        exist[cell] = true;
                    }
                }
            }

            for (int j = 0; j < N; ++j) {
                final boolean[] exist = new boolean[N + 1];
                for (int k = 0; k < N; ++k) {
                    if(exist[matrix[k][j]]) {
                        c++;
                        break;
                    }
                    else {
                        exist[matrix[k][j]] = true;
                    }
                }
            }


            System.out.println(String.format("Case #%d: %d %d %d", i + 1, trace, r, c));
        }
    }
}
