import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;
import java.util.function.IntFunction;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Eric
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        OverexcitedFan solver = new OverexcitedFan();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class OverexcitedFan {
        private OverexcitedFan.MyPair[] moves = new OverexcitedFan.MyPair[]{new OverexcitedFan.MyPair(1, 0), new OverexcitedFan.MyPair(-1, 0), new OverexcitedFan.MyPair(0, 1), new OverexcitedFan.MyPair(0, -1)};

        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int x = in.nextInt();
            int y = in.nextInt();
            String m = in.next();
            int res = solveMe(x, y, m);
            out.print("Case #" + testNumber + ": ");
            out.println(res == -1 ? "IMPOSSIBLE" : res);
        }

        private int solveMe(int x, int y, String m) {
            if (x == 0 && y == 0)
                return 0;
            HashSet<OverexcitedFan.MyPair>[] target = listOfPairsBeforeTime(new OverexcitedFan.MyPair(x, y), m);
            ArrayList<OverexcitedFan.MyPair> pos = new ArrayList<>();
            HashSet<OverexcitedFan.MyPair> done = new HashSet<>();
            int res = Integer.MAX_VALUE / 2;
            pos.add(new OverexcitedFan.MyPair(0, 0));
            for (int j = 0; j <= m.length(); j++) {
                if (target[j].contains(new OverexcitedFan.MyPair(0, 0))) {
                    res = Math.min(res, j);
                }
            }
            int max = m.length();
            for (int i = 1; i <= max; i++) {
                ArrayList<OverexcitedFan.MyPair> newPos = new ArrayList<>();
                for (OverexcitedFan.MyPair position : pos) {
                    for (OverexcitedFan.MyPair move : moves) {
                        OverexcitedFan.MyPair nextPos = position.add(move);
                        if (done.contains(nextPos)) {
                            continue;
                        }
                        done.add(nextPos);
                        for (int j = i; j <= m.length(); j++) {
                            if (target[j].contains(nextPos)) {
                                res = Math.min(res, j);
                            }
                        }
                        newPos.add(nextPos);
                    }
                }


                pos = newPos;
                //d("i= " + i + "; dp = "+ stringMeDeb(pos.toArray(new MyPair[0])));
            }
            if (res == Integer.MAX_VALUE / 2)
                return -1;
            return res;
        }

        private HashSet<OverexcitedFan.MyPair>[] listOfPairsBeforeTime(OverexcitedFan.MyPair init, String m) {
            HashSet<OverexcitedFan.MyPair>[] targets = new HashSet[m.length() + 1];
            arraysSetAll(targets, p -> new HashSet<>());
            targets[0].add(init);
            for (int i = 0; i < m.length(); i++) {
                init = init.add(getMove(m.charAt(i)));
                targets[i + 1].add(init);
            }

            //d("list = " + stringMeDeb(targets));
            return targets;
        }

        private OverexcitedFan.MyPair getMove(char move) {
            if (move == 'N')
                return moves[2];
            if (move == 'S')
                return moves[3];
            if (move == 'E')
                return moves[0];
            if (move == 'W')
                return moves[1];
            return null;
        }

        public static <T> void arraysSetAll(T[] a, IntFunction<? extends T> generator) {
            Arrays.setAll(a, generator);
        }

        public static class MyPair implements Comparable<OverexcitedFan.MyPair> {
            long first;
            long second;
            int nbSteps;

            public MyPair(long first, long second) {
                this.first = first;
                this.second = second;
            }

            public String toString() {
                //return "[" + first + ", " + second + "]";
                return first + ";" + second;
            }

            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                OverexcitedFan.MyPair myPair = (OverexcitedFan.MyPair) o;
                return first == myPair.first &&
                        second == myPair.second;
            }

            public int hashCode() {
                return Objects.hash(first, second);
            }

            public int compareTo(OverexcitedFan.MyPair p2) {
                int res = Long.compare(first, p2.first);
                return res != 0 ? res : Long.compare(second, p2.second);
            }

            public OverexcitedFan.MyPair add(OverexcitedFan.MyPair move) {
                OverexcitedFan.MyPair a = new OverexcitedFan.MyPair(first + move.first, second + move.second);
                a.nbSteps++;
                return a;
            }

        }

    }

    static class FastReader {
        public BufferedReader br;
        public StringTokenizer st;
        String context = null;

        public FastReader(InputStream in) {
            this(new InputStreamReader(in));
        }

        public FastReader(InputStreamReader input) {
            br = new BufferedReader(input);
        }

        public String next() {
            if (context != null) {
                System.err.print("[" + context + "] Wait for input ...");
            }
            while (st == null || !st.hasMoreElements()) {
                try {
                    String s = br.readLine();
                    if (s == null)
                        return null;
                    st = new StringTokenizer(s);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Could not read");
                }
            }
            String res = st.nextToken();
            if (context != null) {
                System.err.println("[" + context + "] ... received : " + res);
            }
            return res;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

