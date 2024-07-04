import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = in.nextInt();
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class ParentingPartneringReturns {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            List<Task> tasks = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                tasks.add(new Task(in.nextInt(), in.nextInt(), i));
            }

            tasks.sort(Comparator.comparingInt(task -> task.start));
            int lastC = 0, lastJ = 0;
            char[] schedule = new char[n];
            for (Task task : tasks) {
                if (task.start >= lastC) {
                    schedule[task.index] = 'C';
                    lastC = task.end;
                } else if (task.start >= lastJ) {
                    schedule[task.index] = 'J';
                    lastJ = task.end;
                } else {
                    out.printf("Case #%d: IMPOSSIBLE%n", testNumber);
                    return;
                }
            }
            out.printf("Case #%d: %s%n", testNumber, new String(schedule));
        }

        static class Task {
            int start, end, index;

            Task(int start, int end, int index) {
                this.start = start;
                this.end = end;
                this.index = index;
            }
        }
    }

    static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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