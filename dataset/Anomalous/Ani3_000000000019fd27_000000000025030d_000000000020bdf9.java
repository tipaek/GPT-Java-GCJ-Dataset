import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int[][] schedule = new int[1440][2];
            boolean impossible = false;
            int w = in.nextInt();
            int[][] activities = new int[w][3];
            int[][] assignments = new int[w][2];

            for (int j = 0; j < w; j++) {
                activities[j][0] = in.nextInt();
                activities[j][1] = in.nextInt();
                activities[j][2] = j;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            for (int j = 0; j < w; j++) {
                int start = activities[j][0];
                int end = activities[j][1];
                int index = activities[j][2];
                boolean cameronFree = true;
                boolean jamieFree = true;

                for (int k = start; k < end; k++) {
                    if (schedule[k][0] == 1) {
                        cameronFree = false;
                        break;
                    }
                }

                if (cameronFree) {
                    for (int k = start; k < end; k++) {
                        schedule[k][0] = 1;
                    }
                    assignments[j] = new int[]{index, 1};
                } else {
                    for (int k = start; k < end; k++) {
                        if (schedule[k][1] == 1) {
                            jamieFree = false;
                            break;
                        }
                    }

                    if (jamieFree) {
                        for (int k = start; k < end; k++) {
                            schedule[k][1] = 1;
                        }
                        assignments[j] = new int[]{index, 2};
                    } else {
                        impossible = true;
                        break;
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            if (impossible) {
                result.append("IMPOSSIBLE");
            } else {
                Arrays.sort(assignments, Comparator.comparingInt(a -> a[0]));
                for (int[] assignment : assignments) {
                    result.append(assignment[1] == 1 ? "C" : "J");
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}