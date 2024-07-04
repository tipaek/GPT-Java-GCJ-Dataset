import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<int[][]> matrices = new ArrayList<>();
        int numTestCases = scanner.nextInt();

        for (int t = 0; t < numTestCases; t++) {
            int dimension = scanner.nextInt();
            int[][] matrix = new int[dimension][dimension];
            for (int row = 0; row < dimension; row++) {
                for (int col = 0; col < dimension; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            matrices.add(matrix);
        }

        for (int t = 0; t < matrices.size(); t++) {
            int[][] matrix = matrices.get(t);
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (int i = 0; i < matrix.length; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < matrix[i].length; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }
                if (rowSet.size() < matrix.length) {
                    duplicateRows++;
                }
                if (colSet.size() < matrix[i].length) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}