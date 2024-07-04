import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    static Scanner in = new Scanner(System.in);

    public static void main(String args[]) {
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            System.out.println("Case #" + i + ": " + secret());
        }
    }

    static int getTrace(int[][] Matrix, int N) {
        int trace = 0;

        for(int i = 0; i < N; i++) {
            trace += Matrix[i][i];
        }

        return trace;
    }

    // Output is: k r c, k is trace, r num of rows that contain repeated elements and c number of columns with repeated elements
    private static String secret() {
        int N = in.nextInt(); // Len of row/col, like in Sudoku n = 9
        // All values in Matrix, are in [1, N]
        int[][] Matrix = new int[N][N];
        int rows = 0;
        int cols = 0;
        Set<Integer>[] rowsValues = new Set[N];
        Set<Integer>[] colsValues = new Set[N];
        for(int i = 0; i < N; i++) {
            rowsValues[i] = new HashSet<>();
            for(int j = 0; j < N; j++) {
                if(i == 0) {
                    colsValues[j] = new HashSet<>();
                }
                Matrix[i][j] = in.nextInt();
                int val = Matrix[i][j];
                rowsValues[i].add(val);
                colsValues[j].add(val);

                if(i == N - 1 && colsValues[j].size() < N) {
                    cols++;
                }
            }

            if(rowsValues[i].size() < N) {
                rows++;
            }
        }

        int trace = getTrace(Matrix, N);

        return ""  + trace + " " + rows + " " + cols;
    }
}
