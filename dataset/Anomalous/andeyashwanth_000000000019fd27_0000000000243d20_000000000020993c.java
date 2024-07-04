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
            int[] frequencyMap = new int[size + 1];
            for (int row = 0; row < size; row++) {
                if (frequencyMap[matrix[row][col]] > 0) {
                    duplicateColumns++;
                    break;
                }
                frequencyMap[matrix[row][col]]++;
            }
        }
        return duplicateColumns;
    }

    static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int row = 0; row < size; row++) {
            int[] frequencyMap = new int[size + 1];
            for (int col = 0; col < size; col++) {
                if (frequencyMap[matrix[row][col]] > 0) {
                    duplicateRows++;
                    break;
                }
                frequencyMap[matrix[row][col]]++;
            }
        }
        return duplicateRows;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int diagonalSum = calculateDiagonalSum(matrix, matrixSize);
            int duplicateRows = countDuplicateRows(matrix, matrixSize);
            int duplicateColumns = countDuplicateColumns(matrix, matrixSize);

            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }

        scanner.close();
    }
}