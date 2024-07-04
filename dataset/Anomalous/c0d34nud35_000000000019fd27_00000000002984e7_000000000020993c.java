import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scan.nextInt();
            int[][] square = new int[N][N];

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    square[r][c] = scan.nextInt();
                }
            }

            int K = calculateTrace(square, N);
            int R = calculateRepeatingRows(square, N);
            int C = calculateRepeatingColumns(square, N);

            System.out.printf("Case #%d: %d %d %d%n", t + 1, K, R, C);
        }
    }

    private static int calculateTrace(int[][] square, int N) {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += square[i][i];
        }
        return trace;
    }

    private static int calculateRepeatingRows(int[][] square, int N) {
        int repeatingRows = 0;
        for (int r = 0; r < N; r++) {
            HashSet<Integer> found = new HashSet<>();
            boolean hasDuplicate = false;
            for (int c = 0; c < N; c++) {
                if (!found.add(square[r][c])) {
                    hasDuplicate = true;
                    break;
                }
            }
            if (hasDuplicate) {
                repeatingRows++;
            }
        }
        return repeatingRows;
    }

    private static int calculateRepeatingColumns(int[][] square, int N) {
        int repeatingColumns = 0;
        for (int c = 0; c < N; c++) {
            HashSet<Integer> found = new HashSet<>();
            boolean hasDuplicate = false;
            for (int r = 0; r < N; r++) {
                if (!found.add(square[r][c])) {
                    hasDuplicate = true;
                    break;
                }
            }
            if (hasDuplicate) {
                repeatingColumns++;
            }
        }
        return repeatingColumns;
    }
}