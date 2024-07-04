import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Read the matrix and compute the trace
            for (int i = 0; i < matrixSize; i++) {
                String[] row = scanner.nextLine().split(" ");
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for duplicate values in rows
            for (int i = 0; i < matrixSize; i++) {
                boolean[] seen = new boolean[matrixSize + 1];
                for (int j = 0; j < matrixSize; j++) {
                    if (seen[matrix[i][j]]) {
                        rowDuplicates++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < matrixSize; j++) {
                boolean[] seen = new boolean[matrixSize + 1];
                for (int i = 0; i < matrixSize; i++) {
                    if (seen[matrix[i][j]]) {
                        colDuplicates++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}