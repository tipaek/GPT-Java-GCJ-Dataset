import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static int[] vestiguium(int[][] matrix, int N) {
        int[] output = new int[3];

        if (matrix == null || N == 0) return output;

        for (int i = 0; i < N; i++) {
            output[0] = matrix[i][i] + output[0];

            boolean[] rows = new boolean[N+1];
            boolean[] cols = new boolean[N+1];
            boolean rowHasDup = false;
            boolean colHasDup = false;
            for (int j = 0; j < N; j++) {
                if (!rowHasDup && rows[matrix[i][j]]) {
                    output[1]++;
                    rowHasDup = true;
                }
                if (!colHasDup && cols[matrix[j][i]]) {
                    output[2]++;
                    colHasDup = true;
                }
                rows[matrix[i][j]] = true;
                cols[matrix[j][i]] = true;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testSize = Integer.valueOf(in.nextInt()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= testSize; ++i) {
            int N = Integer.valueOf(in.nextInt());

            int[][] matrix = new int[N][N];
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = in.nextInt();
                }
            }

            int[] output = vestiguium(matrix, N);
            StringBuilder builder = new StringBuilder();
            builder.append("Case #" + i + ": ");

            for (int num : output)
                builder.append(num + " ");
            System.out.println(builder.toString().trim());
        }
    }
}