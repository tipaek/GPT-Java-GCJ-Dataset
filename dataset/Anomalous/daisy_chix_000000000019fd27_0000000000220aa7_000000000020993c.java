import java.util.Scanner;
import java.util.HashSet;

class Solution {

    static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumnCount = 0;

        for (int col = 0; col < size; ++col) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < size; ++row) {
                uniqueElements.add(matrix[row][col]);
            }
            if (uniqueElements.size() < size) {
                duplicateColumnCount++;
            }
        }
        return duplicateColumnCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; ++testCase) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;
            int duplicateRowCount = 0;

            for (int row = 0; row < matrixSize; ++row) {
                HashSet<Integer> uniqueElements = new HashSet<>();
                for (int col = 0; col < matrixSize; ++col) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;
                    if (row == col) {
                        trace += value;
                    }
                    uniqueElements.add(value);
                }
                if (uniqueElements.size() < matrixSize) {
                    duplicateRowCount++;
                }
            }

            int duplicateColumnCount = countDuplicateColumns(matrix, matrixSize);

            System.out.println("Case #" + (testCase + 1) + ": " + trace + " " + duplicateRowCount + " " + duplicateColumnCount);
        }
    }
}