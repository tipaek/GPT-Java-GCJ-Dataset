import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int[][] schedule = new int[1440][2];
            boolean isImpossible = false;

            int activityCount = in.nextInt();
            int[][] activities = new int[activityCount][3];
            int[][] result = new int[activityCount][2];

            for (int j = 0; j < activityCount; j++) {
                activities[j][0] = in.nextInt();
                activities[j][1] = in.nextInt();
                activities[j][2] = j;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            for (int j = 0; j < activityCount; j++) {
                int start = activities[j][0];
                int end = activities[j][1];
                int index = activities[j][2];
                boolean canAssignCameron = true;
                boolean canAssignJamie = true;

                for (int k = start; k < end; k++) {
                    if (schedule[k][0] == 1) {
                        canAssignCameron = false;
                    }
                    if (schedule[k][1] == 1) {
                        canAssignJamie = false;
                    }
                }

                if (canAssignCameron) {
                    for (int k = start; k < end; k++) {
                        schedule[k][0] = 1;
                    }
                    result[j] = new int[]{index, 1};
                } else if (canAssignJamie) {
                    for (int k = start; k < end; k++) {
                        schedule[k][1] = 1;
                    }
                    result[j] = new int[]{index, 2};
                } else {
                    isImpossible = true;
                    break;
                }
            }

            StringBuilder answer = new StringBuilder();
            if (isImpossible) {
                answer.append("IMPOSSIBLE");
            } else {
                Arrays.sort(result, Comparator.comparingInt(a -> a[0]));
                for (int[] res : result) {
                    if (res[1] == 1) {
                        answer.append("C");
                    } else if (res[1] == 2) {
                        answer.append("J");
                    }
                }
            }

            System.out.println("Case #" + i + ": " + answer.toString());
        }
    }
}