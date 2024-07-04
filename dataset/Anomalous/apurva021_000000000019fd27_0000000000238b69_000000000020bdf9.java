import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter w = new PrintWriter(System.out);
        
        int testCases = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(br.readLine());
            List<Interval> intervals = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                intervals.add(new Interval(start, end, i));
            }
            
            intervals.sort(Comparator.comparingInt(interval -> interval.start));
            
            char[] result = new char[n];
            int jFreeTime = 0, cFreeTime = 0;
            boolean possible = true;
            
            for (Interval interval : intervals) {
                if (interval.start >= jFreeTime) {
                    result[interval.index] = 'J';
                    jFreeTime = interval.end;
                } else if (interval.start >= cFreeTime) {
                    result[interval.index] = 'C';
                    cFreeTime = interval.end;
                } else {
                    possible = false;
                    break;
                }
            }
            
            w.print("Case #" + t + ": ");
            if (possible) {
                w.println(new String(result));
            } else {
                w.println("IMPOSSIBLE");
            }
        }
        
        w.flush();
        w.close();
    }
}

class Interval {
    int start, end, index;

    Interval(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}