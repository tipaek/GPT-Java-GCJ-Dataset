import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        String[] tokens;

        int T = Integer.parseInt(reader.readLine().trim());

        for (int t = 1; t <= T; t++) {
            output.append("Case #").append(t).append(": ");

            int N = Integer.parseInt(reader.readLine().trim());
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                tokens = reader.readLine().trim().split(" ");

                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(tokens[j]);
                }
            }

            output.append(getTrace(N, matrix)).append(" ").append(getWrongRows(N, matrix)).append(" ").append(getWrongCols(N, matrix)).append("\n");
        }

        System.out.print(output);
    }

    private static int getWrongRows(int n, int[][] matrix) {
        int wrongRows = 0;

        for (int i = 0; i < n; i++) {
            boolean[] flags = new boolean[n + 1];

            for (int j = 0; j < n; j++) {
                if (flags[matrix[i][j]]) {
                    wrongRows++;
                    break;
                }

                flags[matrix[i][j]] = true;
            }
        }

        return wrongRows;
    }

    private static int getWrongCols(int n, int[][] matrix) {
        int wrongCols = 0;

        for (int i = 0; i < n; i++) {
            boolean[] flags = new boolean[n + 1];

            for (int j = 0; j < n; j++) {
                if (flags[matrix[j][i]]) {
                    wrongCols++;
                    break;
                }

                flags[matrix[j][i]] = true;
            }
        }

        return wrongCols;
    }

    private static int getTrace(int n, int[][] matrix) {
        int trace = 0;

        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        return trace;
    }
}
