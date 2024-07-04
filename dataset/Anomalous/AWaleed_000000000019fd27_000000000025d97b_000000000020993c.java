import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;
                    if (row == col) {
                        trace += value;
                    }
                }
                if (!isUniqueElements(matrix[row])) {
                    rowRepeats++;
                }
            }
            colRepeats = countColumnRepeats(matrix);
            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        scanner.close();
    }

    private static boolean isUniqueElements(int[] array) {
        int length = array.length;
        boolean[] seen = new boolean[length];
        for (int value : array) {
            if (seen[value - 1]) {
                return false;
            }
            seen[value - 1] = true;
        }
        return true;
    }

    private static int countColumnRepeats(int[][] matrix) {
        int size = matrix.length;
        int repeats = 0;

        for (int col = 0; col < size; col++) {
            boolean[] seen = new boolean[size];
            for (int row = 0; row < size; row++) {
                if (seen[matrix[row][col] - 1]) {
                    repeats++;
                    break;
                }
                seen[matrix[row][col] - 1] = true;
            }
        }
        return repeats;
    }
}