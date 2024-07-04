import java.util.*;
import java.util.Collections;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++) {
            int N = sc.nextInt();
            List<Interval> intervals = new ArrayList();
            for(int i=0;i<N;i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                Interval interval = new Interval(start, end, i);
                intervals.add(interval);
            }
            Collections.sort(intervals, new IntervalComparator());
            Interval lastC = null;
            Interval lastJ = null;
            boolean impossible = false; 
            for(Interval interval : intervals) {
                //System.out.println(interval.start + " " + interval.end);
                if(lastJ == null) {
                    interval.assingedTo = 'J';
                    lastJ = interval;
                } else {
                    if(interval.start >= lastJ.end) {
                        interval.assingedTo = 'J';
                        lastJ = interval;
                    } else {
                        if(lastC == null) {
                            interval.assingedTo = 'C';
                            lastC = interval;
                        } else {
                            if(interval.start >= lastC.end) {
                                interval.assingedTo = 'C';
                                lastC = interval;
                            } else {
                                impossible = true;
                            }  
                        }  
                    }
                }
            }
            if(impossible) {
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
            } else {
                Collections.sort(intervals, new IntervalComparatorByIndex());
                System.out.print("Case #" + t + ": ");
                for(Interval interval : intervals) {
                    System.out.print(""+ interval.assingedTo);
                }
                System.out.println("");
            }
        }
    }
}
class IntervalComparatorByIndex implements Comparator<Interval> {
    public int compare(Interval i1, Interval i2) {
        return i1.index - i2.index; 
    }
}
class IntervalComparator implements Comparator<Interval> {
    public int compare(Interval i1, Interval i2) {
        return i1.end - i2.end; 
    }
}
class Interval {
    int start;
    int end;
    int index;
    char assingedTo;
    public Interval(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}