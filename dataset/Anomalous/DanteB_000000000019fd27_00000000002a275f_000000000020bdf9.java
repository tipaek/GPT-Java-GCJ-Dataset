import java.util.*;
import java.io.*;

public class Solution {

    static InputReader in = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = in.nextInt();
        for (int tc = 1; tc <= t; ++tc) {
            int n = in.nextInt();
            Task[] tasks = new Task[n];
            for (int i = 0; i < n; i++) {
                tasks[i] = new Task(in.nextInt(), in.nextInt(), i);
            }
            Arrays.sort(tasks, (t1, t2) -> t1.start != t2.start ? Integer.compare(t1.start, t2.start) : Integer.compare(t1.end, t2.end));

            int cEnd = 0;
            int jEnd = 0;
            char[] solution = new char[n];
            boolean possible = true;

            for (Task task : tasks) {
                if (task.start >= cEnd) {
                    solution[task.index] = 'C';
                    cEnd = task.end;
                } else if (task.start >= jEnd) {
                    solution[task.index] = 'J';
                    jEnd = task.end;
                } else {
                    out.println("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                out.println(new String(solution));
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

        public InputReader(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
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
            String token = peekToken();
            tokenizer = null;
            return token;
        }

        public String nextLine() {
            peekToken();
            String line = tokenizer.nextToken("\n");
            tokenizer = null;
            return line;
        }

        public void close() throws IOException {
            reader.close();
        }

        private String peekToken() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if (line == null) {
                        return null;
                    }
                    tokenizer = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.hasMoreTokens() ? tokenizer.nextToken() : null;
        }
    }
}