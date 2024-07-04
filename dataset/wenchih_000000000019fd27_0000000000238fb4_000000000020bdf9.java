import java.util.*;
import java.util.Scanner;

/**
 * Created by wenchihhsieh on 2017/4/15.
 */
public class Solution {
    private static class Interval implements Comparable<Interval>{
        int start;
        int end;
        int index;
        int useIndex = 0;
        public int compareTo(Interval interval) {
            return this.start - interval.start;
        }
        public Interval(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        for (int k = 1; k <= num; k++) {
            int n = scanner.nextInt();
            Interval intervals[] = new Interval[n];
            for(int i = 0; i < n; i++) {
                intervals[i] = new Interval(i, scanner.nextInt(), scanner.nextInt());
                scanner.nextLine();
            }
            String result = helper(intervals, n);
            System.out.println("Case #" + k + ": " + result);
        }
    }

    static String helper(Interval[] starts, int n) {
        if(n == 0) return "";
        char result[] = new char[n];
        Arrays.sort(starts);
        Interval ends[] = new Interval[n];
        for(int i = 0; i < n; i++){
            ends[i] = starts[i];
        }
        Arrays.sort(ends, new Comparator<Interval> () {
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });
        int use = 1;
        result[starts[0].index] = 'C';
        starts[0].useIndex = 1;
        int start = 1;
        int end = 0;
        while(start < n && end < n) {
            Interval si = starts[start];
            Interval ei = ends[end];

            if(ends[end].end > starts[start].start) {
                if((use & 1) == 0) {
                    use |= 1;
                    si.useIndex = 1;
                    result[si.index] = 'C';
                }else if ((use & 2) == 0) {
                    use |= 2;
                    si.useIndex = 2;
                    result[si.index] = 'J';
                } else {
                    return "IMPOSSIBLE";
                }
                start++;
            } else {
                use -= ei.useIndex;
                end++;
            }
        }
        return new String(result);
    }

}
