import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();

        for (int i = 0; i < numCases; i++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Read matrix and calculate diagonal sum
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += matrix[row][col];
                    }
                }
            }

            // Check for duplicate elements in rows
            for (int row = 0; row < size; row++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicates = false;
                for (int col = 0; col < size; col++) {
                    if (!rowSet.add(matrix[row][col])) {
                        hasDuplicates = true;
                    }
                }
                if (hasDuplicates) {
                    duplicateRows++;
                }
            }

            // Check for duplicate elements in columns
            for (int col = 0; col < size; col++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasDuplicates = false;
                for (int row = 0; row < size; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        hasDuplicates = true;
                    }
                }
                if (hasDuplicates) {
                    duplicateCols++;
                }
            }

            // Print result for the current case
            System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }
}