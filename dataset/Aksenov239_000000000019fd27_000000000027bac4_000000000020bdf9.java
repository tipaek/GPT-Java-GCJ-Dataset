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
        boolean[][] a = new boolean[24 * 60 + 1][2];

        String answer = "";
        boolean bad = false;
        for (int i = 0; i < n; i++) {
            int x = nextInt();
            int y = nextInt();
            boolean[] taken = new boolean[2];
            for (int j = x; j < y; j++) {
                for (int k = 0; k < 2; k++) {
                    taken[k] |= a[j][k];
                }
            }
            if (taken[0] && taken[1]) {
                bad = true;
            }
            int take = taken[0] ? 1 : 0;
            answer += taken[0] ? "C" : "J";
            for (int j = x; j < y; j++) {
                a[j][take] = true;
            }
        }
        if (bad) {
            out.println("IMPOSSIBLE");
        } else {
            out.println(answer);
        }
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
