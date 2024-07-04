import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.AbstractSet;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        SquareDance solver = new SquareDance();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class SquareDance {
        TreeSet<Value> remaining;
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            out.printf("Case #%d: ", testNumber);
            int r = in.nextInt(), c = in.nextInt();
            Value[][] vals = new Value[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    int dance = in.nextInt();
                    vals[i][j] = new Value(i, j, dance);
                }
            }

            remaining = new TreeSet<>();
            long curSum = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d], nj = j + dy[d];
                        if (0 <= ni && ni < r && 0 <= nj && nj < c) {
                            vals[i][j].neighbors[d] = vals[ni][nj];
                            vals[i][j].diff += vals[ni][nj].dance - vals[i][j].dance;
                        }
                    }
                    curSum += vals[i][j].dance;
                    remaining.add(vals[i][j]);
                }
            }
            long result = curSum;
            while (remaining.first().diff > 0) {
                List<Value> toRemove = new ArrayList<>();
                for (Value v : remaining) {
                    if (v.diff <= 0) {
                        break;
                    }
                    toRemove.add(v);
                    curSum -= v.dance;
                }
                result += curSum;
                remaining.removeAll(toRemove);
                for (Value v : toRemove) {
                    for (int dir = 0; dir < 2; dir++) {
                        Value prev = v.neighbors[dir], next = v.neighbors[dir ^ 2];
                        updateNeighbor(prev, next, dir + 2);
                        updateNeighbor(next, prev, dir);
                    }
                }
            }
            out.println(result);
        }

        private void updateNeighbor(Value value, Value newNeighbor, int dir) {
            if (value == null) {
                return;
            }
            remaining.remove(value);
            value.diff -= value.neighbors[dir].dance - value.dance;
            value.neighbors[dir] = newNeighbor;
            if (newNeighbor != null) {
                value.diff += value.neighbors[dir].dance - value.dance;
            }
            remaining.add(value);
        }

        class Value implements Comparable<Value> {
            int r;
            int c;
            int dance;
            int diff;
            Value[] neighbors;

            public String toString() {
                return "Value{" +
                        "r=" + r +
                        ", c=" + c +
                        ", dance=" + dance +
                        ", diff=" + diff +
                        '}';
            }

            public Value(int r, int c, int dance) {
                this.r = r;
                this.c = c;
                this.dance = dance;
                neighbors = new Value[4];
            }

            public int compareTo(Value other) {
                if (diff != other.diff) {
                    return -Integer.compare(diff, other.diff);
                }
                if (r != other.r) {
                    return Integer.compare(r, other.r);
                }
                return Integer.compare(c, other.c);
            }

        }

    }

    static class FastScanner {
        public BufferedReader br;
        public StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public FastScanner(String fileName) {
            try {
                br = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

    }
}

