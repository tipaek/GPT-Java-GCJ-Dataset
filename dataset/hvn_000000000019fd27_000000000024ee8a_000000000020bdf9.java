import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static final int S = 0;
    public static final int E = 1;

    private static class Activity {
        public int end;
        public boolean who;

        public Activity(int end, boolean who) {
            this.end = end;
            this.who = who;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int cas = 1; cas <= t; ++cas) {
            int n = in.nextInt();

            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][S] = in.nextInt();
                intervals[i][E] = in.nextInt();
            }

            if (intervals.length == 0) {
                System.out.print("Case #" + cas + ": ");
                continue;
            }
            // Min-Heap
            PriorityQueue<Activity> allocator = new PriorityQueue<>(intervals.length,
                    Comparator.comparingInt(p -> p.end));
            int[][] sortIntervals = intervals.clone();
            Arrays.sort(sortIntervals, Comparator.comparingInt(a -> a[S]));
            allocator.add(new Activity(sortIntervals[0][E], true));
            boolean[] who = new boolean[n];
            who[0] = true;
            for (int i = 1; i < n; i++) {
                if (sortIntervals[i][S] >= allocator.peek().end) {
                    Activity poll = allocator.poll();
                    who[i] = poll.who;
                } else {
                    who[i] = !allocator.peek().who;
                }
                allocator.add(new Activity(sortIntervals[i][E], who[i]));
                if (allocator.size() > 2) {
                    break;
                }
            }

            System.out.print("Case #" + cas + ": ");
            if (allocator.size() > 2) {
                System.out.println("IMPOSSIBLE");
            } else {
                Map<String, Character> map = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    char person = who[i] ? 'C' : 'J';
                    map.put(String.valueOf(sortIntervals[i][S]) + "_" + sortIntervals[i][E], person);
                }
                for (int i = 0; i < n; i++) {
                    System.out.print(map.get(String.valueOf(intervals[i][S]) + "_" + intervals[i][E]));
                }
                System.out.println();
            }
        }
    }
}
