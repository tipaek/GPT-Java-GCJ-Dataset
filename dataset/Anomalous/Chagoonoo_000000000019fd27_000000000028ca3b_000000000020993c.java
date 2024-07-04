import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = sc.nextInt();
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", caseNum, trace, rowRepeats, colRepeats);
        }
    }
}