import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            // Read matrix and calculate diagonal sum
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += matrix[row][col];
                    }
                }
            }

            // Check rows for duplicates
            for (int row = 0; row < size; row++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int col = 0; col < size; col++) {
                    if (!rowSet.add(matrix[row][col])) {
                        hasDuplicate = true;
                    }
                }
                if (hasDuplicate) {
                    duplicateRows++;
                }
            }

            // Check columns for duplicates
            for (int col = 0; col < size; col++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int row = 0; row < size; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        hasDuplicate = true;
                    }
                }
                if (hasDuplicate) {
                    duplicateColumns++;
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}