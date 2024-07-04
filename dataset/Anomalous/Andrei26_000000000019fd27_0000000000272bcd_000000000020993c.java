import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            int lines = scanner.nextInt();
            int[][] matrix = new int[lines][lines];
            int diagSum = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Read matrix and calculate diagonal sum
            for (int row = 0; row < lines; row++) {
                for (int col = 0; col < lines; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        diagSum += matrix[row][col];
                    }
                }
            }

            // Check for duplicate elements in rows
            for (int row = 0; row < lines; row++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int col = 0; col < lines; col++) {
                    if (!rowSet.add(matrix[row][col])) {
                        hasDuplicate = true;
                    }
                }
                if (hasDuplicate) {
                    duplicateRows++;
                }
            }

            // Check for duplicate elements in columns
            for (int col = 0; col < lines; col++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int row = 0; row < lines; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        hasDuplicate = true;
                    }
                }
                if (hasDuplicate) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + diagSum + " " + duplicateRows + " " + duplicateCols);
        }
    }
}