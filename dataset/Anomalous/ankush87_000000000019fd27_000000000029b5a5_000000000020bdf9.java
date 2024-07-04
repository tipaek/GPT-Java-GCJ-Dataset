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

        for (int testCaseInstance = 0; testCaseInstance < numberOfTestCases; testCaseInstance++) {
            int activityCount = Integer.parseInt(bufferedReader.readLine());
            int[][] activityTime = new int[activityCount][2];
            String[] activityAssigned = new String[activityCount];

            for (int i = 0; i < activityCount; i++) {
                String[] activitySlotSplit = bufferedReader.readLine().split(" ");
                activityTime[i][0] = Integer.parseInt(activitySlotSplit[0]);
                activityTime[i][1] = Integer.parseInt(activitySlotSplit[1]);
            }

            Arrays.sort(activityTime, Comparator.comparingInt(o -> o[1]));

            int jamesPreviousActivityEndTime = 0;
            int cameronPreviousActivityEndTime = 0;

            boolean isPossible = true;

            for (int i = 0; i < activityCount; i++) {
                if (activityTime[i][0] >= jamesPreviousActivityEndTime) {
                    activityAssigned[i] = "J";
                    jamesPreviousActivityEndTime = activityTime[i][1];
                } else if (activityTime[i][0] >= cameronPreviousActivityEndTime) {
                    activityAssigned[i] = "C";
                    cameronPreviousActivityEndTime = activityTime[i][1];
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                answers[testCaseInstance] = String.join("", activityAssigned);
            } else {
                answers[testCaseInstance] = "IMPOSSIBLE";
            }
        }

        for (int i = 0; i < numberOfTestCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + answers[i]);
        }
    }
}