import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int repeatingRows = 0;
            int repeatingColumns = 0;

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != n) {
                    repeatingRows++;
                }
            }

            for (int j = 0; j < n; j++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    columnSet.add(matrix[i][j]);
                }
                if (columnSet.size() != n) {
                    repeatingColumns++;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + repeatingRows + " " + repeatingColumns);
        }

        scanner.close();
    }
}