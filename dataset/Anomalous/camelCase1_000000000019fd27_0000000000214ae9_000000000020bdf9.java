import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        int t = nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = nextInt();
            Task[] tasks = new Task[n];

            for (int i = 0; i < n; i++) {
                tasks[i] = new Task(nextInt(), nextInt(), i);
            }

            Arrays.sort(tasks);

            Task cameron = null;
            Task jamie = null;
            boolean[] assignedToJamie = new boolean[n];

            if (assignTasks(tasks, assignedToJamie, cameron, jamie)) {
                printResult(caseNumber++, assignedToJamie);
            } else {
                System.out.println("Case #" + caseNumber++ + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean assignTasks(Task[] tasks, boolean[] assignedToJamie, Task cameron, Task jamie) {
        for (Task task : tasks) {
            if (cameron == null || cameron.end <= task.start) {
                cameron = task;
            } else if (jamie == null || jamie.end <= task.start) {
                jamie = task;
                assignedToJamie[jamie.id] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    private static void printResult(int caseNumber, boolean[] assignedToJamie) {
        StringBuilder result = new StringBuilder();
        for (boolean isJamie : assignedToJamie) {
            result.append(isJamie ? 'J' : 'C');
        }
        System.out.println("Case #" + caseNumber + ": " + result);
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
            return this.end - other.end;
        }
    }
}