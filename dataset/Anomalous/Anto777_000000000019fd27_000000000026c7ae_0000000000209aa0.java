import java.io.*;
import java.util.*;

public final class Solution {
    private BufferedReader br;
    private StringTokenizer stk;
    private final long mod = 1000000007L;

    public static void main(String[] args) {
        new Thread(null, () -> {
            try {
                new Solution().run();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }, "solution", 1 << 26).start();
    }

    public Solution() {
        stk = null;
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private void run() throws Exception {
        int t = ni();
        for (int I = 1; I <= t; I++) {
            int n = ni(), k = ni();
            int[] a = new int[n];
            int sum = k - n;
            Arrays.fill(a, 1);
            for (int i = 0; i < n; i++) {
                while (a[i] < n && sum != 0) {
                    a[i]++;
                    sum--;
                }
            }

            List<Triple> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int z = 1; z <= n; z++) {
                        list.add(new Triple(i, j, z));
                    }
                }
            }

            boolean found = false;
            while (true) {
                for (Triple triple : list) {
                    int[][] work = new int[n][n];
                    for (int z = 0; z < n; z++) work[z][z] = a[z];
                    for (Triple t : list) {
                        if (ok(t, work)) {
                            work[t.a][t.b] = t.c;
                        }
                    }
                    if (isFilled(work)) {
                        StringBuilder res = new StringBuilder(10000);
                        res.append("Case #").append(I).append(": ").append("POSSIBLE\n");
                        for (int[] row : work) {
                            for (int val : row) {
                                res.append(val).append(" ");
                            }
                            res.deleteCharAt(res.length() - 1).append("\n");
                        }
                        p(res);
                        found = true;
                        break;
                    }
                }

                if (found) break;

                if (!formsNext(a)) break;
            }

            if (!found) pl("Case #" + I + ": IMPOSSIBLE");
        }
    }

    private boolean isFilled(int[][] a) {
        for (int[] row : a)
            for (int val : row)
                if (val == 0) return false;
        return true;
    }

    private boolean ok(Triple t, int[][] a) {
        if (a[t.a][t.b] > 0) return false;
        int val = t.c;
        for (int i = 0; i < a.length; i++) {
            if (a[t.a][i] == val || a[i][t.b] == val) return false;
        }
        return true;
    }

    private boolean formsNext(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            if (a[i] < a[i - 1]) {
                a[i - 1]--;
                a[i]++;
                return true;
            }
        }
        return false;
    }

    private String nextToken() throws Exception {
        if (stk == null || !stk.hasMoreTokens()) {
            stk = new StringTokenizer(br.readLine(), " ");
        }
        return stk.nextToken();
    }

    private int ni() throws Exception {
        return Integer.parseInt(nextToken());
    }

    private void p(Object o) {
        System.out.print(o);
    }

    private void pl(Object o) {
        System.out.println(o);
    }

    private static class Triple {
        final int a, b, c;

        public Triple(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}