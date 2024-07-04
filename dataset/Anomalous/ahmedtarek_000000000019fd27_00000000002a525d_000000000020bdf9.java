import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int[][] masterSchedule = new int[1440][2];
            boolean isImpossible = false;

            int w = in.nextInt();
            int[][] result = new int[w][2];
            int activityCount = 0;

            int[][] activities = new int[w][3];
            for (int j = 0; j < w; j++) {
                activities[j][0] = in.nextInt();
                activities[j][1] = in.nextInt();
                activities[j][2] = activityCount++;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            for (int j = 0; j < w; j++) {
                int start = activities[j][0];
                int end = activities[j][1];
                int activityIndex = activities[j][2];
                boolean cameronFree = true;
                boolean jamieFree = true;

                for (int k = start; k < end; k++) {
                    if (masterSchedule[k][0] == 1) {
                        cameronFree = false;
                        break;
                    }
                }

                if (cameronFree) {
                    for (int k = start; k < end; k++) {
                        masterSchedule[k][0] = 1;
                    }
                    result[j] = new int[]{activityIndex, 1};
                } else {
                    for (int k = start; k < end; k++) {
                        if (masterSchedule[k][1] == 1) {
                            jamieFree = false;
                            break;
                        }
                    }

                    if (jamieFree) {
                        for (int k = start; k < end; k++) {
                            masterSchedule[k][1] = 1;
                        }
                        result[j] = new int[]{activityIndex, 2};
                    } else {
                        isImpossible = true;
                        break;
                    }
                }
            }

            StringBuilder answer = new StringBuilder();
            if (isImpossible) {
                answer.append("IMPOSSIBLE");
            } else {
                Arrays.sort(result, Comparator.comparingInt(a -> a[0]));
                for (int[] res : result) {
                    answer.append(res[1] == 1 ? "C" : "J");
                }
            }

            System.out.println("Case #" + i + ": " + answer);
        }
    }
}