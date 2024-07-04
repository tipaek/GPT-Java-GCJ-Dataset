import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        final String IMPOSSIBLE = "IMPOSSIBLE";
        final char CAMERON = 'C';
        final char JAMIE = 'J';

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        for (int t = 1; t <= cases; ++t) {
            int n = in.nextInt();
            int[][] activities = new int[n][3];

            for (int i = 0; i < n; i++) {
                activities[i][0] = in.nextInt(); // start time
                activities[i][1] = in.nextInt(); // end time
                activities[i][2] = i; // original index
            }

            // Sort activities by start time
            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            boolean isPossible = true;
            int cameronEnd = 0;
            int jamieEnd = 0;
            char[] result = new char[n];

            for (int[] activity : activities) {
                int start = activity[0];
                int end = activity[1];
                int index = activity[2];

                if (start >= cameronEnd) {
                    cameronEnd = end;
                    result[index] = CAMERON;
                } else if (start >= jamieEnd) {
                    jamieEnd = end;
                    result[index] = JAMIE;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + t + ": " + new String(result));
            } else {
                System.out.println("Case #" + t + ": " + IMPOSSIBLE);
            }
        }
    }
}