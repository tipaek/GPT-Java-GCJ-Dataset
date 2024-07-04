import java.util.*;

public class ParentingPartnering {
    private static final String CAMERON = "C";
    private static final String JAMIE = "J";
    
    public String createSchedule(List<Interval> intervals) {
        StringBuilder sb = new StringBuilder();
        int curr = 0;
        for (int i = 0; i < intervals.size(); i++) {
            if (i > 0 && intervals.get(i).start >= intervals.get(i - 1).end) {
                curr = 1 - curr;
            }
            
            if (curr == 0)
                sb.append(CAMERON);
            else
                sb.append(JAMIE);
        }
        return sb.toString();
    }
    
    public String findSchedule(List<Interval> intervals) {
        int[] overlap = new int[1441]; // 1440 minutes in a day + 1 for end+1 boundary
        
        Collections.sort(intervals, new SortInterval());
        
        for (Interval interval : intervals) {
            overlap[interval.start]++;
            overlap[interval.end]--;
        }
        
        int activeIntervals = 0;
        for (int i = 0; i < overlap.length; i++) {
            activeIntervals += overlap[i];
            if (activeIntervals > 2) {
                return "IMPOSSIBLE";
            }
        }
        
        return createSchedule(intervals);
    }
    
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
            
            ParentingPartnering pp = new ParentingPartnering();
            String ans = pp.findSchedule(intervals);
            System.out.println("Case #" + testcase + ": " + ans);
        }
        
        sc.close();
    }
    
    public static class Interval {
        int start;
        int end;
        
        public Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }
    
    public static class SortInterval implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            if (a.start != b.start) {
                return a.start - b.start;
            } else {
                return a.end - b.end;
            }
        }
    }
}