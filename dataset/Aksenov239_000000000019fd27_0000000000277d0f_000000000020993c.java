import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by vaksenov on 04.04.2020.
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;

    public String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public void solve() throws IOException {
        int n = nextInt();
        int[][] a = new int[n][n];

        int trace = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = nextInt() - 1;
            }
            trace += a[i][i] + 1;
        }

        int rows = 0;
        int cols = 0;
        for (int i = 0; i < n; i++) {
            boolean[] has = new boolean[n];
            for (int j = 0; j < n; j++) {
                if (has[a[i][j]]) {
                    rows++;
                    break;
                }
                has[a[i][j]] = true;
            }
            has = new boolean[n];
            for (int j = 0; j < n; j++) {
                if (has[a[j][i]]) {
                    cols++;
                    break;
                }
                has[a[j][i]] = true;
            }
        }

        out.println(trace + " " + rows + " " + cols);
    }

    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            int t = nextInt();
            for (int i = 0; i < t; i++) {
                out.print(String.format("Case #%d: ", i + 1));
                solve();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
