import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    BufferedReader rd;

    Solution() throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
        compute();
    }

    private void compute() throws IOException {
        int n = pint();
        for(int i=1;i<=n;i++) {
            out("Case #" + i + ": " + solve());
        }
    }

    private String solve() throws IOException {
        int[] a = intarr();
        List<Move> moves = new Solver().solve(a[0], a[1]);
        StringBuilder buf = new StringBuilder();
        buf.append(""+moves.size());
        for(int i=moves.size()-1;i>=0;i--) {
            Move cur = moves.get(i);
            buf.append('\n');
            buf.append((cur.b - cur.a)+" "+(cur.a));
        }
        return buf.toString();
    }

    private class Solver {
        private final Map<String, Move> m = new HashMap<>();
        int n;

        private List<Move> solve(int r, int s) {
            n = r*s;
            String g = genStart(r, s);
            m.put(g, new Move(0,0,0));
            dsolve(g);
            String cur = genEnd(r, s);
            List<Move> res = new ArrayList<>();
            while(!cur.equals(g)) {
                Move move = m.get(cur);
                res.add(move);
                cur = swap(cur, move.b - move.a, move.b);
            }
            return res;
        }

        private void dsolve(String initial) {
            Queue<State> q = new ArrayDeque<>();
            q.add(new State(initial, 0));
            while(!q.isEmpty()) {
                State s = q.poll();
                for(int i=1;i<n;i++) {
                    for(int j=i+1;j<=n;j++) {
                        String z = swap(s.s,i,j);
                        if(!s.s.equals(z)) {
                            Move move = m.get(z);
                            if (move == null) {
                                m.put(z, new Move(i, j, s.len + 1));
                                q.add(new State(z, s.len + 1));
                            }
                        }
                    }
                }
            }
        }

        private String swap(String s, int a, int b) {
            StringBuilder buf = new StringBuilder();
            buf.append(s, a, b);
            buf.append(s, 0, a);
            buf.append(s, b, s.length());
            return buf.toString();
        }

        private String genStart(int r, int s) {
            StringBuilder buf = new StringBuilder();
            for(int j=0;j<r;j++) {
                char c = (char)('1' + j);
                for(int i=0;i<s;i++) {
                    buf.append(c);
                }
            }
            return buf.toString();
        }

        private String genEnd(int r, int s) {
            StringBuilder buf = new StringBuilder();
            for(int i=0;i<s;i++) {
                for(int j=0;j<r;j++) {
                    buf.append((char)('1' + j));
                }
            }
            return buf.toString();
        }
    }

    private class State {
        final String s;
        final int len;

        public State(String s, int len) {
            this.s = s;
            this.len = len;
        }

        @Override
        public String toString() {
            return "State{" +
                    "s='" + s + '\'' +
                    ", len=" + len +
                    '}';
        }
    }

    private class Move {
        final int a, b, len;

        public Move(int a, int b, int len) {
            this.a = a;
            this.b = b;
            this.len = len;
        }

        @Override
        public String toString() {
            return "Move{" +
                    "a=" + a +
                    ", b=" + b +
                    ", len=" + len +
                    '}';
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
        for(int i=0;i<n;i++) {
            a[i] = Integer.parseInt(q[i]);
        }
        return a;
    }
    public String[] split(String s) {
        if(s == null) {
            return new String[0];
        }
        int n = s.length();
        int start = -1;
        int end = 0;
        int sp = 0;
        boolean lastWhitespace = true;
        for(int i=0;i<n;i++) {
            char c = s.charAt(i);
            if(isWhitespace(c)) {
                lastWhitespace = true;
            } else {
                if(lastWhitespace) {
                    sp++;
                }
                if(start == -1) {
                    start = i;
                }
                end = i;
                lastWhitespace = false;
            }
        }
        if(start == -1) {
            return new String[0];
        }
        String[] res = new String[sp];
        int last = start;
        int x = 0;
        lastWhitespace = true;
        for(int i=start;i<=end;i++) {
            char c = s.charAt(i);
            boolean w = isWhitespace(c);
            if(w && !lastWhitespace) {
                res[x++] = s.substring(last,i);
            } else if(!w && lastWhitespace) {
                last = i;
            }
            lastWhitespace = w;
        }
        res[x] = s.substring(last,end+1);
        return res;
    }

    private boolean isWhitespace(char c) {
        return c==' ' || c=='\t';
    }

    private static void out(Object x) {
        System.out.println(x);
    }

    public static void main(String[] args) throws IOException {
        new Solution();
    }
}
