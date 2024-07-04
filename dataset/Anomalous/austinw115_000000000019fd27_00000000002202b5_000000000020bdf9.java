import java.io.*;
import java.util.*;

public class Solution3 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 32768);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[][] intervals = new int[N][2];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                intervals[j][0] = Integer.parseInt(st.nextToken());
                intervals[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            intervals = reSort(intervals);

            StringBuilder result = new StringBuilder();
            boolean possible = true;
            int[] endTimes = new int[2]; // endTimes[0] for J, endTimes[1] for C

            for (int[] interval : intervals) {
                if (interval[0] >= endTimes[0]) {
                    result.append('J');
                    endTimes[0] = interval[1];
                } else if (interval[0] >= endTimes[1]) {
                    result.append('C');
                    endTimes[1] = interval[1];
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                pw.println("Case #" + i + ": " + result);
            } else {
                pw.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
        pw.close();
    }

    private static int[][] reSort(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return 0;
        });
        return intervals;
    }
}