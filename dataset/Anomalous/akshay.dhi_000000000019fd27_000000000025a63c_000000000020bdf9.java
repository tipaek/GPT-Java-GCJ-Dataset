import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= testCases; t++) {
            int no = Integer.parseInt(br.readLine());
            List<Interval> intervals = new ArrayList<>();
            
            for (int i = 0; i < no; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(str.nextToken());
                int end = Integer.parseInt(str.nextToken());
                intervals.add(new Interval(start, end));
            }
            
            intervals.sort(Comparator.comparingInt(i -> i.start));
            
            int cEnd = -1, jEnd = -1;
            StringBuilder schedule = new StringBuilder();
            boolean impossible = false;
            
            for (Interval interval : intervals) {
                if (interval.start >= cEnd) {
                    cEnd = interval.end;
                    schedule.append('C');
                } else if (interval.start >= jEnd) {
                    jEnd = interval.end;
                    schedule.append('J');
                } else {
                    impossible = true;
                    break;
                }
            }
            
            if (impossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + schedule.toString());
            }
        }
    }
}

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}