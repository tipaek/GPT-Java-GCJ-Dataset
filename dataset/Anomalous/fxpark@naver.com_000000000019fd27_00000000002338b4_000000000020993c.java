import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution1 implements Runnable {
    public static void main(String[] args) {
        new Thread(new Solution1()).start();
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
    private StringTokenizer tok;

    private String nextToken() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(rd.readLine());
        }
        return tok.nextToken();
    }

    private void solve() throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
        wr = new PrintWriter(System.out);
        int t = Integer.parseInt(nextToken());
        for (int i = 0; i < t; ++i) {
            String res = subsolve();
            wr.println(String.format("Case #%d: %s", i + 1, res));
        }
        rd.close();
        wr.close();
    }

    private String subsolve() throws IOException {
        int n = Integer.parseInt(nextToken());
        int k = 0, r = 0, c = 0;
        int[][] cTmp = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] rowCheck = new int[n];
            boolean rowRepeated = false;
            for (int j = 0; j < n; j++) {
                int v = Integer.parseInt(nextToken());

                // Calculate the trace
                if (i == j) k += v;

                // Check for row repetition
                if (rowCheck[v - 1] == 0) {
                    rowCheck[v - 1] = 1;
                } else {
                    rowRepeated = true;
                }

                // Mark the column presence
                cTmp[j][v - 1] = 1;
            }
            if (rowRepeated) r++;
        }

        for (int i = 0; i < n; i++) {
            boolean colRepeated = false;
            for (int j = 0; j < n; j++) {
                if (cTmp[i][j] == 0) {
                    colRepeated = true;
                    break;
                }
            }
            if (colRepeated) c++;
        }

        return String.format("%d %d %d", k, r, c);
    }
}