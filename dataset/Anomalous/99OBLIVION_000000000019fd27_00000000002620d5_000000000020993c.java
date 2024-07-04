import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = Integer.parseInt(input.nextLine());
        String[] results = new String[t];

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = Integer.parseInt(input.nextLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] line = input.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }

            results[caseNum - 1] = analyzeLatinSquare(caseNum, n, matrix);
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String analyzeLatinSquare(int caseNum, int n, int[][] matrix) {
        int trace = 0;
        int repeatedRows = 0;
        int repeatedCols = 0;

        // Calculate trace
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        // Check for repeated numbers in rows
        for (int i = 0; i < n; i++) {
            if (hasRepeats(matrix[i])) {
                repeatedRows++;
            }
        }

        // Check for repeated numbers in columns
        for (int j = 0; j < n; j++) {
            int[] col = new int[n];
            for (int i = 0; i < n; i++) {
                col[i] = matrix[i][j];
            }
            if (hasRepeats(col)) {
                repeatedCols++;
            }
        }

        return String.format("Case #%d: %d %d %d", caseNum, trace, repeatedRows, repeatedCols);
    }

    private static boolean hasRepeats(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }
}