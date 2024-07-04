import java.util.Scanner;

class Solution {
    private static final StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases > 0) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int[] result = analyzeLatinMatrix(matrix);
            answer.append("Case #").append(caseNumber).append(": ")
                  .append(result[0]).append(" ").append(result[1]).append(" ").append(result[2]).append("\n");

            testCases--;
            caseNumber++;
        }

        System.out.println(answer);
    }

    private static int[] analyzeLatinMatrix(int[][] matrix) {
        int duplicateRows = 0;
        int duplicateColumns = 0;
        int diagonalSum = 0;

        for (int i = 0; i < matrix.length; i++) {
            diagonalSum += matrix[i][i];

            if (hasDuplicates(matrix[i])) {
                duplicateRows++;
            }

            int[] column = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                column[j] = matrix[j][i];
            }

            if (hasDuplicates(column)) {
                duplicateColumns++;
            }
        }

        return new int[]{diagonalSum, duplicateRows, duplicateColumns};
    }

    private static boolean hasDuplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}