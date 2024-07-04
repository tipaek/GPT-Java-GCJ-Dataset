import java.util.Scanner;

public class MatrixTrace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n = scanner.nextInt();
        
        int[][] matrix = new int[n][n];
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        // Reading the matrix elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Calculating the trace
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        // Checking for duplicate elements in rows and columns
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                // Check row duplicates
                if (!rowSet.add(matrix[i][j])) {
                    rowDuplicates++;
                    break;
                }
                // Check column duplicates
                if (!colSet.add(matrix[j][i])) {
                    colDuplicates++;
                    break;
                }
            }
        }

        // Printing the results for each test case
        for (int i = 1; i <= t; i++) {
            System.out.println("Case #" + i + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}