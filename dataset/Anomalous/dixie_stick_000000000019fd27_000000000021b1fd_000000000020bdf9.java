import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Solution {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int T = scanner.nextInt();
        StringBuilder output = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            Task[] tasks = new Task[N];

            for (int i = 0; i < N; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks[i] = new Task(start, end, i);
            }

            Arrays.sort(tasks);

            ArrayList<Task> firstSchedule = new ArrayList<>();
            ArrayList<Task> secondSchedule = new ArrayList<>();
            ArrayList<Task> remainingTasks = new ArrayList<>();

            int lastEndTime = -1;
            for (Task task : tasks) {
                if (lastEndTime <= task.start) {
                    lastEndTime = task.end;
                    firstSchedule.add(task);
                } else {
                    remainingTasks.add(task);
                }
            }

            lastEndTime = -1;
            for (Task task : remainingTasks) {
                if (lastEndTime <= task.start) {
                    lastEndTime = task.end;
                    secondSchedule.add(task);
                } else {
                    output.append("Case #").append(t + 1).append(": IMPOSSIBLE\n");
                    continue;
                }
            }

            char[] assignment = new char[N];
            for (Task task : firstSchedule) {
                assignment[task.index] = 'C';
            }
            for (Task task : secondSchedule) {
                assignment[task.index] = 'J';
            }

            output.append("Case #").append(t + 1).append(": ");
            for (char c : assignment) {
                output.append(c);
            }
            output.append("\n");
        }

        System.out.print(output.toString());
    }

    static class Task implements Comparable<Task> {
        int start, end, index;

        public Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Task other) {
            if (this.end != other.end) {
                return this.end - other.end;
            }
            return this.start - other.start;
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }

    static class FastScanner {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buffer[currentChar++];
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndline(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = read();
            while (isEndline(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndline(c));
            return res.toString();
        }
    }
}