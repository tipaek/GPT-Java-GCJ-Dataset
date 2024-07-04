import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(in, out);
        out.close();
    }

    public static void solve(InputReader in, PrintWriter out) {
        int t = in.nextInt();
        for (int index = 1; index <= t; ++index) {
            out.print("Case #");
            out.print(index);
            out.print(": ");
            int n = in.nextInt();
            int c = 0;
            int j = 0;
            PriorityQueue<Activity> activities = new PriorityQueue<>(n);
            for (int i = 0; i < n; ++i) {
                activities.add(new Activity(in.nextInt(), in.nextInt(), i));
            }
            boolean[] res = new boolean[n];
            boolean possible = true;
            for (int i = 0; i < n; ++i) {
                Activity act = activities.remove();
                if (act.start >= c) {
                    c = act.end;
                    res[act.index] = true;
                } else if (act.start >= j) {
                    j = act.end;
                    res[act.index] = false;
                } else {
                    possible = false;
                    break;
                }
            }
            if (!possible) {
                out.println("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; ++i) {
                    out.print(res[i] ? 'C' : 'J');
                }
                out.println();
            }
        }
    }

    static class Activity implements Comparable<Activity> {
        int start;
        int end;
        int index;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Activity o) {
            int cmp = Integer.compare(this.start, o.start);
            if (cmp != 0) {
                return cmp;
            }
            cmp = Integer.compare(this.end, o.end);
            if (cmp != 0) {
                return cmp;
            }
            return Integer.compare(this.index, o.index);
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

        public void skip() {
            tokenizer = null;
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}