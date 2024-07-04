import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Matrix {

    public static void main(String[] args) {
        int[][] matrix = initializeMatrix();
        // Uncomment the next line to print the matrix
        // printMatrix(matrix);
        if (isLatinSquare(matrix)) {
            System.out.println("This is a Latin Square");
        } else {
            System.out.println("This is not a Latin Square");
        }
    }

    public static boolean isLatinSquare(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            // Check for duplicates in each row
            if (hasDuplicates(matrix[i])) {
                return false;
            }

            // Create and check for duplicates in each column
            int[] column = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                column[j] = matrix[j][i];
            }
            if (hasDuplicates(column)) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasDuplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int[][] initializeMatrix() {
        int[][] matrix = null;
        try (Scanner scanner = new Scanner(new File("matrix.txt"))) {
            int numRows = Integer.parseInt(scanner.nextLine());
            matrix = new int[numRows][];
            parseMatrixData(matrix, scanner);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return matrix;
    }

    public static void parseMatrixData(int[][] matrix, Scanner scanner) {
        for (int r = 0; r < matrix.length; r++) {
            String[] lineData = scanner.nextLine().split(" ");
            matrix[r] = new int[lineData.length];
            for (int c = 0; c < lineData.length; c++) {
                matrix[r][c] = Integer.parseInt(lineData[c]);
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}