import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = readMatrix(scanner, matrixSize);

            int trace = calculateTrace(matrix);
            int[] rowSums = new int[matrixSize];
            int[] colSums = new int[matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    rowSums[row] += matrix[row][col];
                    colSums[col] += matrix[row][col];
                }
            }

            int expectedSum = calculateExpectedSum(matrixSize);
            int duplicateRows = countDuplicates(rowSums, expectedSum);
            int duplicateCols = countDuplicates(colSums, expectedSum);

            System.out.println("Case #" + (caseIndex + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }

    private static int countDuplicates(int[] sums, int expectedSum) {
        int duplicates = 0;
        for (int sum : sums) {
            if (sum != expectedSum) {
                duplicates++;
            }
        }
        return duplicates;
    }

    private static int calculateExpectedSum(int size) {
        return size * (size + 1) / 2;
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int[][] readMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            String[] elements = scanner.nextLine().split(" ");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = Integer.parseInt(elements[col]);
            }
        }
        return matrix;
    }
}