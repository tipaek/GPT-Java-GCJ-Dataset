import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        ScanWrapper input = new ScanWrapper();
        int testsNum = input.nextInt();
        for (int testIndex = 0; testIndex < testsNum; testIndex++) {
            int matrixSize = input.nextInt();
            int sum = 0;
            int duplicatedRows = 0;
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int row = 0; row < matrixSize; row++) {
                input.readRow(matrix[row]);
                sum += matrix[row][row];
                if (rowHasDuplicates(matrix[row])) {
                    duplicatedRows++;
                }
            }
            int duplicatedColumns = 0;
            for (int column = 0; column < matrixSize; column++) {
                if (columnHasDuplicates(matrix, column)) {
                    duplicatedColumns++;
                }
            }
            System.out.println("Case #" + (testIndex + 1) + ": " + sum + " " + duplicatedRows + " " + duplicatedColumns);
        }

    }

    static boolean rowHasDuplicates(final int[] numbers) {
        boolean[] bitmap = new boolean[numbers.length + 1];
        for (int item : numbers)
            if (!(bitmap[item] ^= true)) return true;
        return false;
    }

    static boolean columnHasDuplicates(final int[][] matrix, int column) {
        boolean[] bitmap = new boolean[matrix.length + 1];
        for (int[] rows : matrix)
            if (!(bitmap[rows[column]] ^= true)) return true;
        return false;
    }

    private static class ScanWrapper {

        private final Scanner scanner;

        ScanWrapper() {
            scanner = new Scanner(System.in);
        }

        int nextInt() {
            return Integer.parseInt(scanner.nextLine());
        }

        void readRow(int[] emptyRow) {
            String[] strings = scanner.nextLine().split(" ");
            int i = 0;
            for (String s : strings) {
                emptyRow[i++] = Integer.parseInt(s);
            }
        }

    }
    
}
