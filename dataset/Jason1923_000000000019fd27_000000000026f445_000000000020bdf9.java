import java.util.*;
import java.io.*;

public class Solution {
    public static class Task implements Comparable<Task> {
        int start;
        int end;
        int orderIdx;

        public Task(int start, int end, int orderIdx) {
            this.start = start;
            this.end = end;
            this.orderIdx = orderIdx;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(start, other.start);
        }

        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt(); // # of test cases
        for (int t = 1; t <= tests; t++) {
            // Construct PriorityQueue
            PriorityQueue<Task> queue = new PriorityQueue<>();
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                Task task = new Task(start, end, i);
                queue.add(task);
            }

            // Simulate problem
            char[] charArr = new char[n];
            Task cameron = null;
            Task jamie = null;
            for (int i = 0; i < n; i++) {
                // Remove old task(s)
                Task currTask = queue.poll();
                if (cameron != null && cameron.end <= currTask.start)
                    cameron = null;
                if (jamie != null && jamie.end <= currTask.start)
                    jamie = null;

                // Cameron/Jamie free?
                if (cameron == null) {
                    charArr[currTask.orderIdx] = 'C';
                    cameron = currTask;
                } else if (jamie == null) {
                    charArr[currTask.orderIdx] = 'J';
                    jamie = currTask;
                } else {
                    charArr = "IMPOSSIBLE".toCharArray();
                    break;
                }
            }
            String output = new String(charArr);
            System.out.printf("Case #%d: %s", t, output);
            System.out.println();
        }
    }
}