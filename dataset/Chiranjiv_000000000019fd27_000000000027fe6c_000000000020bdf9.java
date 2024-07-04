import java.util.*;

class ParentingPartnering {
    private static final String CAMERON = "C";
    private static final String JAMIE = "J";

    private static Comparator<Interval> compareIntervals = new Comparator<Interval>() {
        @Override
        public int compare(Interval a, Interval b)
        {
            if(a.start < b.start)
                return -1;
            else if (a.start == b.start) {
                return a.end < b.end ? -1 : 1;
            } else return 1;
        }
    };
    
    public static String createSchedule(List<Interval> intervals) {
        StringBuilder sb = new StringBuilder("");
        int curr = 0;
        for (int i=0; i<intervals.size(); i++) {
            if(i>0 && intervals.get(i).start > intervals.get(i-1).end) {
                curr = 1 - curr;
            }
            
            if(curr == 0)
            sb.append(CAMERON);
            else
            sb.append(JAMIE);
        }
        return sb.toString();
    }
    
    public static String findSchedule(List<Interval> intervals) {
        int[] overlap = new int[1445];
        
        Collections.sort(intervals, compareIntervals);
        
        for (Interval interval: intervals) {
            overlap[interval.start]++;
            overlap[interval.end+1]--;
        }
        
        for (int i=0; i<overlap.length; i++) {
            if(i< overlap.length-1 && overlap[i] > 2 && overlap[i+1] >= overlap[i])
                return "IMPOSSIBLE";
        }
        
        return createSchedule(intervals);
    }
    
    public static void main(String[] args) {
        int t;
        List<Interval> intervals = new ArrayList();
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        sc.nextLine();
        for(int testcase=1; testcase<=t; testcase++) {
            int n;
            n = sc.nextInt();
            sc.nextLine();
            for(int i=0; i<n; i++) {
                int s,e;
                s = sc.nextInt();
                e = sc.nextInt();
                Interval interval = new Interval(s,e);
                intervals.add(interval);
                sc.nextLine();
            }
            String ans = findSchedule(intervals);
            System.out.println("Case #"+testcase+": "+ans);
        }
    }

    public static class Interval {
        int start;
        int end;

        public Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}