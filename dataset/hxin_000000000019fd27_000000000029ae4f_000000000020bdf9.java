import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            int N = in.nextInt();
            List<int[]> intervals = new ArrayList();
            for (int i = 0; i < N; ++i) {
                int s = in.nextInt(); int e = in.nextInt();
                intervals.add(new int[]{s,e});
            }
            Collections.sort(intervals, (a,b)->Integer.compare(a[0], b[0]) == 0? Integer.compare(a[1],b[1]) : Integer.compare(a[0], b[0]));
            int C = -1;
            int J = -1;
            StringBuilder sb = new StringBuilder();
            for (int[] interval : intervals) {
                int s = interval[0]; int e = interval[1];
                if(C <= J) {
                    if(s >= C) sb.append('C');
                    else {
                        sb = new StringBuilder();
                        sb.append("IMPOSSIBLE");
                        break;
                    }
                    C = e;
                }
                else {
                    if(s >= J) sb.append('J');
                    else {
                        sb = new StringBuilder();
                        sb.append("IMPOSSIBLE");
                        break;
                    }
                    J = e;
                }
            }

            System.out.println("Case #" + t + ": " + sb.toString());
        }
    }
}