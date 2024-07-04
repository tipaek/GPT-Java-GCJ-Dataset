import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    rowSet.add(matrix[i][j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                if (rowSet.size() != n) {
                    duplicateRows++;
                }
            }

            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() != n) {
                    duplicateCols++;
                }
            }

            sb.append(String.format("Case #%d: %d %d %d%n", caseNumber, trace, duplicateRows, duplicateCols));
            caseNumber++;
        }

        System.out.print(sb.toString());
        sc.close();
    }
}