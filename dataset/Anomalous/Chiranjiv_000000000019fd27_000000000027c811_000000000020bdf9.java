import java.util.*;

public class ParentingPartnering {
    private static final String CAMERON = "C";
    private static final String JAMIE = "J";
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int testcase = 1; testcase <= t; testcase++) {
            int n = sc.nextInt();
            List<Interval> intervals = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                intervals.add(new Interval(s, e));
            }
            
            String result = findSchedule(intervals);
            System.out.println("Case #" + testcase + ": " + result);
        }
        sc.close();
    }
    
    public static String findSchedule(List<Interval> intervals) {
        int[] overlap = new int[1445];
        
        Collections.sort(intervals, new SortInterval());
        
        for (Interval interval : intervals) {
            overlap[interval.start]++;
            overlap[interval.end + 1]--;
        }
        
        int ongoing = 0;
        for (int i = 0; i < overlap.length; i++) {
            ongoing += overlap[i];
            if (ongoing > 2) {
                return "IMPOSSIBLE";
            }
        }
        
        return createSchedule(intervals);
    }
    
    public static String createSchedule(List<Interval> intervals) {
        StringBuilder sb = new StringBuilder();
        int curr = 0;
        
        for (int i = 0; i < intervals.size(); i++) {
            if (i > 0 && intervals.get(i).start >= intervals.get(i - 1).end) {
                curr = 1 - curr;
            }
            
            if (curr == 0) {
                sb.append(CAMERON);
            } else {
                sb.append(JAMIE);
            }
        }
        
        return sb.toString();
    }
    
    static class Interval {
        int start;
        int end;
        
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    static class SortInterval implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            if (a.start != b.start) {
                return a.start - b.start;
            } else {
                return a.end - b.end;
            }
        }
    }
}