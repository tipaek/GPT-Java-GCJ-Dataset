import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder result = new StringBuilder();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int trace = 0;
            int rowRepeats = 0, colRepeats = 0;
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
                    rowRepeats++;
                }
            }

            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() != n) {
                    colRepeats++;
                }
            }

            result.append(String.format("Case #%d: %d %d %d%n", caseNumber, trace, rowRepeats, colRepeats));
            caseNumber++;
        }

        System.out.print(result.toString());
        sc.close();
    }
}