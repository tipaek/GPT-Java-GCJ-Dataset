import java.util.*;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            System.out.print("Case #" + testCase + ": ");
            solveTestCase(scanner);
        }
    }

    private static void solveTestCase(Scanner scanner) {
        int trace = 0, rowRepeats = 0, columnRepeats = 0;
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                matrix[row][col] = scanner.nextInt();
                if (row == col) {
                    trace += matrix[row][col];
                }
            }
        }

        for (int row = 0; row < matrixSize; row++) {
            if (hasDuplicates(matrix[row])) {
                rowRepeats++;
            }
        }

        for (int col = 0; col < matrixSize; col++) {
            if (hasDuplicates(getColumn(matrix, col))) {
                columnRepeats++;
            }
        }

        System.out.println(trace + " " + rowRepeats + " " + columnRepeats);
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int col) {
        int[] column = new int[matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            column[row] = matrix[row][col];
        }
        return column;
    }
}