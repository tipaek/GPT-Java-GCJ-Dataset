import java.util.*;
import java.io.*;

public class Solution {
    static PrintWriter out = new PrintWriter(System.out);
    static boolean flag = true;

    static void dfs(List<Integer>[] adjList, int node, int[] colors) {
        for (Integer neighbor : adjList[node]) {
            if (colors[neighbor] == -1) {
                colors[neighbor] = 1 - colors[node];
                dfs(adjList, neighbor, colors);
            } else if (colors[neighbor] == colors[node]) {
                flag = false;
                return;
            }
        }
    }

    static boolean testOverlap(int x1, int x2, int y1, int y2) {
        return (x1 >= y1 && x1 <= y2) ||
               (x2 >= y1 && x2 <= y2) ||
               (y1 >= x1 && y1 <= x2) ||
               (y2 >= x1 && y2 <= x2);
    }

    static void solve() throws Exception {
        int t = ni();
        for (int o = 1; o <= t; o++) {
            int n = ni();
            int[] start = new int[n];
            int[] end = new int[n];
            for (int i = 0; i < n; i++) {
                start[i] = ni() + 1;
                end[i] = ni();
            }

            List<Integer>[] adjList = new LinkedList[n];
            int[] colors = new int[n];
            Arrays.fill(colors, -1);

            for (int i = 0; i < n; i++) {
                adjList[i] = new LinkedList<>();
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (testOverlap(start[i], end[i], start[j], end[j])) {
                        adjList[i].add(j);
                        adjList[j].add(i);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (colors[i] == -1) {
                    colors[i] = 1;
                    dfs(adjList, i, colors);
                    if (!flag) break;
                }
            }

            if (!flag) {
                pn("Case #" + o + ": IMPOSSIBLE");
            } else {
                StringBuilder res = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    res.append(colors[i] == 1 ? 'J' : 'C');
                }
                pn("Case #" + o + ": " + res);
            }
            flag = true;
        }
        out.flush();
    }

    public static void main(String[] args) {
        new Thread(null, null, "Name", 99999999) {
            public void run() {
                try {
                    solve();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }.start();
    }

    static int ni() {
        return sc.nextInt();
    }

    static long nl() {
        return sc.nextLong();
    }

    static String ns() {
        return sc.nextLine();
    }

    static void p(Object o) {
        out.print(o);
    }

    static void pn(Object o) {
        out.println(o);
    }

    static FastReader sc = new FastReader();

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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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
    }
}