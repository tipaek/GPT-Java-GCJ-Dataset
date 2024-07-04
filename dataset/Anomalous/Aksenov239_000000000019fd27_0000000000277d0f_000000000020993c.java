import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        new Solution().execute();
    }

    private BufferedReader bufferedReader;
    private StringTokenizer stringTokenizer;
    private PrintWriter printWriter;

    private String nextToken() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        }
        return stringTokenizer.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private void solve() throws IOException {
        int n = nextInt();
        int[][] matrix = new int[n][n];

        int trace = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = nextInt() - 1;
            }
            trace += matrix[i][i] + 1;
        }

        int duplicateRows = 0;
        int duplicateCols = 0;
        for (int i = 0; i < n; i++) {
            boolean[] rowCheck = new boolean[n];
            for (int j = 0; j < n; j++) {
                if (rowCheck[matrix[i][j]]) {
                    duplicateRows++;
                    break;
                }
                rowCheck[matrix[i][j]] = true;
            }

            boolean[] colCheck = new boolean[n];
            for (int j = 0; j < n; j++) {
                if (colCheck[matrix[j][i]]) {
                    duplicateCols++;
                    break;
                }
                colCheck[matrix[j][i]] = true;
            }
        }

        printWriter.println(trace + " " + duplicateRows + " " + duplicateCols);
    }

    private void execute() {
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            printWriter = new PrintWriter(System.out);

            int testCases = nextInt();
            for (int i = 0; i < testCases; i++) {
                printWriter.print(String.format("Case #%d: ", i + 1));
                solve();
            }
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}