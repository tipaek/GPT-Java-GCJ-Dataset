import java.util.*;
import java.io.*;

public class Competitive {

    static BufferedReader br;
    static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = nextInt();
            Task[] tasks = new Task[n];
            for (int i = 0; i < n; i++) {
                tasks[i] = new Task(nextInt(), nextInt(), i);
            }

            Arrays.sort(tasks);

            Task cameron = null;
            Task jamie = null;
            boolean[] assignedToJamie = new boolean[n];

            boolean possible = true;
            for (Task task : tasks) {
                if (cameron == null || cameron.end <= task.start) {
                    cameron = task;
                } else if (jamie == null || jamie.end <= task.start) {
                    jamie = task;
                    assignedToJamie[jamie.id] = true;
                } else {
                    System.out.println("Case #" + caseNumber++ + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                StringBuilder result = new StringBuilder();
                for (boolean assigned : assignedToJamie) {
                    result.append(assigned ? 'J' : 'C');
                }
                System.out.println("Case #" + caseNumber++ + ": " + result);
            }
        }
    }

    public static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) throw new IOException();
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static class Task implements Comparable<Task> {
        int start, end, id;

        public Task(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.end, other.end);
        }
    }
}