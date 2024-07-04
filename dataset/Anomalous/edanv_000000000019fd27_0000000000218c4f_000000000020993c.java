import java.util.Scanner;

public class Solution {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int cases = sc.nextInt();
        
        for (int i = 0; i < cases; i++) {
            int size = sc.nextInt();
            int[][] matrix = new int[size][size];

            // Fill the matrix
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }

            int diagonalSum = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Check rows and columns for duplicates and calculate the diagonal sum
            for (int j = 0; j < size; j++) {
                if (hasDuplicates(matrix[j])) {
                    rowDuplicates++;
                }
                
                int[] column = new int[size];
                for (int k = 0; k < size; k++) {
                    column[k] = matrix[k][j];
                }
                if (hasDuplicates(column)) {
                    colDuplicates++;
                }
                
                diagonalSum += matrix[j][j];
            }

            // Print the result
            System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
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