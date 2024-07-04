import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(f.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            final int N = Integer.parseInt(f.readLine());
            int trace = 0;
            final int[][] square = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                for (int j = 0; j < N; j++) {
                    square[i][j] = Integer.parseInt(st.nextToken());
                    if (i == j) {
                        trace += square[i][j];
                    }
                }
            }
            final int condensed = numRepeats(N, square);
            final int numRows = condensed / (N + 1);
            final int numCols = condensed % (N + 1);

            System.out.printf("Case #%d: %d %d %d\n", testCase + 1, trace, numRows, numCols);
        }
    }

    public static int numRepeats(final int N, final int[][] square) {
        boolean[][] seen = new boolean[N][N];
        int numRows = 0, numCols = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (seen[i][square[i][j] - 1]) {
                    numRows += 1;
                    break;
                }
                seen[i][square[i][j] - 1] = true;
            }
        }
        seen = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (seen[i][square[j][i] - 1]) {
                    numCols += 1;
                    break;
                }
                seen[i][square[j][i] - 1] = true;
            }
        }
        return numRows * (N + 1) + numCols;
    }
}