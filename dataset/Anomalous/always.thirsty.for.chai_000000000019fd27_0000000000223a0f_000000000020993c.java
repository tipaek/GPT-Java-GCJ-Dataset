import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int originalTestCases = testCases;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int rowDuplicates = 0;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (rowSet.contains(matrix[i][j])) {
                        rowDuplicates++;
                        break;
                    } else {
                        rowSet.add(matrix[i][j]);
                    }
                }
            }

            int columnDuplicates = 0;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> columnSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (columnSet.contains(matrix[j][i])) {
                        columnDuplicates++;
                        break;
                    } else {
                        columnSet.add(matrix[j][i]);
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", (originalTestCases - testCases), trace, rowDuplicates, columnDuplicates);
        }
    }
}