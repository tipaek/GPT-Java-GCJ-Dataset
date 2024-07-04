import java.util.Scanner;
import java.util.HashSet;

class Solution {

    static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumns = 0;
        for (int col = 0; col < size; col++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < size; row++) {
                uniqueElements.add(matrix[row][col]);
            }
            if (uniqueElements.size() < size) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 0; testCase < testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0, duplicateRows = 0, duplicateColumns = 0;

            for (int row = 0; row < matrixSize; row++) {
                HashSet<Integer> uniqueElements = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                    uniqueElements.add(matrix[row][col]);
                }
                if (uniqueElements.size() < matrixSize) {
                    duplicateRows++;
                }
            }

            duplicateColumns = countDuplicateColumns(matrix, matrixSize);
            System.out.println("Case #" + (testCase + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
        
        scanner.close();
    }
}