import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    static class Task implements Comparable<Task> {
        int type;
        Point interval;
        int index;

        public Task(Point interval, int type, int index) {
            this.interval = interval;
            this.type = type;
            this.index = index;
        }

        @Override
        public int compareTo(Task other) {
            if (this.interval.x == other.interval.x) {
                return this.type - other.type;
            }
            return this.interval.x - other.interval.x;
        }
    }

    public static void main(String[] args) {
        InputReader inputReader = new InputReader(System.in);
        int testCases = inputReader.nextInt();
        int currentTest = 1;

        while (testCases-- > 0) {
            int n = inputReader.nextInt();
            PriorityQueue<Task> taskQueue = new PriorityQueue<>();
            char[] result = new char[n];

            for (int i = 0; i < n; i++) {
                int start = inputReader.nextInt();
                int end = inputReader.nextInt();
                taskQueue.add(new Task(new Point(start, end), 1, i));
            }

            boolean isCameronAvailable = false;
            boolean isJamieAvailable = false;
            boolean isPossible = true;

            while (!taskQueue.isEmpty()) {
                Task task = taskQueue.poll();

                if (task.type == 0) {
                    if (task.index == 0) {
                        isCameronAvailable = false;
                    } else {
                        isJamieAvailable = false;
                    }
                } else {
                    if (!isCameronAvailable) {
                        result[task.index] = 'C';
                        taskQueue.add(new Task(new Point(task.interval.y, 0), 0, 0));
                        isCameronAvailable = true;
                    } else if (!isJamieAvailable) {
                        result[task.index] = 'J';
                        taskQueue.add(new Task(new Point(task.interval.y, 0), 0, 1));
                        isJamieAvailable = true;
                    } else {
                        isPossible = false;
                        break;
                    }
                }
            }

            if (isPossible) {
                System.out.printf("Case #%d: %s\n", currentTest++, new String(result));
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", currentTest++);
            }
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public InputReader(FileReader stream) {
            reader = new BufferedReader(stream);
            tokenizer = null;
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}