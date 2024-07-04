import java.util.*;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            System.out.print("Case #" + testCase + ": ");
            processTestCase(scanner);
        }
    }

    private static void processTestCase(Scanner scanner) {
        int trace = 0, rowDuplicates = 0, columnDuplicates = 0;
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
                rowDuplicates++;
            }
        }

        for (int col = 0; col < matrixSize; col++) {
            if (hasColumnDuplicates(matrix, col)) {
                columnDuplicates++;
            }
        }

        System.out.println(trace + " " + rowDuplicates + " " + columnDuplicates);
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int element : array) {
            if (!uniqueElements.add(element)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasColumnDuplicates(int[][] matrix, int columnIndex) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int[] row : matrix) {
            if (!uniqueElements.add(row[columnIndex])) {
                return true;
            }
        }
        return false;
    }
}