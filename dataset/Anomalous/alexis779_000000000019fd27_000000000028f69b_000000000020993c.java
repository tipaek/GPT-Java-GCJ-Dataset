import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(bufferedReader.readLine().trim());
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] row = bufferedReader.readLine().trim().split(" ");
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }

            Result result = new Result(N, matrix);
            bufferedWriter.write(result.trace + " " + result.rowRepeats + " " + result.colRepeats);
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
    }
}

class Result {
    int N;
    int[][] matrix;
    int trace;
    int rowRepeats;
    int colRepeats;

    public Result(int N, int[][] matrix) {
        this.N = N;
        this.matrix = matrix;
        calculateTrace();
        calculateRowRepeats();
        calculateColRepeats();
    }

    private void calculateTrace() {
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }
    }

    private void calculateRowRepeats() {
        for (int i = 0; i < N; i++) {
            if (hasDuplicates(matrix[i])) {
                rowRepeats++;
            }
        }
    }

    private void calculateColRepeats() {
        for (int j = 0; j < N; j++) {
            int[] col = new int[N];
            for (int i = 0; i < N; i++) {
                col[i] = matrix[i][j];
            }
            if (hasDuplicates(col)) {
                colRepeats++;
            }
        }
    }

    private boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[N + 1];
        for (int num : array) {
            if (seen[num]) {
                return true;
            }
            seen[num] = true;
        }
        return false;
    }
}