import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] values = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(values[j]);
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", t, calculateTrace(matrix), countDuplicateRows(matrix), countDuplicateCols(matrix));
        }

        br.close();
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateRowCount = 0;
        for (int[] row : matrix) {
            HashSet<Integer> uniqueValues = new HashSet<>();
            for (int value : row) {
                if (!uniqueValues.add(value)) {
                    duplicateRowCount++;
                    break;
                }
            }
        }
        return duplicateRowCount;
    }

    private static int countDuplicateCols(int[][] matrix) {
        int duplicateColCount = 0;
        for (int col = 0; col < matrix.length; col++) {
            HashSet<Integer> uniqueValues = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                if (!uniqueValues.add(matrix[row][col])) {
                    duplicateColCount++;
                    break;
                }
            }
        }
        return duplicateColCount;
    }
}