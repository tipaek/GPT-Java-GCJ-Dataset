import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int[][] schedule = new int[1440][2];
            boolean impossible = false;

            int n = in.nextInt();
            int[][] activities = new int[n][3];
            for (int j = 0; j < n; j++) {
                activities[j][0] = in.nextInt();
                activities[j][1] = in.nextInt();
                activities[j][2] = j;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            int[][] assignment = new int[n][2];
            for (int j = 0; j < n; j++) {
                int start = activities[j][0];
                int end = activities[j][1];
                int index = activities[j][2];
                boolean cameronFree = true;
                boolean jamieFree = true;

                for (int k = start; k < end; k++) {
                    if (schedule[k][0] == 1) {
                        cameronFree = false;
                    }
                    if (schedule[k][1] == 1) {
                        jamieFree = false;
                    }
                }

                if (cameronFree) {
                    for (int k = start; k < end; k++) {
                        schedule[k][0] = 1;
                    }
                    assignment[j] = new int[]{index, 1};
                } else if (jamieFree) {
                    for (int k = start; k < end; k++) {
                        schedule[k][1] = 1;
                    }
                    assignment[j] = new int[]{index, 2};
                } else {
                    impossible = true;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (impossible) {
                result.append("IMPOSSIBLE");
            } else {
                Arrays.sort(assignment, Comparator.comparingInt(a -> a[0]));
                for (int[] a : assignment) {
                    result.append(a[1] == 1 ? "C" : "J");
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}