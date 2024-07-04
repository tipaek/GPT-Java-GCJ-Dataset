import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int cases = sc.nextInt();
        
        for (int i = 0; i < cases; i++) {
            int size = sc.nextInt();
            long[][] matrix = new long[size][size];
            
            // Fill the matrix
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    matrix[j][k] = sc.nextLong();
                }
            }
            
            long diagonalSum = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            
            // Check for duplicates and calculate diagonal sum
            for (int j = 0; j < size; j++) {
                if (hasDuplicates(matrix[j])) {
                    rowDuplicates++;
                }
                
                long[] column = new long[size];
                for (int k = 0; k < size; k++) {
                    column[k] = matrix[k][j];
                }
                if (hasDuplicates(column)) {
                    colDuplicates++;
                }
                
                diagonalSum += matrix[j][j];
            }
            
            // Print the result for the current case
            System.out.printf("Case #%d: %d %d %d%n", (i + 1), diagonalSum, rowDuplicates, colDuplicates);
        }
    }

    private static boolean hasDuplicates(long[] array) {
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