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
        PriorityQueue<Interval> camQueue = new PriorityQueue<>(Comparator.comparing(Interval::getStart));
        PriorityQueue<Interval> jaimeQueue = new PriorityQueue<>(Comparator.comparing(Interval::getStart));
        StringBuilder builder = new StringBuilder();
        
        for (Interval interval : intervals) {
            if (canTakeTask(jaimeQueue, interval)) {
                jaimeQueue.add(interval);
                builder.append('J');
            } else if (canTakeTask(camQueue, interval)) {
                camQueue.add(interval);
                builder.append('C');
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return builder.toString();
    }
    
    private static boolean canTakeTask(PriorityQueue<Interval> pq, Interval interval) {
        if (pq.isEmpty()) return true;
        List<Interval> tempList = new ArrayList<>();
        boolean canAdd = true;
        
        while (!pq.isEmpty()) {
            Interval current = pq.poll();
            tempList.add(current);
            if (isOverlapping(current, interval)) {
                canAdd = false;
                break;
            }
        }
        
        pq.addAll(tempList);
        return canAdd;
    }
    
    private static boolean isOverlapping(Interval a, Interval b) {
        return a.getStart() < b.getEnd() && b.getStart() < a.getEnd();
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
            if (obj instanceof Interval) {
                Interval other = (Interval) obj;
                return this.start == other.start && this.end == other.end;
            }
            return false;
        }
        
        @Override
        public String toString() {
            return String.format("[start=%d, end=%d]", start, end);
        }
    }
}