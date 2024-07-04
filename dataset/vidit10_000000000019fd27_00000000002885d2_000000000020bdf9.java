import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    static class Interval{
        int start;
        int end;
        int ind;
        Interval(int start, int end, int ind){
            this.start=start;
            this.end=end;
            this.ind=ind;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i1 = 1; i1 <= t; ++i1) {
            int n = in.nextInt();
            Interval[] intervals = new Interval[n];
            for(int i=0;i<n;i++){
                int s = in.nextInt();
                int e = in.nextInt();
                intervals[i] = new Interval(s, e, i);
            }
            Stack<Interval> c = new Stack<>();
            Stack<Interval> j = new Stack<>();

            Arrays.sort(intervals, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    return o1.end - o2.end;
                }
            });

            c.push(intervals[0]);
            boolean isImpossible=false;
            String[] ans = new String[n];
            ans[intervals[0].ind] = "C";
            for(int i=1;i<n;i++){
                //System.out.println(i + " " +  intervals[i].ind + " " + intervals[i].start + " " + intervals[i].end);
                if(!overlap(c.peek(), intervals[i])){
                    c.push(intervals[i]);
                    ans[intervals[i].ind] = "C";
                }else if(j.isEmpty() || !overlap(j.peek(), intervals[i])){
                    j.push(intervals[i]);
                    ans[intervals[i].ind] = "J";
                }else{
                    isImpossible=true;
                    break;
                }
            }

            if(isImpossible){
                System.out.println("Case #" + i1 + ": IMPOSSIBLE");
            }else{
                StringBuilder s = new StringBuilder("");
                for(int i=0;i<n;i++){
                    s.append(ans[i]);
                }
                System.out.println("Case #" + i1 + ": " + s.toString());
            }
        }
    }

    private static boolean overlap(Interval peek, Interval interval) {
        return interval.start < peek.end;
    }
}
