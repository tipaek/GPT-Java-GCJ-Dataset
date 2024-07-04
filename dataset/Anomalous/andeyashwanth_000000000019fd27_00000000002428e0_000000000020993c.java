import java.util.Scanner;

class Test {
    static int calculateDiagonalSum(int[][] matrix, int size) {
        int diagonalSum = 0;
        for (int i = 0; i < size; i++) {
            diagonalSum += matrix[i][i];
        }
        return diagonalSum;
    }

    static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumns = 0;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                for (int nextRow = row + 1; nextRow < size; nextRow++) {
                    if (matrix[row][col] == matrix[nextRow][col]) {
                        duplicateColumns++;
                        break;
                    }
                }
            }
        }
        return duplicateColumns;
    }

    static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                for (int nextCol = col + 1; nextCol < size; nextCol++) {
                    if (matrix[row][col] == matrix[row][nextCol]) {
                        duplicateRows++;
                        break;
                    }
                }
            }
        }
        return duplicateRows;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int diagonalSum = calculateDiagonalSum(matrix, size);
            int duplicateRows = countDuplicateRows(matrix, size);
            int duplicateColumns = countDuplicateColumns(matrix, size);

            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }

        scanner.close();
    }
}