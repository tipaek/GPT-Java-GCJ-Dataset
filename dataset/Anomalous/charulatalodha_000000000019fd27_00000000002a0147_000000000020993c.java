import java.util.HashSet;
import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            result.append(helper(matrix, t, trace));
        }

        System.out.print(result.toString());
    }

    private static String helper(int[][] matrix, int caseNumber, int trace) {
        int n = matrix.length;
        int rowRepeats = 0, colRepeats = 0;

        for (int i = 0; i < n; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();

            for (int j = 0; j < n; j++) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }

            if (rowSet.size() != n) {
                rowRepeats++;
            }

            if (colSet.size() != n) {
                colRepeats++;
            }
        }

        return String.format("Case #%d: %d %d %d%n", caseNumber, trace, rowRepeats, colRepeats);
    }
}