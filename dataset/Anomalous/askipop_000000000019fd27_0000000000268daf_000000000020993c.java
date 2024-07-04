import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];

            // Read matrix input
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Calculate trace, row repeats, and column repeats
            for (int i = 0; i < N; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                boolean rowHasRepeat = false;
                boolean colHasRepeat = false;

                trace += matrix[i][i];

                for (int j = 0; j < N; j++) {
                    // Check row for repeats
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasRepeat = true;
                    }

                    // Check column for repeats
                    if (!colSet.add(matrix[j][i])) {
                        colHasRepeat = true;
                    }
                }

                if (rowHasRepeat) {
                    rowRepeats++;
                }
                if (colHasRepeat) {
                    colRepeats++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowRepeats, colRepeats);
        }
    }
}