import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCaseIndex = 0; testCaseIndex < testCases; testCaseIndex++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = readMatrix(scanner, matrixSize);
            int trace = calculateTrace(matrix);
            int[] rowSums = new int[matrixSize];
            int[] colSums = new int[matrixSize];

            calculateRowAndColSums(matrix, rowSums, colSums);

            int expectedSum = calculateSum(matrixSize);
            int duplicateRows = countDuplicates(rowSums, expectedSum);
            int duplicateCols = countDuplicates(colSums, expectedSum);

            System.out.println("Case #" + (testCaseIndex + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }

    private static int[][] readMatrix(Scanner scanner, int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            String[] rowValues = scanner.nextLine().split(" ");
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = Integer.parseInt(rowValues[j]);
            }
        }
        return matrix;
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static void calculateRowAndColSums(int[][] matrix, int[] rowSums, int[] colSums) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                rowSums[i] += matrix[i][j];
                colSums[j] += matrix[i][j];
            }
        }
    }

    private static int calculateSum(int n) {
        return n * (n + 1) / 2;
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
}