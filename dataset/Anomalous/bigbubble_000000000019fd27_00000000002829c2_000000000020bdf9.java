import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] activities = new int[n][4];

            for (int j = 0; j < n; j++) {
                activities[j][0] = sc.nextInt(); // start time
                activities[j][1] = sc.nextInt(); // end time
                activities[j][2] = j; // original index
                activities[j][3] = 0; // assigned person (0 for C, 1 for J)
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            int cEnd = 0, jEnd = 0;
            StringBuilder result = new StringBuilder();

            for (int[] activity : activities) {
                if (cEnd <= activity[0]) {
                    activity[3] = 0; // assign to C
                    cEnd = activity[1];
                } else if (jEnd <= activity[0]) {
                    activity[3] = 1; // assign to J
                    jEnd = activity[1];
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[2]));

            if (!result.toString().equals("IMPOSSIBLE")) {
                for (int[] activity : activities) {
                    result.append(activity[3] == 0 ? "C" : "J");
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}