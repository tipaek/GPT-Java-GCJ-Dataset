import java.util.*;

public class Solution {

    static int readMatrixAndSumDiagonal(int size, int[][] matrix, Scanner scanner) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
            sum += matrix[i][i];
        }
        return sum;
    }

    static int countInvalidRows(int[][] matrix, int size) {
        int invalidRowCount = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> distinctValues = new HashSet<>();
            for (int j = 0; j < size; j++) {
                distinctValues.add(matrix[i][j]);
            }
            if (distinctValues.size() < size) {
                invalidRowCount++;
            }
        }
        return invalidRowCount;
    }

    static int countInvalidColumns(int[][] matrix, int size) {
        int invalidColumnCount = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> distinctValues = new HashSet<>();
            for (int j = 0; j < size; j++) {
                distinctValues.add(matrix[j][i]);
            }
            if (distinctValues.size() < size) {
                invalidColumnCount++;
            }
        }
        return invalidColumnCount;
    }

    public static void main(String[] args) {
        final int MAX_SIZE = 100;
        Scanner scanner = new Scanner(System.in);
        int numberOfSquares = scanner.nextInt();
        int[][] matrix = new int[MAX_SIZE][MAX_SIZE];

        for (int t = 0; t < numberOfSquares; t++) {
            int size = scanner.nextInt();
            int diagonalSum = readMatrixAndSumDiagonal(size, matrix, scanner);
            int invalidRows = countInvalidRows(matrix, size);
            int invalidColumns = countInvalidColumns(matrix, size);
            System.out.println("Case #" + (t + 1) + ": " + diagonalSum + " " + invalidRows + " " + invalidColumns);
        }
    }
}