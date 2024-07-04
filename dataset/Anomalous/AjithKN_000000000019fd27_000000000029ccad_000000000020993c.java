import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<int[][]> matrices = new ArrayList<>();
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int dimension = scanner.nextInt();
            int[][] matrix = new int[dimension][dimension];
            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            matrices.add(matrix);
        }

        for (int caseNumber = 1; caseNumber <= matrices.size(); caseNumber++) {
            int[][] matrix = matrices.get(caseNumber - 1);
            int n = matrix.length;
            int trace = 0, duplicateRows = 0, duplicateColumns = 0;

            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                boolean[] colCheck = new boolean[n + 1];
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }

                    if (!rowHasDuplicate) {
                        if (rowCheck[matrix[i][j]]) {
                            duplicateRows++;
                            rowHasDuplicate = true;
                        } else {
                            rowCheck[matrix[i][j]] = true;
                        }
                    }

                    if (!colHasDuplicate) {
                        if (colCheck[matrix[j][i]]) {
                            duplicateColumns++;
                            colHasDuplicate = true;
                        } else {
                            colCheck[matrix[j][i]] = true;
                        }
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateColumns + " " + duplicateRows);
        }
    }
}