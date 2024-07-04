import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int h = 1; h <= t; h++) {
            int n = sc.nextInt();
            int[] s = new int[n];
            int[] e = new int[n];
            
            for (int i = 0; i < n; i++) {
                s[i] = sc.nextInt();
                e[i] = sc.nextInt();
            }

            boolean isPossible = true;
            StringBuilder answer = new StringBuilder();
            List<Interval> JIntervals = new ArrayList<>();
            List<Interval> CIntervals = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                Interval newInterval = new Interval(s[i], e[i]);
                
                if (isAvailable(newInterval, JIntervals)) {
                    JIntervals.add(newInterval);
                    answer.append("J");
                } else if (isAvailable(newInterval, CIntervals)) {
                    CIntervals.add(newInterval);
                    answer.append("C");
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) {
                System.out.println("Case #" + h + ": " + answer.toString());
            } else {
                System.out.println("Case #" + h + ": IMPOSSIBLE");
            }
        }
        
        sc.close();
    }
    
    public static boolean isAvailable(Interval newInterval, List<Interval> intervals) {
        for (Interval interval : intervals) {
            if (newInterval.overlaps(interval)) {
                return false;
            }
        }
        return true;
    }
}

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    boolean overlaps(Interval other) {
        return !(this.end <= other.start || this.start >= other.end);
    }
}