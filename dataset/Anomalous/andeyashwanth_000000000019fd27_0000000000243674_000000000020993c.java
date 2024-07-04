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
            int[] frequency = new int[101];
            for (int row = 0; row < size; row++) {
                if (frequency[matrix[row][col]] > 0) {
                    duplicateColumns++;
                    break;
                }
                frequency[matrix[row][col]]++;
            }
        }
        return duplicateColumns;
    }

    static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int row = 0; row < size; row++) {
            int[] frequency = new int[101];
            for (int col = 0; col < size; col++) {
                if (frequency[matrix[row][col]] > 0) {
                    duplicateRows++;
                    break;
                }
                frequency[matrix[row][col]]++;
            }
        }
        return duplicateRows;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        for (int testIndex = 1; testIndex <= numberOfTests; testIndex++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            int diagonalSum = calculateDiagonalSum(matrix, size);
            int duplicateRows = countDuplicateRows(matrix, size);
            int duplicateColumns = countDuplicateColumns(matrix, size);
            System.out.println("Case #" + testIndex + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
        scanner.close();
    }
}