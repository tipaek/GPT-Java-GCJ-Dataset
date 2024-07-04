import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int[][] schedule = new int[1440][2];
            boolean isImpossible = false;

            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][3];
            int[][] result = new int[activityCount][2];

            for (int i = 0; i < activityCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activities[i][2] = i;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            for (int i = 0; i < activityCount; i++) {
                int start = activities[i][0];
                int end = activities[i][1];
                int index = activities[i][2];

                boolean cameronFree = true;
                boolean jamieFree = true;

                for (int j = start; j < end; j++) {
                    if (schedule[j][0] == 1) cameronFree = false;
                    if (schedule[j][1] == 1) jamieFree = false;
                }

                if (cameronFree) {
                    for (int j = start; j < end; j++) {
                        schedule[j][0] = 1;
                    }
                    result[i] = new int[]{index, 1};
                } else if (jamieFree) {
                    for (int j = start; j < end; j++) {
                        schedule[j][1] = 1;
                    }
                    result[i] = new int[]{index, 2};
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
                    answer.append(res[1] == 1 ? "C" : "J");
                }
            }

            System.out.println("Case #" + caseNum + ": " + answer);
        }
    }
}