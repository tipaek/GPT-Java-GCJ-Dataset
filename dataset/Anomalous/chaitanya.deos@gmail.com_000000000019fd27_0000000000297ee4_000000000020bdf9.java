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
        List<Interval> cameron = new ArrayList<>();
        List<Interval> jamie = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        
        for (Interval interval : intervals) {
            if (addTask(cameron, interval)) {
                cameron.add(interval);
                builder.append('C');
            } else if (addTask(jamie, interval)) {
                jamie.add(interval);
                builder.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return builder.toString();
    }
    
    private static boolean addTask(List<Interval> list, Interval interval) {
        for (Interval item : list) {
            if (overlaps(item, interval)) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean overlaps(Interval first, Interval second) {
        return first.getStart() < second.getEnd() && second.getStart() < first.getEnd();
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