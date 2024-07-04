import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculating the trace of the matrix
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Counting rows with duplicate elements
            int rowDuplicates = 0;
            for (int i = 0; i < n; i++) {
                Map<Integer, Integer> rowMap = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    rowMap.put(matrix[i][j], rowMap.getOrDefault(matrix[i][j], 0) + 1);
                }
                if (rowMap.values().stream().anyMatch(count -> count > 1)) {
                    rowDuplicates++;
                }
            }

            // Counting columns with duplicate elements
            int columnDuplicates = 0;
            for (int i = 0; i < n; i++) {
                Map<Integer, Integer> columnMap = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    columnMap.put(matrix[j][i], columnMap.getOrDefault(matrix[j][i], 0) + 1);
                }
                if (columnMap.values().stream().anyMatch(count -> count > 1)) {
                    columnDuplicates++;
                }
            }

            // Printing the result for the current case
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, rowDuplicates, columnDuplicates);
            caseNumber++;
        }

        scanner.close();
    }
}