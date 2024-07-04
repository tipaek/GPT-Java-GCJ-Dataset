import java.util.*;

public class Solution {

    public static void analyzeMatrix(int[][] matrix, int n, int caseNumber) {
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;

        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];

            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();

            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowDuplicates++;
                    break;
                }
            }

            for (int j = 0; j < n; j++) {
                if (!colSet.add(matrix[j][i])) {
                    colDuplicates++;
                    break;
                }
            }
        }

        System.out.format("Case #%d: %d %d %d\n", caseNumber, trace, rowDuplicates, colDuplicates);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                }
            }

            analyzeMatrix(matrix, n, i);
        }

        sc.close();
    }
}