import java.util.*;

public class MatrixChecker {

    public static int checkRows(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int i = 0; i < size; i++) {
            int[] row = Arrays.copyOf(matrix[i], size);
            Arrays.sort(row);
            for (int j = 0; j < size - 1; j++) {
                if (row[j] == row[j + 1]) {
                    duplicateCount++;
                    break;
                }
            }
        }
        return duplicateCount;
    }

    public static int checkColumns(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int i = 0; i < size; i++) {
            int[] column = new int[size];
            for (int j = 0; j < size; j++) {
                column[j] = matrix[j][i];
            }
            Arrays.sort(column);
            for (int j = 0; j < size - 1; j++) {
                if (column[j] == column[j + 1]) {
                    duplicateCount++;
                    break;
                }
            }
        }
        return duplicateCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int diagonalSum = 0;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int rowDuplicates = checkRows(matrix, size);
            int columnDuplicates = checkColumns(matrix, size);

            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
        }
        scanner.close();
    }
}