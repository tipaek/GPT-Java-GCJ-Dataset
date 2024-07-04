import java.util.Scanner;

public class Jam1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int k = 0; k < t; k++) {
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix from user input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculating the trace of the matrix
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Checking for duplicate values in each row
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Checking for duplicate values in each column
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }

            // Printing the results
            System.out.println("Case #" + (k + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
        
        scanner.close();
    }
}