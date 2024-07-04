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
            return this.end - other.end;
        }
    }

    public static void main(String[] args) {
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = in.nextInt();
            List<Task> tasks = new ArrayList<>();
            char[] result = new char[n];
            Map<String, Integer> indexMap = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                indexMap.put(start + "-" + end, i);
                tasks.add(new Task(start, end));
            }
            
            Collections.sort(tasks);
            int cameronEnd = 0, jamieEnd = 0;
            boolean impossible = false;

            for (Task task : tasks) {
                int start = task.getStart();
                int end = task.getEnd();
                int originalIndex = indexMap.get(start + "-" + end);

                if (start >= cameronEnd) {
                    result[originalIndex] = 'C';
                    cameronEnd = end;
                } else if (start >= jamieEnd) {
                    result[originalIndex] = 'J';
                    jamieEnd = end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                out.printf("Case #%d: IMPOSSIBLE\n", t);
            } else {
                out.printf("Case #%d: %s\n", t, new String(result));
            }
        }
        out.flush();
    }

    private static final class FastReader {
        private final BufferedReader reader;
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