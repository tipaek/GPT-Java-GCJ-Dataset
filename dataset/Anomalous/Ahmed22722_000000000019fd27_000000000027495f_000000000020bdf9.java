import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
    private static final FastReader in = new FastReader();
    private static final PrintWriter out = new PrintWriter(System.out);

    public static class Task implements Comparable<Task> {
        int start, end;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) {
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = in.nextInt();
            List<Task> tasks = new ArrayList<>();
            char[] schedule = new char[n];
            Map<String, Integer> indexMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                tasks.add(new Task(start, end));
                indexMap.put(start + "," + end, i);
            }

            Collections.sort(tasks);
            int cameronEnd = 0, jamieEnd = 0;
            boolean impossible = false;

            for (Task task : tasks) {
                int start = task.getStart();
                int end = task.getEnd();
                if (start >= cameronEnd) {
                    schedule[indexMap.get(start + "," + end)] = 'C';
                    cameronEnd = end;
                } else if (start >= jamieEnd) {
                    schedule[indexMap.get(start + "," + end)] = 'J';
                    jamieEnd = end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                out.printf("Case #%d: IMPOSSIBLE\n", t);
            } else {
                out.printf("Case #%d: %s\n", t, new String(schedule));
            }
        }
        out.flush();
    }

    private static final class FastReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}