import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;

    private String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private void solve() throws IOException {
        int n = nextInt();
        boolean[][] schedule = new boolean[24 * 60 + 1][2];
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int start = nextInt();
            int end = nextInt();
            boolean[] taken = new boolean[2];

            for (int j = start; j < end; j++) {
                for (int k = 0; k < 2; k++) {
                    taken[k] |= schedule[j][k];
                }
            }

            if (taken[0] && taken[1]) {
                out.println("IMPOSSIBLE");
                return;
            }

            int assign = taken[0] ? 1 : 0;
            answer.append(assign == 0 ? "C" : "J");

            for (int j = start; j < end; j++) {
                schedule[j][assign] = true;
            }
        }

        out.println(answer.toString());
    }

    private void run() {
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