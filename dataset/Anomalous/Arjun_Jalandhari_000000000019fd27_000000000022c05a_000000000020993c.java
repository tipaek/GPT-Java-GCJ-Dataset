import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int z = 0; z < T; z++) {
            int N = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[N][N];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < N; i++) {
                String[] values = reader.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(values[j]);
                }
            }

            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
                if (hasDuplicates(matrix[i])) {
                    rowRepeats++;
                }
                if (hasDuplicates(getColumn(matrix, i))) {
                    colRepeats++;
                }
            }

            result.append("Case #")
                  .append(z + 1)
                  .append(": ")
                  .append(trace)
                  .append(" ")
                  .append(rowRepeats)
                  .append(" ")
                  .append(colRepeats)
                  .append("\n");
        }

        System.out.print(result.toString().trim());
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int num : array) {
            if (seen[num]) {
                return true;
            }
            seen[num] = true;
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }
}