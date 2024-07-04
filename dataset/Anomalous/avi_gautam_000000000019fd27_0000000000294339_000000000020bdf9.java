import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int[][] timing = new int[N][3];

            in.nextLine();
            for (int r = 0; r < N; r++) {
                String[] rowRead = in.nextLine().split(" ");
                timing[r][0] = Integer.parseInt(rowRead[0]);
                timing[r][1] = Integer.parseInt(rowRead[1]);
                timing[r][2] = r;
            }

            System.out.println("Case #" + i + ": " + scheduleTasks(timing, N));
        }
    }

    public static String scheduleTasks(int[][] intervals, int N) {
        int cEnd = 0, jEnd = 0;
        char[] result = new char[N];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < N; i++) {
            if (intervals[i][0] >= cEnd) {
                result[intervals[i][2]] = 'C';
                cEnd = intervals[i][1];
            } else if (intervals[i][0] >= jEnd) {
                result[intervals[i][2]] = 'J';
                jEnd = intervals[i][1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(result);
    }
}