import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void calcVestigium() {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        int trace = 0, rowCount = 0, columnCount = 0;

        // Read matrix and calculate the trace
        for (int i = 0; i < n; i++) {
            HashMap<Integer, Boolean> rowMap = new HashMap<>();
            boolean rowDuplicate = false;
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
                if (!rowDuplicate && rowMap.put(matrix[i][j], true) != null) {
                    rowCount++;
                    rowDuplicate = true;
                }
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
        }

        // Check for duplicate elements in columns
        for (int j = 0; j < n; j++) {
            HashMap<Integer, Boolean> columnMap = new HashMap<>();
            boolean columnDuplicate = false;
            for (int i = 0; i < n; i++) {
                if (!columnDuplicate && columnMap.put(matrix[i][j], true) != null) {
                    columnCount++;
                    columnDuplicate = true;
                }
            }
        }

        System.out.println(trace + " " + rowCount + " " + columnCount);
    }

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            calcVestigium();
        }
    }
}