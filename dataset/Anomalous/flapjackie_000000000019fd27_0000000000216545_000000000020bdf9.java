import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            Task[] tasks = new Task[n];
            char[] schedule = new char[n];
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                tasks[i] = new Task(scanner.nextInt(), scanner.nextInt(), i);
            }

            Arrays.sort(tasks);
            int[] endTimes = new int[2];

            for (Task task : tasks) {
                if (task.start >= endTimes[0]) {
                    endTimes[0] = task.end;
                    schedule[task.index] = 'C';
                } else if (task.start >= endTimes[1]) {
                    endTimes[1] = task.end;
                    schedule[task.index] = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                writer.printf("Case #%d: IMPOSSIBLE\n", caseNumber);
            } else {
                writer.printf("Case #%d: %s\n", caseNumber, new String(schedule));
            }
        }
        writer.close();
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
            return Integer.compare(this.start, other.start);
        }
    }

    static class FastScanner {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public FastScanner(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        public String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}