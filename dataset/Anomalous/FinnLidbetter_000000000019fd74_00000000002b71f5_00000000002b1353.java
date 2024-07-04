import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private static final int MAX = 501;
    private static final long[][] comb = new long[MAX][MAX];

    static {
        for (int i = 0; i < MAX; i++) {
            comb[i][i] = 1;
            comb[i][0] = 1;
        }
        for (int i = 2; i < MAX; i++) {
            for (int j = 1; j < MAX - 1; j++) {
                comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int nTests = Integer.parseInt(br.readLine());
        for (int test = 0; test < nTests; test++) {
            long target = Long.parseLong(br.readLine());
            sb.append(String.format("Case #%d:\n", test + 1));

            long sum = 0;
            int row = 0;
            int col = 0;
            int nMoves = 0;
            int maxMoves = 500;

            while (sum != target) {
                sum += comb[row][col];
                sb.append(String.format("%d %d\n", row + 1, col + 1));

                long diff = target - sum;
                int targetCol = determineTargetCol(diff, row, col, maxMoves, nMoves);

                if (col == targetCol || col >= row) {
                    row++;
                } else if (col < targetCol) {
                    col++;
                } else {
                    col--;
                }
                nMoves++;
            }
        }
        System.out.print(sb);
    }

    private static int determineTargetCol(long diff, int row, int col, int maxMoves, int nMoves) {
        if (diff < maxMoves - nMoves) {
            return 0;
        } else if (diff > row * comb[row][col]) {
            return 5;
        } else if (Math.sqrt(diff) < maxMoves - nMoves - 10) {
            return 1;
        } else if (Math.pow(diff, 1 / 3.0) < maxMoves - nMoves - 20) {
            return 2;
        } else if (Math.pow(diff, 1 / 4.0) < maxMoves - nMoves - 20) {
            return 3;
        }
        return 0;
    }
}