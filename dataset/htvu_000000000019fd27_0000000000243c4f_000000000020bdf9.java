import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author htvu
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        solver.solve(1, in, out);
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int T = in.nextInt();
            int START = 1, END = 0;
            for (int test = 1; test <= T; ++test) {

                int n = in.nextInt();
                Event[] events = new Event[n * 2];
                for (int i = 0; i < n; ++i) {
                    int start = in.nextInt(), end = in.nextInt();
                    events[i * 2] = new Event(i, start, START);
                    events[i * 2 + 1] = new Event(i, end, END);
                }
                Arrays.sort(events);
                int cnt = 0;
                for (Event e : events) {
                    cnt += e.type == START ? 1 : -1;
                    if (cnt > 2) {
                        break;
                    }
                }

                if (cnt > 2) {
                    out.printf("Case #%d: %s\n", test, "IMPOSSIBLE");
                    continue;
                }

                int JAMIE = 1, CAMERON = 2;
                int[] assign = new int[n];
                int J = -1, C = -1;
                for (Event e : events) {
                    if (e.type == START) {
                        if (C == -1) {
                            C = e.id;
                            assign[e.id] = CAMERON;
                        } else {
                            J = e.id;
                            assign[e.id] = JAMIE;
                        }
                    } else {
                        if (assign[e.id] == JAMIE)
                            J = -1;
                        else
                            C = -1;
                    }
                }
                StringBuilder ans = new StringBuilder();
                for (int i = 0; i < n; ++i)
                    ans.append(assign[i] == JAMIE ? "J" : "C");

                out.printf("Case #%d: %s\n", test, ans.toString());
            }
        }

        class Event implements Comparable<Event> {
            int id;
            int time;
            int type;

            Event(int id, int time, int type) {
                this.id = id;
                this.time = time;
                this.type = type;
            }

            public int compareTo(Event o) {
                if (time != o.time) return time - o.time;
                if (type != o.type) return type - o.type;
                return id - o.id;
            }

        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

