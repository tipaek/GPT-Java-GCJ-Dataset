import java.util.HashSet;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Reading the matrix
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Calculating trace and row duplicates
            for (int i = 0; i < matrixSize; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int j = 0; j < matrixSize; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowHasDuplicate) {
                        if (rowSet.contains(matrix[i][j])) {
                            rowDuplicates++;
                            rowHasDuplicate = true;
                        } else {
                            rowSet.add(matrix[i][j]);
                        }
                    }
                }
            }

            // Calculating column duplicates
            for (int j = 0; j < matrixSize; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < matrixSize; i++) {
                    if (colSet.contains(matrix[i][j])) {
                        colDuplicates++;
                        break;
                    } else {
                        colSet.add(matrix[i][j]);
                    }
                }
            }

            // Printing the result
            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}