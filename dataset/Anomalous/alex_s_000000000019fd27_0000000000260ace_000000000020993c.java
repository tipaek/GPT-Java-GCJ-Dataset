import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numCases; caseNumber++) {
            System.out.print("Case #" + caseNumber + ":");
            int[][] matrix = readMatrix(scanner);
            System.out.println(solve(matrix));
        }

        scanner.close();
    }

    private static int[][] readMatrix(Scanner scanner) {
        int dimension = scanner.nextInt();
        int[][] matrix = new int[dimension][dimension];

        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static String solve(int[][] matrix) {
        int dimension = matrix.length;
        int trace = calculateTrace(matrix, dimension);
        int rowCount = countDuplicateRows(matrix, dimension);
        int colCount = countDuplicateColumns(matrix, dimension);

        return " " + trace + " " + rowCount + " " + colCount;
    }

    private static int calculateTrace(int[][] matrix, int dimension) {
        int trace = 0;
        for (int i = 0; i < dimension; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int dimension) {
        int rowCount = 0;
        for (int row = 0; row < dimension; row++) {
            boolean[] seen = new boolean[dimension];
            for (int col = 0; col < dimension; col++) {
                if (seen[matrix[row][col] - 1]) {
                    rowCount++;
                    break;
                }
                seen[matrix[row][col] - 1] = true;
            }
        }
        return rowCount;
    }

    private static int countDuplicateColumns(int[][] matrix, int dimension) {
        int colCount = 0;
        for (int col = 0; col < dimension; col++) {
            boolean[] seen = new boolean[dimension];
            for (int row = 0; row < dimension; row++) {
                if (seen[matrix[row][col] - 1]) {
                    colCount++;
                    break;
                }
                seen[matrix[row][col] - 1] = true;
            }
        }
        return colCount;
    }
}