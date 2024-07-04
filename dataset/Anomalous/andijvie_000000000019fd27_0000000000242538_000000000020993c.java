import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gridCount = readInt(scanner);
        for (int caseNumber = 1; caseNumber <= gridCount; caseNumber++) {
            int size = readInt(scanner);
            int[][] matrix = readMatrix(scanner, size, size);
            System.out.println("Case #" + caseNumber + ": " + calculateTrace(matrix) + " " + countDuplicateRows(matrix) + " " + countDuplicateColumns(matrix));
        }
    }

    private static int readInt(Scanner scanner) {
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
            scanner.nextLine();
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

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateCount = 0;
        for (int row = 0; row < matrix.length; row++) {
            if (hasDuplicates(matrix[row])) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateCount = 0;
        for (int col = 0; col < matrix[0].length; col++) {
            int[] column = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
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