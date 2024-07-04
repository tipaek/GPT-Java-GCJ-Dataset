import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
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

    public class Time implements Comparable<Time> {
        int c, e;
        int id;

        public Time(int c, int e, int id) {
            this.c = c;
            this.e = e;
            this.id = id;
        }

        public int compareTo(Time time) {
            return c - time.c;
        }
    }

    public void solve() throws IOException {
        int n = nextInt();

        Time[] time = new Time[n];
        for (int i = 0; i < n; i++) {
            time[i] = new Time(nextInt(), nextInt(), i);
        }

        char[] ans = new char[n];
        Arrays.sort(time);
        int[] last = {-1, -1};
        for (int i = 0; i < n; i++) {
             if (last[0] <= time[i].c) {
                 last[0] = time[i].e;
                 ans[time[i].id] = 'C';
             } else if (last[1] <= time[i].c) {
                 last[1] = time[i].e;
                 ans[time[i].id] = 'J';
             } else {
                 out.println("IMPOSSIBLE");
                 return;
             }
        }
        out.println(new String(ans));
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
