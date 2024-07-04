import java.util.Scanner;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int trace = 0, duplicateRows = 0, duplicateColumns = 0;
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    int num = scanner.nextInt();
                    if (i == j) {
                        trace += num;
                    }
                    rowSet.add(num);
                    matrix[i][j] = num;
                }
                if (rowSet.size() != n) {
                    duplicateRows++;
                }
            }

            for (int j = 0; j < n; j++) {
                HashSet<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    columnSet.add(matrix[i][j]);
                }
                if (columnSet.size() != n) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}