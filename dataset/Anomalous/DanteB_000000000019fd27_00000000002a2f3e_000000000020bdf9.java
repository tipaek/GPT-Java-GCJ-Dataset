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
            tasks[0] = new Task(0, 0, 0);
            for (int i = 1; i <= n; i++) {
                tasks[i] = new Task(in.nextInt(), in.nextInt(), i);
            }
            Arrays.sort(tasks, Comparator.comparingInt((Task task) -> task.start).thenComparingInt(task -> task.end));
            int cEnd = 0;
            int jEnd = 0;
            char[] schedule = new char[n];
            boolean possible = true;
            for (int i = 1; i <= n; i++) {
                if (tasks[i].start >= cEnd) {
                    schedule[tasks[i].index - 1] = 'C';
                    cEnd = tasks[i].end;
                } else if (tasks[i].start >= jEnd) {
                    schedule[tasks[i].index - 1] = 'J';
                    jEnd = tasks[i].end;
                } else {
                    out.println("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            if (possible) {
                out.println(new String(schedule));
            }
        }
        finish();
    }

    public static void finish() {
        out.close();
        in.close();
        System.exit(0);
    }

    static class Task {
        int start, end, index;

        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    static class InputReader implements Iterator<String>, Closeable {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        private String currentToken;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

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

        public String next() {
            String result = peekToken();
            currentToken = null;
            return result;
        }

        public String nextLine() {
            peekToken();
            String result = tokenizer == null ? null : tokenizer.nextToken("\n");
            currentToken = null;
            tokenizer = null;
            return result;
        }

        public void close() {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String peekToken() {
            if (currentToken == null) {
                try {
                    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                        String line = reader.readLine();
                        if (line == null) return null;
                        tokenizer = new StringTokenizer(line);
                    }
                    currentToken = tokenizer.nextToken();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return currentToken;
        }
    }
}