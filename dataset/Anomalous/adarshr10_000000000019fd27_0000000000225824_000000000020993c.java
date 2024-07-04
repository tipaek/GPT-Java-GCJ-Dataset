import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[col][row] = scanner.nextInt();
                }
            }
            String result = solve(matrix);
            System.out.printf("Case #%d: %s %s %s%n", caseNum, result.charAt(0), result.charAt(1), result.charAt(2));
        }
    }

    private static String solve(int[][] matrix) {
        int n = matrix.length;
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowDuplicates++;
                    break;
                }
                if (!colSet.add(matrix[j][i])) {
                    colDuplicates++;
                    break;
                }
            }
        }

        return String.format("%d%d%d", trace, rowDuplicates, colDuplicates);
    }
}