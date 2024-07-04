import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();

            for (int t = 1; t <= testCases; t++) {
                int n = scanner.nextInt();
                int[][] matrix = new int[n][n];
                int trace = 0;
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = scanner.nextInt();
                        if (i == j) {
                            trace += matrix[i][j];
                        }
                    }
                }

                int rowCount = 0;
                int colCount = 0;

                for (int i = 0; i < n; i++) {
                    rowSet.clear();
                    colSet.clear();
                    for (int j = 0; j < n; j++) {
                        rowSet.add(matrix[i][j]);
                        colSet.add(matrix[j][i]);
                    }
                    if (rowSet.size() != n) {
                        rowCount++;
                    }
                    if (colSet.size() != n) {
                        colCount++;
                    }
                }

                System.out.println("Case #" + t + ": " + trace + " " + rowCount + " " + colCount);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}