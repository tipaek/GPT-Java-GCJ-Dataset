import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int cases = sc.nextInt();

        for (int i = 0; i < cases; i++) {
            int size = sc.nextInt();
            int[][] matrix = new int[size][size];

            // Fill the matrix
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = sc.nextInt();
                }
            }

            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int row = 0; row < size; row++) {
                if (hasDuplicates(matrix[row])) {
                    duplicateRows++;
                }

                int[] columnArray = new int[size];
                for (int col = 0; col < size; col++) {
                    columnArray[col] = matrix[col][row];
                }

                if (hasDuplicates(columnArray)) {
                    duplicateCols++;
                }

                diagonalSum += matrix[row][row];
            }

            System.out.printf("Case #%d: %d %d %d%n", i + 1, diagonalSum, duplicateRows, duplicateCols);
        }
    }

    public static boolean hasDuplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}