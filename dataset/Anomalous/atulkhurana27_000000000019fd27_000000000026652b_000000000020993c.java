import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int len = scanner.nextInt();
            int trace = 0;

            int[][] matrix = new int[len][len];
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Reading the matrix and calculating the trace
            for (int row = 0; row < len; row++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int col = 0; col < len; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                    if (!rowSet.add(matrix[row][col]) && !rowHasDuplicate) {
                        rowHasDuplicate = true;
                        rowDuplicates++;
                    }
                }
            }

            // Checking for column duplicates
            for (int col = 0; col < len; col++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;
                for (int row = 0; row < len; row++) {
                    if (!colSet.add(matrix[row][col]) && !colHasDuplicate) {
                        colHasDuplicate = true;
                        colDuplicates++;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}