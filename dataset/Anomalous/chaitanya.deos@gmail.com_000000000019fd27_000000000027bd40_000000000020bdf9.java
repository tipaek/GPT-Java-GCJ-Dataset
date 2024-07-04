import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution solution = new Solution();

        while (scanner.hasNext()) {
            int T = scanner.nextInt();

            for (int i = 0; i < T; i++) {
                int N = scanner.nextInt();
                List<Interval> intervals = new ArrayList<>(N);
                for (int j = 0; j < N; j++) {
                    intervals.add(solution.new Interval(scanner.nextInt(), scanner.nextInt()));
                }

                String result = assignTasks(intervals);
                System.out.println(String.format("Case #%d: %s", (i + 1), result));
            }
        }
        scanner.close();
    }

    private static String assignTasks(List<Interval> intervals) {
        StringBuilder builder = new StringBuilder();
        PriorityQueue<Interval> camQueue = new PriorityQueue<>(Comparator.comparing(Interval::getStart));
        PriorityQueue<Interval> jaimeQueue = new PriorityQueue<>(Comparator.comparing(Interval::getStart));

        for (Interval interval : intervals) {
            if (canTakeTask(camQueue, interval)) {
                camQueue.add(interval);
                builder.append('C');
            } else if (canTakeTask(jaimeQueue, interval)) {
                jaimeQueue.add(interval);
                builder.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }
        return builder.toString();
    }

    private static boolean canTakeTask(PriorityQueue<Interval> pq, Interval interval) {
        if (pq.isEmpty()) return true;
        Interval last = pq.peek();
        return last.getEnd() <= interval.getStart();
    }

    class Interval {
        private int start;
        private int end;

        public Interval(int start, int end) {
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
        public String toString() {
            return "[start=" + start + ", end=" + end + "]";
        }
    }
}