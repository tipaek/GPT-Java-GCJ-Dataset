import java.util.*;
import java.io.*;

class Scheduler {

    public String scheduleTasks(List<Task> tasks) {
        tasks.sort(Comparator.comparingInt(a -> a.start));
        int jTime = 0;
        int cTime = 0;
        char[] result = new char[tasks.size()];

        for (Task task : tasks) {
            int startTime = task.start;
            int endTime = task.end;
            int idx = task.idx;

            if (startTime >= jTime) {
                jTime = endTime;
                result[idx] = 'J';
            } else if (startTime >= cTime) {
                cTime = endTime;
                result[idx] = 'C';
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(result);
    }
}

class Task {
    int start;
    int end;
    int idx;

    public Task(int start, int end, int idx) {
        this.start = start;
        this.end = end;
        this.idx = idx;
    }
}

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int tests = in.nextInt();

        for (int tt = 1; tt <= tests; tt++) {
            Scheduler scheduler = new Scheduler();
            int n = in.nextInt();
            List<Task> tasks = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                tasks.add(new Task(start, end, i));
            }

            out.print("Case #" + tt + ": ");
            out.println(scheduler.scheduleTasks(tasks));
        }
        out.close();
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

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
    }
}