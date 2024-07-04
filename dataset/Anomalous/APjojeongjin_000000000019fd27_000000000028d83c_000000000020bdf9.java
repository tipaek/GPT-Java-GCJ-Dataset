import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int activities = scanner.nextInt();
            int[][] intervals = new int[activities][2];

            for (int i = 0; i < activities; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            StringBuilder schedule = new StringBuilder();
            int endJ = 0, endC = 0;
            boolean possible = true;

            for (int[] interval : intervals) {
                if (interval[0] >= endJ) {
                    endJ = interval[1];
                    schedule.append('J');
                } else if (interval[0] >= endC) {
                    endC = interval[1];
                    schedule.append('C');
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (t + 1) + ": " + schedule.toString());
            }
        }
    }
}