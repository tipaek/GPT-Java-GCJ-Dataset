import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
   public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] intervals = new int[n][2];
            for (int ints = 0; ints < n; ints++) {
                int start = in.nextInt();
                int end = in.nextInt();
                intervals[ints][0] = start;
                intervals[ints][1] = end;
            }
            System.out.println(String.format("Case #%d: %s", i, getSchedule(intervals)));
        }
    }

    private static String getSchedule(int[][] intervals) {
        int[][] original = intervals.clone();
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        StringBuilder schedule = new StringBuilder();
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> a.end - b.end);
        Interval x = new Interval(intervals[0][0], intervals[0][1], "C");
        minHeap.add(x);
        List<Interval> listInt = new ArrayList<>();
        for (int i = 1; i < intervals.length; ++i) {
            if (minHeap.peek().end <= intervals[i][0]) listInt.add(minHeap.poll());
            String name = minHeap.peek() != null ? minHeap.peek().name.equalsIgnoreCase("C") ? "J" : "C" : "C";
            Interval toAdd = new Interval(intervals[i][0], intervals[i][1], name);
            minHeap.add(toAdd);
        }
        if (minHeap.size() > 2) return "IMPOSSIBLE";
        while(!minHeap.isEmpty()) {
            listInt.add(minHeap.poll());
        }
        for (int[] interval : original){
            for (Interval intvl : listInt){
                if (interval[0] == intvl.start && interval[1] == intvl.end) schedule.append(intvl.name);
            }
        }
        return schedule.toString();
    }

    static class Interval {
        int start, end;
        String name;
        public Interval(int start, int end, String name) {
            this.start = start;
            this.end = end;
            this.name = name;
        }
    }


}