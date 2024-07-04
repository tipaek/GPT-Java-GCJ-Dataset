import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader br;
    static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = nextInt();
            Task[] tasks = new Task[n];

            for (int i = 0; i < n; i++) {
                tasks[i] = new Task(nextInt(), nextInt(), i);
            }

            Arrays.sort(tasks);

            Task cTask = null;
            Task jTask = null;
            boolean[] assignedToJ = new boolean[n];

            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                if (cTask == null || cTask.end <= tasks[i].start) {
                    cTask = tasks[i];
                } else if (jTask == null || jTask.end <= tasks[i].start) {
                    jTask = tasks[i];
                    assignedToJ[jTask.id] = true;
                } else {
                    System.out.println("Case #" + caseNumber++ + ": IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                StringBuilder schedule = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    schedule.append(assignedToJ[i] ? 'J' : 'C');
                }
                System.out.println("Case #" + caseNumber++ + ": " + schedule);
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