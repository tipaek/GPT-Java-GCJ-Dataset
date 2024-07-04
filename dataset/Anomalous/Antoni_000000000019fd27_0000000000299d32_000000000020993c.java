import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        codeJam();
    }

    public static void codeJam() throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            int cases = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < cases; i++) {
                int size = Integer.parseInt(scanner.nextLine());
                int[][] matrix = new int[size][size];
                for (int j = 0; j < size; j++) {
                    String[] line = scanner.nextLine().split(" ");
                    for (int k = 0; k < size; k++) {
                        matrix[j][k] = Integer.parseInt(line[k]);
                    }
                }
                processMatrix(matrix, i + 1);
            }
        }
    }

    private static void processMatrix(int[][] matrix, int caseNumber) {
        System.out.println("Case #" + caseNumber + ": " + calculateDiagonal(matrix) + " " + countDuplicateRows(matrix) + " " + countDuplicateColumns(matrix));
    }

    private static int calculateDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                count++;
            }
        }
        return count;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int count = 0;
        for (int col = 0; col < matrix.length; col++) {
            int[] column = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                count++;
            }
        }
        return count;
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}