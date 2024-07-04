import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] intervals = new int[N][3];
            for (int i = 0; i < N; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
                intervals[i][2] = i;
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            int[] endTimes = new int[2]; // end times for Cameron and Jamie
            char[] result = new char[N];
            boolean isImpossible = false;

            for (int[] interval : intervals) {
                int startTime = interval[0];
                int endTime = interval[1];
                int index = interval[2];

                if (startTime >= endTimes[0]) {
                    endTimes[0] = endTime;
                    result[index] = 'C';
                } else if (startTime >= endTimes[1]) {
                    endTimes[1] = endTime;
                    result[index] = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }

            String output = isImpossible ? "IMPOSSIBLE" : new String(result);
            System.out.println("Case #" + test_case + ": " + output);
        }
    }
}