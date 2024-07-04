import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(bufferedReader.readLine());
        String[] answers = new String[numberOfTestCases];

        for (int testCase = 0; testCase < numberOfTestCases; testCase++) {
            int activityCount = Integer.parseInt(bufferedReader.readLine());
            int[][] activityTime = new int[activityCount][3];
            int[][] activityAssigned = new int[activityCount][2];

            for (int activity = 0; activity < activityCount; activity++) {
                String[] activitySlot = bufferedReader.readLine().split(" ");
                activityTime[activity][0] = Integer.parseInt(activitySlot[0]);
                activityTime[activity][1] = Integer.parseInt(activitySlot[1]);
                activityTime[activity][2] = activity;
            }

            Arrays.sort(activityTime, Comparator.comparingInt(a -> a[0]));

            int jamesLastEndTime = 0;
            int cameronLastEndTime = -1;

            activityAssigned[0][0] = 1;
            activityAssigned[0][1] = activityTime[0][2];
            jamesLastEndTime = activityTime[0][1];

            boolean possible = true;

            for (int activity = 1; activity < activityCount; activity++) {
                if (activityTime[activity][0] >= jamesLastEndTime) {
                    activityAssigned[activity][0] = 1;
                    activityAssigned[activity][1] = activityTime[activity][2];
                    jamesLastEndTime = activityTime[activity][1];
                } else if (cameronLastEndTime == -1 || activityTime[activity][0] >= cameronLastEndTime) {
                    activityAssigned[activity][0] = 2;
                    activityAssigned[activity][1] = activityTime[activity][2];
                    cameronLastEndTime = activityTime[activity][1];
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                Arrays.sort(activityAssigned, Comparator.comparingInt(a -> a[1]));
                StringBuilder result = new StringBuilder();
                for (int[] assignment : activityAssigned) {
                    result.append(assignment[0] == 1 ? 'J' : 'C');
                }
                answers[testCase] = result.toString();
            } else {
                answers[testCase] = "IMPOSSIBLE";
            }
        }

        for (int i = 0; i < numberOfTestCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + answers[i]);
        }
    }
}