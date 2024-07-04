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
                
                String result = solveCase(intervals);
                System.out.println(String.format("Case #%d: %s", i + 1, result));
            }
        }
        scanner.close();
    }
    
    private static String solveCase(List<Interval> intervals) {
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
        
        List<Interval> list = new ArrayList<>();
        boolean canAdd = true;
        
        while (!pq.isEmpty()) {
            Interval item = pq.poll();
            list.add(item);
            if (isOverlapping(interval, item)) {
                canAdd = false;
                break;
            }
        }
        pq.addAll(list);
        return canAdd;
    }
    
    private static boolean isOverlapping(Interval interval1, Interval interval2) {
        return interval1.getStart() < interval2.getEnd() && interval1.getEnd() > interval2.getStart();
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
        public int hashCode() {
            return Objects.hash(start, end);
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Interval interval = (Interval) obj;
            return start == interval.start && end == interval.end;
        }
        
        @Override
        public String toString() {
            return String.format("[start=%d, end=%d]", start, end);
        }
    }
}