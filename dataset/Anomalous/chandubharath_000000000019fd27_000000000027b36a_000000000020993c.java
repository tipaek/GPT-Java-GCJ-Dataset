import java.util.HashSet;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void calcVestigium() {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;

        // Read the matrix and calculate the trace
        for (int i = 0; i < n; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            boolean rowHasDuplicate = false;

            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
                if (!rowSet.add(matrix[i][j])) {
                    rowHasDuplicate = true;
                }
                if (i == j) {
                    trace += matrix[i][j];
                }
            }

            if (rowHasDuplicate) {
                rowDuplicates++;
            }
        }

        // Check for column duplicates
        for (int j = 0; j < n; j++) {
            HashSet<Integer> colSet = new HashSet<>();
            boolean colHasDuplicate = false;

            for (int i = 0; i < n; i++) {
                if (!colSet.add(matrix[i][j])) {
                    colHasDuplicate = true;
                }
            }

            if (colHasDuplicate) {
                colDuplicates++;
            }
        }

        System.out.println(trace + " " + rowDuplicates + " " + colDuplicates);
    }

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            calcVestigium();
        }
    }
}