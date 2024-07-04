import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = initializeScanner();

        int testCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < testCases; i++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = readMatrix(scanner, matrixSize);

            String result = processSingleCase(matrix);
            System.out.println(result);
        }
        scanner.close();
    }

    private static Scanner initializeScanner() throws Exception {
        if ("Alexey".equals(System.getProperty("user.name"))) {
            System.err.println("development mode, reading from file");
            return new Scanner(new FileInputStream("input.txt"));
        } else {
            return new Scanner(System.in);
        }
    }

    private static int[][] readMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            String[] rowValues = scanner.nextLine().split(" ");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = Integer.parseInt(rowValues[col]);
            }
        }
        return matrix;
    }

    private static String processSingleCase(int[][] matrix) {
        int trace = 0, rowRepeats = 0, colRepeats = 0;
        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];

            if (hasRepeats(matrix[i])) {
                rowRepeats++;
            }

            if (hasColumnRepeats(matrix, i)) {
                colRepeats++;
            }
        }
        System.err.println("test debug output");
        return trace + " " + rowRepeats + " " + colRepeats;
    }

    private static boolean hasRepeats(int[] array) {
        boolean[] seen = new boolean[array.length];
        for (int value : array) {
            if (seen[value - 1]) {
                return true;
            }
            seen[value - 1] = true;
        }
        return false;
    }

    private static boolean hasColumnRepeats(int[][] matrix, int colIndex) {
        boolean[] seen = new boolean[matrix.length];
        for (int[] row : matrix) {
            if (seen[row[colIndex] - 1]) {
                return true;
            }
            seen[row[colIndex] - 1] = true;
        }
        return false;
    }
}