import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        runCodeJam();
    }

    public static void runCodeJam() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Skip the first line
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                String[] line = scanner.nextLine().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(line[col]);
                }
            }

            processMatrix(matrix, caseIndex + 1);
        }

        scanner.close();
    }

    private static void processMatrix(int[][] matrix, int caseNumber) {
        int[] lineResults = findLineDuplicates(matrix);
        System.out.printf("Case #%d: %d %d %d%n", caseNumber, calculateDiagonalSum(matrix), lineResults[0], lineResults[1]);
    }

    private static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int[] findLineDuplicates(int[][] matrix) {
        int duplicateRows = 0;
        int duplicateColumns = 0;

        for (int i = 0; i < matrix.length; i++) {
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

        return new int[]{duplicateRows, duplicateColumns};
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int num : array) {
            if (seen[num]) {
                return true;
            }
            seen[num] = true;
        }
        return false;
    }
}