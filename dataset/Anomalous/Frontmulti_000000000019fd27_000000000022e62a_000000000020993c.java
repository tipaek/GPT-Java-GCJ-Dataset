import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, N;
    static int[][] matrix;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(reader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(reader.readLine());
            matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            solve(testCase);
        }
        reader.close();
    }

    private static void solve(int testCase) {
        int diagonalSum = 0, rowDuplicates = 0, colDuplicates = 0;

        for (int i = 0; i < N; i++) {
            int[] rowCheck = new int[N + 1];
            int[] colCheck = new int[N + 1];
            boolean rowHasDuplicates = false, colHasDuplicates = false;

            for (int j = 0; j < N; j++) {
                if (i == j) {
                    diagonalSum += matrix[i][j];
                }

                rowCheck[matrix[i][j]]++;
                colCheck[matrix[j][i]]++;

                if (rowCheck[matrix[i][j]] > 1) {
                    rowHasDuplicates = true;
                }
                if (colCheck[matrix[j][i]] > 1) {
                    colHasDuplicates = true;
                }
            }

            if (rowHasDuplicates) {
                rowDuplicates++;
            }
            if (colHasDuplicates) {
                colDuplicates++;
            }
        }

        System.out.println("Case #" + testCase + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
    }
}