import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0, duplicateRows = 0, duplicateColumns = 0;

            // Read the matrix
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            // Calculate the trace
            for (int j = 0; j < size; j++) {
                trace += matrix[j][j];
            }

            // Check for duplicate values in rows
            for (int row = 0; row < size; row++) {
                if (hasDuplicates(matrix[row])) {
                    duplicateRows++;
                }
            }

            // Check for duplicate values in columns
            for (int col = 0; col < size; col++) {
                int[] columnArray = new int[size];
                for (int row = 0; row < size; row++) {
                    columnArray[row] = matrix[row][col];
                }
                if (hasDuplicates(columnArray)) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
        scanner.close();
    }

    private static boolean hasDuplicates(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}