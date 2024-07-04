import java.io.*;
import java.util.*;

class Solution {

    private static final long MOD = 1000000007L;
    private static final long MOD1 = 163577857L;
    private static final int MAXN = 100007;
    private static final int MAXLN = 17;

    private InputStream is;
    private PrintWriter out;
    private String INPUT = "";

    private int[] depth;
    private int[][] par;
    private List<Integer>[] adj;
    private int n;

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    private void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        long startTime = System.currentTimeMillis();
        solve();
        out.flush();
        if (!INPUT.isEmpty()) {
            System.out.println((System.currentTimeMillis() - startTime) + "ms");
        }
    }

    private void solve() throws Exception {
        int t = ni();
        for (int i = 1; i <= t; i++) {
            int x = ni();
            int y = ni();
            String s = ns();
            int count = 0;
            boolean possible = false;

            for (int j = 0; j < s.length(); j++) {
                switch (s.charAt(j)) {
                    case 'E':
                        x++;
                        break;
                    case 'N':
                        y++;
                        break;
                    case 'W':
                        x--;
                        break;
                    case 'S':
                        y--;
                        break;
                }
                count++;
                if (count >= distance(x, y)) {
                    possible = true;
                    out.println("Case #" + i + ": " + count);
                    break;
                }
            }
            if (!possible) {
                out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }

    private int distance(int a, int b) {
        return Math.abs(a) + Math.abs(b);
    }

    private void initialize(int n) {
        depth = new int[MAXN];
        par = new int[MAXLN][MAXN];
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    private void addEdge(int a, int b) {
        adj[a].add(b);
        adj[b].add(a);
    }

    private void dfs(int cur, int prev, int _depth) {
        depth[cur] = _depth;
        par[0][cur] = prev;
        for (int next : adj[cur]) {
            if (next != prev) {
                dfs(next, cur, _depth + 1);
            }
        }
    }

    private void LCAPreprocess() {
        for (int i = 1; i < MAXLN; i++) {
            for (int j = 0; j < n; j++) {
                if (par[i - 1][j] != -1) {
                    par[i][j] = par[i - 1][par[i - 1][j]];
                }
            }
        }
    }

    private int LCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];
        for (int i = 0; i < MAXLN; i++) {
            if (((diff >> i) & 1) == 1) {
                u = par[i][u];
            }
        }

        if (u == v) return u;

        for (int i = MAXLN - 1; i >= 0; i--) {
            if (par[i][u] != par[i][v]) {
                u = par[i][u];
                v = par[i][v];
            }
        }

        return par[0][u];
    }

    private int ni() {
        try {
            int num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        } catch (IOException e) {
            throw new InputMismatchException();
        }
    }

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private int readByte() throws IOException {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            lenbuf = is.read(inbuf);
            if (lenbuf <= 0) return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() throws IOException {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b)) ;
        return b;
    }

    private byte[] inbuf = new byte[1024];
    private int lenbuf = 0, ptrbuf = 0;
}