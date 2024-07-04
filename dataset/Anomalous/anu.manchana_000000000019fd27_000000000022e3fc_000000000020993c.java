import java.util.*;

public class MatrixAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<int[]> results = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
            int[][] matrix = new int[d][d];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Read matrix and calculate row duplicates
            for (int j = 0; j < d; j++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicates = false;
                for (int k = 0; k < d; k++) {
                    matrix[j][k] = scanner.nextInt();
                    if (!rowSet.add(matrix[j][k])) {
                        rowHasDuplicates = true;
                    }
                }
                if (rowHasDuplicates) {
                    rowDuplicates++;
                }
            }

            // Calculate trace
            for (int j = 0; j < d; j++) {
                trace += matrix[j][j];
            }

            // Calculate column duplicates
            for (int j = 0; j < d; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicates = false;
                for (int k = 0; k < d; k++) {
                    if (!colSet.add(matrix[k][j])) {
                        colHasDuplicates = true;
                    }
                }
                if (colHasDuplicates) {
                    colDuplicates++;
                }
            }

            results.add(new int[]{i + 1, trace, rowDuplicates, colDuplicates});
        }

        // Print results
        for (int[] result : results) {
            System.out.printf("Case #%d: %d %d %d%n", result[0], result[1], result[2], result[3]);
        }
    }
}