import java.io.*;
import java.util.StringTokenizer;

class Solution {
    class InputReader {
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

        public float nextFloat() {
            return Float.parseFloat(next());
        }

        public double nextDouble() {
            return Float.parseFloat(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    private InputReader sc = new InputReader(System.in);
    // private InputReader sc = new InputReader(new File("input.txt"));
    private PrintWriter pw = new PrintWriter(System.out);

    class Task {
        int id;
        int start;
        int end;
        char assignee = '-';

        Task(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

        boolean intersects(Task other) {
            return !(other.end <= start || end <= other.start);
        }
    }

    private boolean assign(Task current, Task[] tasks, int n) {
        for (int i = 0; i < n; i++) {
            Task other = tasks[i];
            if (current == other) {
                continue;
            }

            if (current.intersects(other)) {
                if (other.assignee == '-') {
                    other.assignee = (char)((int)'C' + (int)'J' - (int)current.assignee);
                    boolean success = assign(other, tasks, n);
                    if (!success) {
                        return false;
                    }
                } else {
                    if (other.assignee == current.assignee) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private void solveTest(int test) {
        int n = sc.nextInt();

        Task[] tasks = new Task[1000];
        for (int i = 0; i < n; i++) {
            tasks[i] = new Task(i, sc.nextInt(), sc.nextInt());
        }

        boolean possible = true;
        for (int i = 0; i < n; i++) {
            if (tasks[i].assignee == '-') {
                tasks[i].assignee = 'C';
                boolean success = assign(tasks[i], tasks, n);
                if (!success) {
                    possible = false;
                    break;
                }
            }
        }

        pw.print(String.format("Case #%d: ", test));
        if (!possible) {
            pw.println("IMPOSSIBLE");
        } else {
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n; i++) {
                ans.append(tasks[i].assignee);
            }
            pw.println(ans);
        }
    }

    private void run() {
        int nTests = sc.nextInt();

        for (int test = 1; test <= nTests; test++) {
            solveTest(test);
        }

        pw.close();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.run();
    }
}
