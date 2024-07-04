import java.util.*;
import java.io.*;
public class Solution {
    
    static class Interval {
        int start;
        int end;
        int pos;
        Interval(int s, int e, int p) {
            start = s;
            end = e;
            pos = p;
        }
    }
    
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int tests = in.nextInt(); 
    for (int i = 1; i <= tests; ++i) {
        int n = in.nextInt();
        StringBuilder sb = new StringBuilder();
        List<Interval> intervals = new ArrayList();
        List<Interval> sortedIntervals = new ArrayList();
        
        // create intervals lists - one to maintain ordering, one for sorting
        for (int j = 0; j < n; j++) {
            int start = in.nextInt();
            int end = in.nextInt();
            Interval interval = new Interval(start, end, j);
            intervals.add(interval);
            sortedIntervals.add(interval);
        }
        
        // sort the interval list by start time
        Collections.sort(sortedIntervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        
        // map to keep track of index -> C/J
        Map<Integer, String> map = new HashMap();

        boolean isPossible = true;
        int cFree = 0;
        int jFree = 0;
        for (int x = 0; x < sortedIntervals.size(); x++) {
            Interval interval = sortedIntervals.get(x);
            if (interval.start >= cFree) {
                cFree = interval.end;
                map.put(interval.pos, "C");
            } else if (interval.start >= jFree) {
                jFree = interval.end;
                map.put(interval.pos, "J");
            } else {
               isPossible = false;
               break;
            }
        }

        if (!isPossible) {
            sb.append("IMPOSSIBLE");
        } else {
            for (int y = 0; y < intervals.size(); y++) {
                Interval interval = intervals.get(y);
                sb.append(map.get(interval.pos));
            }
        }

        System.out.println("Case #" + i + ": " + sb.toString());
    }
  }
}