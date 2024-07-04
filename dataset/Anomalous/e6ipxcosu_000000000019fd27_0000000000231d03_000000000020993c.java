import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[101][101];

        for (int i = 1; i <= testCases; i++) {
            int n = Integer.parseInt(scanner.nextLine());

            // Read the matrix
            for (int row = 0; row < n; row++) {
                String[] elements = scanner.nextLine().split(" ");
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = Integer.parseInt(elements[col]);
                }
            }

            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Calculate the trace
            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];
            }

            // Check for row repeats
            for (int row = 0; row < n; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    rowSet.add(matrix[row][col]);
                }
                if (rowSet.size() != n) {
                    rowRepeats++;
                }
            }

            // Check for column repeats
            for (int col = 0; col < n; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    colSet.add(matrix[row][col]);
                }
                if (colSet.size() != n) {
                    colRepeats++;
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + i + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}