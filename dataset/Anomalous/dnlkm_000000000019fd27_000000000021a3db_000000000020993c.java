import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int diagonalSum = 0;
            for (int i = 0; i < matrixSize; i++) {
                diagonalSum += matrix[i][i];
            }

            int duplicateRowsCount = 0;
            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    if (!uniqueElements.add(matrix[row][col])) {
                        duplicateRowsCount++;
                        break;
                    }
                }
            }

            int duplicateColumnsCount = 0;
            for (int col = 0; col < matrixSize; col++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    if (!uniqueElements.add(matrix[row][col])) {
                        duplicateColumnsCount++;
                        break;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", testCase, diagonalSum, duplicateRowsCount, duplicateColumnsCount);
        }
    }
}