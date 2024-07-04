import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                solve();
            }
        }, "1", 1 << 26).start();
    }

    static void solve() {
        FastReader fr = new FastReader();
        PrintWriter op = new PrintWriter(System.out);

        int T = fr.nextInt();
        for (int t = 1; t <= T; ++t) {
            op.print("Case #" + t + ": ");
            int n = fr.nextInt();
            int d = fr.nextInt();
            long[] a = new long[n];
            HashMap<Long, Integer> hm = new HashMap<>();

            for (int i = 0; i < n; ++i) {
                a[i] = fr.nextLong();
                hm.put(a[i], hm.getOrDefault(a[i], 0) + 1);
            }

            int maxFrequency = 0;
            for (int freq : hm.values()) {
                maxFrequency = Math.max(maxFrequency, freq);
            }

            if (maxFrequency >= d) {
                op.println(0);
            } else {
                if (d == 2) {
                    op.println(1);
                } else if (d == 3) {
                    boolean found = false;
                    long min = Long.MAX_VALUE, max = 0;

                    for (long id : hm.keySet()) {
                        if (id % 2 == 0 && hm.containsKey(id / 2)) {
                            found = true;
                        }
                    }

                    for (long id : hm.keySet()) {
                        if (hm.get(id) > 1) {
                            min = Math.min(min, id);
                        }
                        max = Math.max(max, id);
                    }

                    if (max > min) {
                        found = true;
                    }

                    if (found) {
                        op.println(1);
                    } else {
                        op.println(2);
                    }
                } else {
                    op.println(d - 1);
                }
            }
        }
        op.flush();
        op.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}