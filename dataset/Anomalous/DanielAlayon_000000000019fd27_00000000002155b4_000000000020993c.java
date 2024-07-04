import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Filling the matrix
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }

            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            // Check for duplicates in rows and columns
            for (int j = 0; j < n; j++) {
                if (hasDuplicates(matrix[j])) {
                    duplicateRows++;
                }
                
                int[] column = new int[n];
                for (int k = 0; k < n; k++) {
                    column[k] = matrix[k][j];
                }
                if (hasDuplicates(column)) {
                    duplicateColumns++;
                }
            }

            // Sum of diagonal elements
            for (int j = 0; j < n; j++) {
                diagonalSum += matrix[j][j];
            }

            // Output the results
            System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
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