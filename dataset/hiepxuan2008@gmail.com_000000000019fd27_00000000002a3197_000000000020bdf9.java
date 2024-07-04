import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = in.nextInt();
            int[][] intervals = new int[N][3];
            for (int i = 0; i < N; i++) {
                intervals[i][0] = in.nextInt();
                intervals[i][1] = in.nextInt();
                intervals[i][2] = i;
            }
            Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) sb.append('#');
            int lastC = 0, lastJ = 0;
            for (int[] interval : intervals) {
                if (interval[0] >= lastC) {
                    sb.setCharAt(interval[2], 'C');
                    lastC = interval[1];
                } else if (interval[0] >= lastJ) {
                    sb.setCharAt(interval[2], 'J');
                    lastJ = interval[1];
                } else {
                    sb.setLength(0);
                    sb.append("IMPOSSIBLE");
                }
            }
            System.out.println("Case #" + tc + ": " + sb.toString());
        }
    }
}