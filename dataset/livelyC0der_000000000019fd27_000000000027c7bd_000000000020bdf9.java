import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    
    static class Interval implements Comparable<Interval>{
        int s,e, index;
        
        @Override
        public int compareTo(Interval i) {
            return Integer.compare(this.s, i.s);
        }
    }
    
    private static void inputIntervals(Scanner sc, Interval[] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            intervals[i] = new Interval();
            intervals[i].s = sc.nextInt();
            intervals[i].e = sc.nextInt();
            intervals[i].index = i;
        }
    }
    
    private static String getSchedule(Interval[] intervals) {
        Arrays.sort(intervals);
        int N = intervals.length;
        boolean isCameronFree = true;
        boolean isJamieFree = true;
        int cameronEndTime = 0, jamieEndTime = 0;
        char[] output = new char[N];
        for (int i = 0; i < intervals.length; i++) {
            // Try to make Cameron free
            if (!isCameronFree && cameronEndTime <= intervals[i].s) {
                isCameronFree = true;
            }
            // Try to make Jamie free
            if (!isJamieFree && jamieEndTime <= intervals[i].s) {
                isJamieFree = true;
            }
            // Try to assign activity to Cameron
            if (isCameronFree) {
                isCameronFree = false;
                cameronEndTime = intervals[i].e;
                output[intervals[i].index] = 'C';
            } 
            // Else try to assign activity to Jamie
            else if (isJamieFree) {
                isJamieFree = false;
                jamieEndTime = intervals[i].e;
                output[intervals[i].index] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(output);
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test = 1; test <= T; test++) {
            int N = sc.nextInt();
            Interval[] intervals = new Interval[N];
            inputIntervals(sc, intervals);
            System.out.printf("Case #%d: %s\n", test, getSchedule(intervals));
        }
        sc.close();
    }
}