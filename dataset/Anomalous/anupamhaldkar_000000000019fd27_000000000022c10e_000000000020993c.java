import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int d = 1; d <= n; d++) {
            int trace = 0;
            int a = sc.nextInt();
            int[][] matrix = new int[a][a];

            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 0; i < a; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < a; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                if (rowSet.size() < a) {
                    duplicateRows++;
                }
                if (colSet.size() < a) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + d + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}