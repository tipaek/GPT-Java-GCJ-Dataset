import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numCases = scanner.nextInt();

        for (int i = 0; i < numCases; ++i) {
            final int size = scanner.nextInt();
            final int[][] matrix = readMatrix(size, scanner);

            int trace = 0;
            for (int j = 0; j < size; ++j) {
                trace += matrix[j][j];
            }

            int numRepValRows = 0;
            for (int row = 0; row < size; ++row) {
                final Set<Integer> rowValues = new HashSet<>();
                for (int col = 0; col < size; ++col) {
                    final boolean added = rowValues.add(matrix[row][col]);
                    if (!added) { // then contains repeated value
                        numRepValRows++;
                        break; // no need to check this row further
                    }
                }
            }

            int numRepValColumns = 0;
            for (int col = 0; col < size; ++col) {
                final HashSet<Integer> colValues = new HashSet<>();
                for (int row = 0; row < size; ++row) {
                    final boolean added = colValues.add(matrix[row][col]);
                    if (!added) { // then contains repeated value
                        numRepValColumns++;
                        break; // no need to check this row further
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + numRepValRows + " " + numRepValColumns);
        }
    }

    private static int[][] readMatrix(int size, Scanner scanner) {
        final int[][] matrix = new int[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }
}
