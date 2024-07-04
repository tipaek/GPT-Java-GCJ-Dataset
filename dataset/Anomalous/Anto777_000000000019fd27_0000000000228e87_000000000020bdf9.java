import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public final class Solution {
    private BufferedReader br;
    private StringTokenizer stk;

    public static void main(String[] args) throws Exception {
        new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    new Solution().run();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }, "solution", 1 << 26).start();
    }

    public Solution() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private final long mod = 1000000007L;

    private void run() throws Exception {
        int t = ni();
        for (int I = 1; I <= t; I++) {
            int n = ni();
            Pair[] pairs = new Pair[n];
            for (int i = 0; i < n; i++) {
                pairs[i] = new Pair(ni(), ni(), i);
            }
            Arrays.sort(pairs);

            Stack<Pair> cStack = new Stack<>();
            Stack<Pair> jStack = new Stack<>();

            cStack.push(pairs[0]);
            boolean impossible = false;
            for (int i = 1; i < n; i++) {
                if (overlaps(cStack.peek(), pairs[i]) || overlaps(pairs[i], cStack.peek())) {
                    if (jStack.isEmpty()) {
                        jStack.push(pairs[i]);
                    } else {
                        if (overlaps(jStack.peek(), pairs[i]) || overlaps(pairs[i], jStack.peek())) {
                            impossible = true;
                            break;
                        } else {
                            jStack.push(pairs[i]);
                        }
                    }
                } else {
                    cStack.push(pairs[i]);
                }
            }

            if (impossible) {
                pl("Case #" + I + ": IMPOSSIBLE");
            } else {
                char[] c = new char[n];
                while (!cStack.isEmpty()) {
                    c[cStack.pop().index] = 'C';
                }
                while (!jStack.isEmpty()) {
                    c[jStack.pop().index] = 'J';
                }

                pl("Case #" + I + ": " + new String(c));
            }
        }
    }

    private boolean overlaps(Pair p, Pair q) {
        if (q.from == p.to) return false;
        return q.from >= p.from && q.from <= p.to;
    }

    private class Pair implements Comparable<Pair> {
        int from, to, index;

        Pair(int from, int to, int index) {
            this.from = from;
            this.to = to;
            this.index = index;
        }

        @Override
        public int compareTo(Pair pair) {
            if (this.from == pair.from) {
                return this.to - pair.to;
            }
            return this.from - pair.from;
        }

        @Override
        public String toString() {
            return "[" + from + ", " + to + "]";
        }
    }

    // Reader & Writer
    private String nextToken() throws Exception {
        if (stk == null || !stk.hasMoreTokens()) {
            stk = new StringTokenizer(br.readLine(), " ");
        }
        return stk.nextToken();
    }

    private String nt() throws Exception {
        return nextToken();
    }

    private String ns() throws Exception {
        return br.readLine();
    }

    private int ni() throws Exception {
        return Integer.parseInt(nextToken());
    }

    private long nl() throws Exception {
        return Long.parseLong(nextToken());
    }

    private double nd() throws Exception {
        return Double.parseDouble(nextToken());
    }

    private void p(Object o) {
        System.out.print(o);
    }

    private void pl(Object o) {
        System.out.println(o);
    }
}