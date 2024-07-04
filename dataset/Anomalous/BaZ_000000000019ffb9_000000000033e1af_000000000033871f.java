import java.io.*;
import java.util.*;

public class Solution {

    static MyScanner scan;
    static PrintWriter pw;
    static final long MOD = 1_000_000_007;
    static final long INF = 1_000_000_000_000_000_000L;
    static final long inf = 2_000_000_000;
    
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    solve();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }, "BaZ", 1 << 27).start();
    }

    static int[] c, parent, parent_edge_idx, ans;
    static ArrayList<Pair>[] adj;
    
    static void solve() throws IOException {
        initIo(false, "");
        int t = ni();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            pw.printf("Case #%d:", caseNum);
            int n = ni(), m = ni();
            c = new int[n + 1];
            parent = new int[n + 1];
            parent_edge_idx = new int[n + 1];
            adj = new ArrayList[n + 1];
            ans = new int[m + 1];
            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
                if (i == 1) continue;
                c[i] = ni();
            }
            for (int i = 1; i <= m; i++) {
                int u = ni(), v = ni();
                adj[u].add(new Pair(v, i));
                adj[v].add(new Pair(u, i));
            }

            int nodesSolved = 1;
            int[] time = new int[n + 1];
            Arrays.fill(parent, -1);
            parent[1] = 0;
            time[1] = 0;
            int tim = 0;
            int iters = 0;

            while (nodesSolved < n && iters < n) {
                ArrayList<Integer> thisIter = new ArrayList<>();
                for (int i = 2; i <= n; i++) {
                    if (c[i] < 0 && c[i] == -nodesSolved) {
                        thisIter.add(i);
                    }
                }

                if (thisIter.isEmpty()) {
                    int nextTime = Integer.MAX_VALUE;
                    for (int i = 2; i <= n; i++) {
                        if (c[i] < 0 || parent[i] != -1) continue;
                        nextTime = Math.min(nextTime, c[i]);
                    }
                    if (nextTime == Integer.MAX_VALUE) {
                        tim++;
                    } else {
                        tim = nextTime;
                    }

                    for (int i = 2; i <= n; i++) {
                        if (c[i] == tim) {
                            thisIter.add(i);
                        }
                    }
                } else {
                    tim++;
                }

                ArrayList<Pair> ansParIdx = new ArrayList<>();
                for (int e : thisIter) {
                    int p = -1, idx = -1;
                    for (Pair f : adj[e]) {
                        if (parent[f.x] != -1) {
                            p = f.x;
                            idx = f.y;
                        }
                    }
                    ansParIdx.add(new Pair(p, idx));
                }

                for (int i = 0; i < thisIter.size(); i++) {
                    int node = thisIter.get(i);
                    parent[node] = ansParIdx.get(i).x;
                    time[node] = tim;
                    ans[ansParIdx.get(i).y] = tim - time[ansParIdx.get(i).x];
                }
                nodesSolved += thisIter.size();
                iters++;
            }

            for (int i = 1; i <= m; i++) {
                if (ans[i] == 0) {
                    ans[i] = 1_000_000;
                }
                pw.print(ans[i] + " ");
            }
            pw.println();
        }
        pw.flush();
        pw.close();
    }

    static class Pair implements Comparable<Pair> {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pair other) {
            if (this.x != other.x) return this.x - other.x;
            return this.y - other.y;
        }

        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    static void initIo(boolean isFileIO, String suffix) throws IOException {
        scan = new MyScanner(isFileIO, suffix);
        if (isFileIO) {
            pw = new PrintWriter("/Users/amandeep/Desktop/output" + suffix + ".txt");
        } else {
            pw = new PrintWriter(System.out, true);
        }
    }

    static int ni() throws IOException {
        return scan.nextInt();
    }

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        MyScanner(boolean readingFromFile, String suffix) throws IOException {
            if (readingFromFile) {
                br = new BufferedReader(new FileReader("/Users/amandeep/Desktop/input" + suffix + ".txt"));
            } else {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}