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
                List<Interval> intervals = new ArrayList<>();
                
                for (int j = 0; j < N; j++) {
                    intervals.add(solution.new Interval(scanner.nextInt(), scanner.nextInt()));
                }
                
                intervals.sort(Comparator.comparing(Interval::getStart));
                
                String result = solution.assignTasks(intervals);
                System.out.println(String.format("Case #%d: %s", (i + 1), result));
            }
        }
        
        scanner.close();
    }
    
    private String assignTasks(List<Interval> intervals) {
        StringBuilder builder = new StringBuilder();
        if (intervals.size() == 0) return "IMPOSSIBLE";
        
        Interval cameron = intervals.get(0);
        Interval jamie = intervals.size() > 1 ? intervals.get(1) : null;
        
        builder.append("C");
        if (jamie != null) builder.append("J");
        
        for (int k = 2; k < intervals.size(); k++) {
            Interval interval = intervals.get(k);
            if (interval.getStart() >= cameron.getEnd()) {
                builder.append('C');
                cameron = interval;
            } else if (jamie != null && interval.getStart() >= jamie.getEnd()) {
                builder.append('J');
                jamie = interval;
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return builder.toString();
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