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
        int trace = 0, maxRowRepeats = 0, maxColRepeats = 0;

        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];

            int rowRepeats = 0, colRepeats = 0;
            int[] rowCount = new int[N + 1];
            int[] colCount = new int[N + 1];

            for (int j = 0; j < N; j++) {
                rowCount[matrix[i][j]]++;
                colCount[matrix[j][i]]++;

                if (rowCount[matrix[i][j]] > 1) {
                    rowRepeats = Math.max(rowRepeats, rowCount[matrix[i][j]] - 1);
                }

                if (colCount[matrix[j][i]] > 1) {
                    colRepeats = Math.max(colRepeats, colCount[matrix[j][i]] - 1);
                }
            }

            maxRowRepeats = Math.max(maxRowRepeats, rowRepeats);
            maxColRepeats = Math.max(maxColRepeats, colRepeats);
        }

        int r = maxRowRepeats == 0 ? 0 : maxRowRepeats + 1;
        int c = maxColRepeats == 0 ? 0 : maxColRepeats + 1;
        System.out.println("Case #" + testCase + ": " + trace + " " + r + " " + c);
    }
}