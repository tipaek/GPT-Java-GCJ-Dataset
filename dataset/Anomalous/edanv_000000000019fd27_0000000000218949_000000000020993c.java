import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int cases = sc.nextInt();
        
        for (int i = 0; i < cases; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;
            int rowDuplicates = 0;
            int columnDuplicates = 0;

            // Fill the matrix
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }

            // Check for duplicates in rows and columns
            for (int j = 0; j < n; j++) {
                if (hasDuplicates(matrix[j])) {
                    rowDuplicates++;
                }
                int[] column = new int[n];
                for (int k = 0; k < n; k++) {
                    column[k] = matrix[k][j];
                }
                if (hasDuplicates(column)) {
                    columnDuplicates++;
                }
            }

            // Calculate the sum of the diagonal
            for (int j = 0; j < n; j++) {
                diagonalSum += matrix[j][j];
            }

            // Print the result for the current case
            System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
        }
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
}