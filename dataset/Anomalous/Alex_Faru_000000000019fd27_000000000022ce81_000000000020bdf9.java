import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int counter = 1; counter <= T; counter++) {
            int N = Integer.parseInt(br.readLine());
            List<Interval> intervals = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                intervals.add(new Interval(start, end, i));
            }
            
            intervals.sort(Comparator.comparingInt(a -> a.start));
            
            int C = 0, J = 0;
            boolean impossible = false;
            
            for (Interval interval : intervals) {
                if (C <= interval.start) {
                    C = interval.end;
                    interval.assigned = 'C';
                } else if (J <= interval.start) {
                    J = interval.end;
                    interval.assigned = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }
            
            if (impossible) {
                bw.write("Case #" + counter + ": IMPOSSIBLE\n");
            } else {
                bw.write("Case #" + counter + ": " + buildResultString(intervals) + "\n");
            }
        }
        
        bw.close();
        br.close();
    }

    private static String buildResultString(List<Interval> intervals) {
        char[] result = new char[intervals.size()];
        for (Interval interval : intervals) {
            result[interval.index] = interval.assigned;
        }
        return new String(result);
    }
}

class Interval {
    int start;
    int end;
    int index;
    char assigned;

    Interval(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
        this.assigned = '?';
    }
}