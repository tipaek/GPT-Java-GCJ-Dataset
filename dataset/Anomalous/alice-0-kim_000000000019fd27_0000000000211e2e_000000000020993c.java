import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            int[][] matrix = new int[size][size];

            // Read the matrix
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate trace, row duplicates, and column duplicates
            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }
                if (rowSet.size() < size) rowRepeats++;
                if (colSet.size() < size) colRepeats++;
                trace += matrix[i][i];
            }

            // Print the result for the current test case
            System.out.printf("Case #%d: %d %d %d\n", t, trace, rowRepeats, colRepeats);
        }

        scanner.close();
    }
}