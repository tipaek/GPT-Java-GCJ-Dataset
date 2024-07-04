import java.io.*;
import java.util.*;

public class Solution {
    private static final long MOD = 1000000007;
    private static final int OFFSET = -1000000000;
    private static PrintWriter out;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = sc.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            out.print("Case #" + tt + ": ");
            int C = sc.nextInt();
            int D = sc.nextInt();

            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            int[] order = new int[C + 1];
            int[] time = new int[C + 1];
            Arrays.fill(order, -1);
            Arrays.fill(time, -1);

            ArrayList<Integer> times = new ArrayList<>();
            times.add(0);
            order[1] = time[1] = 0;

            int[] res = new int[D];
            int[] cnt = new int[C + 10];
            int max = 0;

            for (int i = 2; i <= C; i++) {
                int tmp = sc.nextInt();
                if (tmp < 0) {
                    order[i] = -tmp;
                    cnt[-tmp]++;
                    if (-tmp > max) max = -tmp;
                } else {
                    time[i] = tmp;
                    times.add(tmp);
                }
            }

            for (int i = 1; i <= max; i++) {
                if (cnt[i] > 0) {
                    Collections.sort(times);
                    int newTime = times.get(i - 1) + 1;
                    for (int j = 0; j < cnt[i]; j++) {
                        times.add(newTime);
                    }
                    for (int j = 1; j <= C; j++) {
                        if (order[j] == i) {
                            time[j] = newTime;
                        }
                    }
                }
            }

            for (int i = 0; i < D; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                res[i] = Math.max(1, Math.abs(time[u] - time[v]));
                out.print(res[i] + " ");
            }
            out.println();
        }
        out.close();
    }

    private static class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}