import java.util.Scanner;

class MatrixAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases > 0) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            // Read the matrix and calculate the diagonal sum
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            // Check for duplicate rows
            for (int i = 0; i < size; i++) {
                boolean hasDuplicate = false;
                for (int j = 0; j < size - 1; j++) {
                    for (int k = j + 1; k < size; k++) {
                        if (matrix[i][j] == matrix[i][k]) {
                            duplicateRows++;
                            hasDuplicate = true;
                            break;
                        }
                    }
                    if (hasDuplicate) break;
                }
            }

            // Check for duplicate columns
            for (int i = 0; i < size; i++) {
                boolean hasDuplicate = false;
                for (int j = 0; j < size - 1; j++) {
                    for (int k = j + 1; k < size; k++) {
                        if (matrix[j][i] == matrix[k][i]) {
                            duplicateColumns++;
                            hasDuplicate = true;
                            break;
                        }
                    }
                    if (hasDuplicate) break;
                }
            }

            // Print the results
            System.out.println(diagonalSum + " " + duplicateRows + " " + duplicateColumns);
            testCases--;
        }

        scanner.close();
    }
}