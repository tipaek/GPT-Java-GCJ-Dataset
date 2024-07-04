import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] intervals = new int[n][4];
            
            for (int i = 0; i < n; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                intervals[i][0] = Integer.parseInt(str.nextToken());
                intervals[i][1] = Integer.parseInt(str.nextToken());
                intervals[i][2] = i;
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            int cEnd = 0, jEnd = 0;
            boolean possible = true;
            intervals[0][3] = 1;
            cEnd = intervals[0][1];

            for (int i = 1; i < n; i++) {
                if (intervals[i][0] >= cEnd) {
                    cEnd = intervals[i][1];
                    intervals[i][3] = 1;
                } else if (intervals[i][0] >= jEnd) {
                    jEnd = intervals[i][1];
                    intervals[i][3] = 2;
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
            } else {
                Arrays.sort(intervals, Comparator.comparingInt(a -> a[2]));
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    result.append(intervals[i][3] == 1 ? 'C' : 'J');
                }
                System.out.println("Case #" + tc + ": " + result);
            }
        }
        
        out.flush();
        out.close();
    }
}