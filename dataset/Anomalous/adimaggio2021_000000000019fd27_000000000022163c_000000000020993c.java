import java.util.Scanner;

public class MatrixAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read matrix values
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Calculate row duplicates
            int rowDuplicates = 0;
            for (int i = 0; i < n; i++) {
                boolean hasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < j; k++) {
                        if (matrix[i][j] == matrix[i][k]) {
                            hasDuplicate = true;
                            break;
                        }
                    }
                    if (hasDuplicate) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Calculate column duplicates
            int columnDuplicates = 0;
            for (int i = 0; i < n; i++) {
                boolean hasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < j; k++) {
                        if (matrix[j][i] == matrix[k][i]) {
                            hasDuplicate = true;
                            break;
                        }
                    }
                    if (hasDuplicate) {
                        columnDuplicates++;
                        break;
                    }
                }
            }

            // Print result
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }

        scanner.close();
    }
}