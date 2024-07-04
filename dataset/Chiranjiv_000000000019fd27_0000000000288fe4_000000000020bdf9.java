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
    
    public static void createSchedule(List<Interval> intervals, String[] schedule) {
        int curr = 0;
        for (int i=0; i<intervals.size(); i++) {
            if(i>0 && intervals.get(i).start < intervals.get(i-1).end) {
                curr = 1 - curr;
            }
            schedule[intervals.get(i).order] = curr == 0 ? CAMERON : JAMIE;
        }
    }
    
    public static String findSchedule(List<Interval> intervals) {
        int[] overlap = new int[1445];
        Arrays.fill(overlap, 0);
        Collections.sort(intervals, compareIntervals);
        
        for (Interval interval: intervals) {
            overlap[interval.start]++;
            overlap[interval.end+1]--;
        }

        for (int i=1; i<1445; i++) {
            overlap[i] += overlap[i-1];
        }

        for(int i=0; i<overlap.length; i++) {
            if(i< overlap.length-1 && overlap[i] > 2 && overlap[i+1] >= overlap[i])
                return "IMPOSSIBLE";
        }

        String[] schedule = new String[intervals.size()];
        createSchedule(intervals, schedule);
        StringBuilder sb = new StringBuilder("");
        for(String s: schedule) {
            sb.append(s);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        sc.nextLine();
        for(int testcase=1; testcase<=t; testcase++) {
            int n;
            List<Interval> intervals = new ArrayList<Interval>();
            n = sc.nextInt();
            sc.nextLine();
            for(int i=0; i<n; i++) {
                int s,e;
                s = sc.nextInt();
                e = sc.nextInt();
                sc.nextLine();
                Interval interval = new Interval(s,e,i);
                intervals.add(interval);
            }
            String ans = findSchedule(intervals);
            System.out.println("Case #"+testcase+": "+ans);
        }
    }
}

class Interval {
    int start;
    int end;
    int order;

    public Interval(int s, int e, int o) {
        start = s;
        end = e;
        order = o;
    }
}