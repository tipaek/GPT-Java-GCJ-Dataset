import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Comparator;

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

        int t = fr.nextInt();
        for (int cs = 1; cs <= t; ++cs) {
            int n = fr.nextInt();
            int[][] se = new int[n][3];
            int[] sl = new int[n];
            PriorityQueue<nd> q = new PriorityQueue<>(new cmp());

            for (int i = 0; i < n; ++i) {
                se[i][0] = fr.nextInt();
                se[i][1] = fr.nextInt();
                se[i][2] = i;
            }

            sort(se, 0, n - 1);
            q.add(new nd(se[0][1], 0));
            sl[se[0][2]] = 0;

            for (int i = 1; i < n; ++i) {
                nd dm = q.peek();
                if (dm.end > se[i][0]) {
                    q.add(new nd(se[i][1], q.size()));
                    sl[se[i][2]] = q.size() - 1;
                } else {
                    dm = q.poll();
                    q.add(new nd(se[i][1], dm.typ));
                    sl[se[i][2]] = dm.typ;
                }
            }

            if (q.size() > 2) {
                op.println("Case #" + cs + ": IMPOSSIBLE");
            } else {
                op.print("Case #" + cs + ": ");
                for (int i = 0; i < n; ++i) {
                    op.print(sl[i] == 0 ? 'C' : 'J');
                }
                op.println();
            }
            q.clear();
        }
        op.flush();
        op.close();
    }

    public static void sort(int[][] arr, int l, int u) {
        if (l < u) {
            int m = (l + u) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, u);
            merge(arr, l, m, u);
        }
    }

    public static void merge(int[][] arr, int l, int m, int u) {
        int[][] low = new int[m - l + 1][3];
        int[][] upr = new int[u - m][3];

        for (int i = l; i <= m; i++) {
            System.arraycopy(arr[i], 0, low[i - l], 0, 3);
        }

        for (int i = m + 1; i <= u; i++) {
            System.arraycopy(arr[i], 0, upr[i - m - 1], 0, 3);
        }

        int i = l, j = 0, k = 0;
        while (j < low.length && k < upr.length) {
            if (low[j][0] < upr[k][0] || (low[j][0] == upr[k][0] && low[j][1] <= upr[k][1])) {
                System.arraycopy(low[j++], 0, arr[i++], 0, 3);
            } else {
                System.arraycopy(upr[k++], 0, arr[i++], 0, 3);
            }
        }

        while (j < low.length) {
            System.arraycopy(low[j++], 0, arr[i++], 0, 3);
        }

        while (k < upr.length) {
            System.arraycopy(upr[k++], 0, arr[i++], 0, 3);
        }
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

    static class nd {
        int end, typ;

        nd(int x, int y) {
            end = x;
            typ = y;
        }
    }

    static class cmp implements Comparator<nd> {
        public int compare(nd a, nd b) {
            return Integer.compare(a.end, b.end);
        }
    }
}