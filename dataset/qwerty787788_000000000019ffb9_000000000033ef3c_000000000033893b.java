import java.io.*;
import java.util.*;

public class Solution {
    FastScanner in;
    PrintWriter out;

    class Solver {
        char[] s;
        int[] id;
        int[] parentId;
        int[] posInList;
        int[] cntChild;
        int[] h;

        final int MAX = 20;
        int[][] up;
        int[][][][] d;
        // {left, right} {left, right parent}{2 ^ i}{id}

        Solver(char[] s) {
            this.s = s;
            List<Integer> open = new ArrayList<>();
            int totObjsNum = s.length / 2 + 1;
            int curId = 1;
            id = new int[s.length];
            parentId = new int[s.length];
            posInList = new int[s.length];
            cntChild = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                if (s[i] == '(') {
                    open.add(i);
                    id[i] = curId++;
                    if (i == 0) {
                        parentId[id[i]] = 0;
                        posInList[id[i]] = 0;
                    } else if (s[i - 1] == ')') {
                        parentId[id[i]] = parentId[id[i - 1]];
                        posInList[id[i]] = posInList[id[i - 1]] + 1;
                    } else {
                        parentId[id[i]] = id[i - 1];
                        posInList[id[i]] = 0;
                    }
                } else {
                    int last = open.get(open.size() - 1);
                    open.remove(open.size() - 1);
                    id[i] = id[last];
                }
            }
            if (curId != totObjsNum) {
                throw new AssertionError();
            }
            h = new int[totObjsNum];
            up = new int[MAX][totObjsNum];
            for (int i = 1; i < totObjsNum; i++) {
                cntChild[parentId[i]] = posInList[i] + 1;
                h[i] = h[parentId[i]] + 1;
                up[0][i] = parentId[i];
            }
            d = new int[2][2][MAX][totObjsNum];
            for (int obj = 1; obj < totObjsNum; obj++) {
                if (parentId[obj] == 0) {
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 2; j++) {
                            d[i][j][0][obj] = Integer.MAX_VALUE / 3;
                        }
                    }
                } else {
                    d[0][0][0][obj] = posInList[obj] * 2 + 1;
                    d[0][1][0][obj] = d[0][0][0][obj] + 1;
                    d[1][1][0][obj] = (cntChild[parentId[obj]] - posInList[obj] - 1) * 2 + 1;
                    d[1][0][0][obj] = d[1][1][0][obj] + 1;
                    for (int from = 0; from < 2; from++) {
                        for (int to = 0; to < 2; to++) {
                            d[from][to][0][obj] = Math.min(d[from][to][0][obj], 1 + d[1 - from][to][0][obj]);
                        }
                    }
                }
            }
            for (int layer = 1; layer < MAX; layer++) {
                for (int i = 0; i < totObjsNum; i++) {
                    up[layer][i] = up[layer - 1][up[layer - 1][i]];
                    for (int from = 0; from < 2; from++) {
                        for (int to = 0; to < 2; to++) {
                            d[from][to][layer][i] = Integer.MAX_VALUE / 3;
                            final int midV = up[layer - 1][i];
                            for (int mid = 0; mid < 2; mid++) {
                                d[from][to][layer][i] = Math.min(d[from][to][layer][i], d[from][mid][layer - 1][i] + d[mid][to][layer - 1][midV]);
                            }
                        }
                    }
                }
            }
        }

        // state = {id, cost_to_left, cost_to_right}
        int[] convertToState(int pos) {
            int yourId = id[pos];
            if (s[pos] == '(') {
                return new int[]{yourId, 0, 1};
            } else {
                return new int[]{yourId, 1, 0};
            }
        }

        int up(int v, int dh) {
            if (dh < 0) {
                return v;
            }
            for (int i = 0; i < MAX; i++) {
                if (((1 << i) & dh) != 0) {
                    v = up[i][v];
                }
            }
            return v;
        }

        int lca(int x, int y) {
            {
                int dh = h[x] - h[y];
                x = up(x, dh);
            }
            {
                int dh = h[y] - h[x];
                y = up(y, dh);
            }
            for (int i = MAX - 1; i >= 0; i--) {
                if (up[i][x] != up[i][y]) {
                    x = up[i][x];
                    y = up[i][y];
                }
            }
            return x == y ? x : up[0][x];
        }

        int[] goState(int[] mystate, int dh) {
            if (dh < 0) {
                return mystate;
            }
            for (int i = 0; i < MAX; i++) {
                if (((1 << i) & dh) != 0) {
                    int[] next = new int[]{up[i][mystate[0]], Integer.MAX_VALUE, Integer.MAX_VALUE};
                    for (int start = 0; start < 2; start++) {
                        for (int to = 0; to < 2; to++) {
                            next[to + 1] = Math.min(next[to + 1], mystate[start] + d[start][to][i][mystate[0]]);
                        }
                    }
                    mystate = next;
                }
            }
            return mystate;
        }

        int getDist(int from, int to) {
            int[] s1 = convertToState(from);
            int[] s2 = convertToState(to);
            int lca = lca(s1[0], s2[0]);
            s1 = goState(s1, h[s1[0]] - h[lca] - 1);
            s2 = goState(s2, h[s2[0]] - h[lca] - 1);
            if (s1[0] == s2[0]) {
                return Math.min(s1[1] + s2[1], s1[2] + s2[2]);
            }
            if (s1[0] > s2[0]) {
                int[] tmp = s1;
                s1 = s2;
                s2 = tmp;
            }
            if (s1[0] == lca) {
                int res = Integer.MAX_VALUE;
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        res = Math.min(res, s1[i + 1] + s2[j + 1] + d[j][i][0][s2[0]]);
                    }
                }
                return res;
            } else {
                int res = s1[2] + s2[1] + (posInList[s2[0]] - posInList[s1[0]] - 1) * 2 + 1;
                int around = Math.min(d[0][0][0][s1[0]] + s1[1], d[1][0][0][s1[0]] + s2[2]) + Math.min(d[0][0][0][s2[0]] + s2[1], d[1][0][0][s2[0]] + s2[2]);
                return Math.min(res, around);
            }
        }
    }

    void solve() {
        int tc = in.nextInt();
        for (int t = 0; t < tc; t++) {
            int n = in.nextInt();
            int queries = in.nextInt();
            char[] s = in.next().toCharArray();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < n; j++) {
                    in.nextInt();
                }
            }
            int[] start = new int[queries];
            int[] finish = new int[queries];
            for (int i = 0; i < start.length; i++) {
                start[i] = in.nextInt() - 1;
            }
            for (int i = 0; i < finish.length; i++) {
                finish[i] = in.nextInt() - 1;
            }
            Solver solver = new Solver(s);
            long res = 0;
            for (int i = 0; i < start.length; i++) {
                res += solver.getDist(start[i], finish[i]);
            }
            out.println("Case #" + (t + 1) + ": " + res);
        }
    }


    void run() {
        try {
            in = new FastScanner(new File("Solution.in"));
            out = new PrintWriter(new File("Solution.out"));

            solve();

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void runIO() {

        in = new FastScanner(System.in);
        out = new PrintWriter(System.out);

        solve();

        out.close();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        boolean hasMoreTokens() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
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
    }

    public static void main(String[] args) {
        new Solution().runIO();
    }
}