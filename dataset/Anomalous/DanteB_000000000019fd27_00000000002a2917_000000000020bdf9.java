import java.util.*;
import java.io.*;

public class Solution {

    static InputReader in = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = in.nextInt();
        for (int tc = 1; tc <= t; ++tc) {
            out.printf("Case #%d: ", tc);
            int n = in.nextInt();
            Task[] tasks = new Task[n + 1];
            tasks[0] = new Task(0, 0);

            for (int i = 1; i <= n; i++) {
                tasks[i] = new Task(in.nextInt(), in.nextInt());
            }

            Arrays.sort(tasks, Comparator.comparingInt((Task tsk) -> tsk.start)
                    .thenComparingInt(tsk -> tsk.end));

            int c = 0, j = 0;
            char[] solution = new char[n];

            for (int i = 1; i <= n; i++) {
                if (tasks[c].end <= tasks[i].start) {
                    solution[i - 1] = 'C';
                    c = i;
                } else if (tasks[j].end <= tasks[i].start) {
                    solution[i - 1] = 'J';
                    j = i;
                } else {
                    out.println("IMPOSSIBLE");
                    continue;
                }
            }
            out.println(solution);
        }
        finish();
    }

    public static void finish() {
        out.close();
        in.close();
        System.exit(0);
    }

    static class Task {
        int start, end;

        Task(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class InputReader implements Iterator<String>, Closeable {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        private String currentToken;

        public InputReader(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        @Override
        public boolean hasNext() {
            return peekToken() != null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        @Override
        public String next() {
            String token = peekToken();
            currentToken = null;
            return token;
        }

        public String nextLine() {
            peekToken();
            String line = this.currentToken;
            currentToken = null;
            tokenizer = null;
            return line;
        }

        @Override
        public void close() {
            try {
                reader.close();
            } catch (IOException e) {
                // Ignore exceptions on close
            }
        }

        private String peekToken() {
            if (currentToken == null) {
                try {
                    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                        String line = reader.readLine();
                        if (line == null) {
                            return null;
                        }
                        tokenizer = new StringTokenizer(line);
                    }
                    currentToken = tokenizer.nextToken();
                } catch (IOException e) {
                    // Ignore exceptions on read
                }
            }
            return currentToken;
        }
    }
}