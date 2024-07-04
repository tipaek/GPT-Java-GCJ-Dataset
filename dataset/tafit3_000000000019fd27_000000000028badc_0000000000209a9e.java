import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private static final int FLUCTUATION_INTERVAL = 10;
    BufferedReader rd;

    Solution() {
        rd = new BufferedReader(new InputStreamReader(System.in));
        compute();
    }

    private void compute() {
        new Solver(new ConsoleDatabaseSystem()).solve();
    }

    public class ConsoleDatabaseSystem implements DatabaseSystem {

        @Override
        public int[] getTestsDescription() {
            try {
                return intarr();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public int getValueAt(int index) {
            out(index + 1);
            try {
                return pint();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void sendSolution(String s) {
            out(s);
            try {
                rd.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private interface DatabaseSystem {
        int[] getTestsDescription();

        int getValueAt(int index);

        void sendSolution(String s);
    }

    private static class Solver {
        private final DatabaseSystem sys;
        private List<FlippableStorage> flippables;

        public Solver(DatabaseSystem sys) {
            this.sys = sys;
        }

        public void solve() {
            int[] a = sys.getTestsDescription();
            int t = a[0];
            int n = a[1];
            for (int i = 0; i < t; i++) {
                solve(n);
            }
        }

        private void solve(int n) {
            flippables = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                flippables.add(new FlippableStorage(n, i == 0));
            }
            int query = 0;
            int pos = 0;
            int[] w = new int[]{-1, -1};
            for (; ; ) {
                if (query % FLUCTUATION_INTERVAL == 0) {
                    for (int i = 0; i < 2; i++) {
                        if (w[i] != -1) {
                            int u = sys.getValueAt(w[i]);
                            query++;
                            flippables.get(i).flipIfChanged(w[i], u);
                        } else {
                            sys.getValueAt(0);
                            query++;
                        }
                    }
                }
                if (pos < n / 2) {
                    int u = sys.getValueAt(pos);
                    query++;
                    int v = sys.getValueAt(n - 1 - pos);
                    query++;
                    int r = u == v ? 0 : 1;
                    flippables.get(r).bitDetected(pos, u);
                    w[r] = pos;
                    pos++;
                } else {
                    int[] res = new int[n];
                    for (int i = 0; i < n; i++) {
                        res[i] = flippables.get(0).getValueAt(i);
                        if (res[i] == -1) {
                            res[i] = flippables.get(1).getValueAt(i);
                        }
                    }
                    sys.sendSolution(convert(res));
                    break;
                }
            }
        }

        private String convert(int[] a) {
            int n = a.length;
            char[] res = new char[n];
            for (int i = 0; i < n; i++) {
                res[i] = (char) ('0' + a[i]);
            }
            return new String(res);
        }
    }

    private static final class FlippableStorage {
        final boolean same;
        final int n;
        List<Set<Integer>> bitPositions = new ArrayList<>();
        boolean flipped;

        public FlippableStorage(int n, boolean same) {
            this.n = n;
            this.same = same;
            for (int i = 0; i < 2; i++) {
                bitPositions.add(new HashSet<>());
            }
        }

        public void bitDetected(int p, int v) {
            bitPositions.get(applyFlip(v)).add(p);
        }

        public void flipIfChanged(int p, int v) {
            if (!bitPositions.get(applyFlip(v)).contains(p)) {
                flipped = !flipped;
            }
        }

        public int getValueAt(int i) {
            if (same) {
                if (i >= n / 2) {
                    i = n - 1 - i;
                }
                for (int j = 0; j < 2; j++) {
                    if (bitPositions.get(j).contains(i)) {
                        return applyFlip(j);
                    }
                }
            } else {
                boolean inv = false;
                if (i >= n / 2) {
                    i = n - 1 - i;
                    inv = true;
                }
                for (int j = 0; j < 2; j++) {
                    if (bitPositions.get(j).contains(i)) {
                        return applyB(applyFlip(j), inv);
                    }
                }
            }

            return -1;
        }

        private int applyFlip(int v) {
            return applyB(v, flipped);
        }

        private static int applyB(int v, boolean b) {
            return b ? (1 - v) : v;
        }
    }

    private int pint() throws IOException {
        return pint(rd.readLine());
    }

    private int pint(String s) {
        return Integer.parseInt(s);
    }

    private int[] intarr() throws IOException {
        return intarr(rd.readLine());
    }

    private int[] intarr(String s) {
        String[] q = split(s);
        int n = q.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(q[i]);
        }
        return a;
    }

    public String[] split(String s) {
        if (s == null) {
            return new String[0];
        }
        int n = s.length();
        int start = -1;
        int end = 0;
        int sp = 0;
        boolean lastWhitespace = true;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (isWhitespace(c)) {
                lastWhitespace = true;
            } else {
                if (lastWhitespace) {
                    sp++;
                }
                if (start == -1) {
                    start = i;
                }
                end = i;
                lastWhitespace = false;
            }
        }
        if (start == -1) {
            return new String[0];
        }
        String[] res = new String[sp];
        int last = start;
        int x = 0;
        lastWhitespace = true;
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            boolean w = isWhitespace(c);
            if (w && !lastWhitespace) {
                res[x++] = s.substring(last, i);
            } else if (!w && lastWhitespace) {
                last = i;
            }
            lastWhitespace = w;
        }
        res[x] = s.substring(last, end + 1);
        return res;
    }

    private boolean isWhitespace(char c) {
        return c == ' ' || c == '\t';
    }

    private static void out(Object x) {
        System.out.println(x);
        System.out.flush();
    }

    public static void main(String[] args) throws IOException {
        new Solution();
    }
}
