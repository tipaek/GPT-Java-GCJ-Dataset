import java.util.*;
import java.io.*;

public class Solution implements Runnable {

    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedReader rd;
    private PrintWriter wr;

    private String nextToken() throws IOException {
        return rd.readLine();
    }

    private String calculateCase(int caseNumber) throws IOException {
        int n = Integer.parseInt(nextToken());
        int[][] matrix = new int[n][n];
        int trace = 0, repeatRow = 0, repeatCol = 0;

        for (int i = 0; i < n; i++) {
            String[] row = nextToken().split("\\s+");
            boolean[] used = new boolean[n];
            boolean isRepeated = false;

            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(row[j]);
                matrix[i][j] = val;

                if (i == j) {
                    trace += val;
                }

                if (used[val - 1]) {
                    isRepeated = true;
                }
                used[val - 1] = true;
            }

            if (isRepeated) {
                repeatRow++;
            }
        }

        for (int i = 0; i < n; i++) {
            boolean[] used = new boolean[n];
            boolean isRepeated = false;

            for (int j = 0; j < n; j++) {
                if (used[matrix[j][i] - 1]) {
                    isRepeated = true;
                    break;
                }
                used[matrix[j][i] - 1] = true;
            }

            if (isRepeated) {
                repeatCol++;
            }
        }

        return String.format("Case #%d: %d %d %d", caseNumber, trace, repeatRow, repeatCol);
    }

    private void solve() throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
        wr = new PrintWriter(System.out);

        int testCaseCount = Integer.parseInt(nextToken());

        for (int i = 0; i < testCaseCount; i++) {
            wr.println(calculateCase(i + 1));
        }

        rd.close();
        wr.close();
    }
}