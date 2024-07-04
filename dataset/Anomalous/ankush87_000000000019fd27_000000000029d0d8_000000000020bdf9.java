import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(bufferedReader.readLine());
        String[] answers = new String[numberOfTestCases];

        for (int testCase = 0; testCase < numberOfTestCases; testCase++) {
            int activityCount = Integer.parseInt(bufferedReader.readLine());
            int[][] activities = new int[activityCount][3];

            for (int i = 0; i < activityCount; i++) {
                String[] timeSlots = bufferedReader.readLine().split(" ");
                activities[i][0] = Integer.parseInt(timeSlots[0]);
                activities[i][1] = Integer.parseInt(timeSlots[1]);
                activities[i][2] = i;
            }

            Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));

            int[] assignedTo = new int[activityCount];
            int lastEndJames = 0, lastEndCameron = 0;
            boolean possible = true;

            for (int[] activity : activities) {
                if (activity[0] >= lastEndJames) {
                    assignedTo[activity[2]] = 1; // James
                    lastEndJames = activity[1];
                } else if (activity[0] >= lastEndCameron) {
                    assignedTo[activity[2]] = 2; // Cameron
                    lastEndCameron = activity[1];
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                answers[testCase] = "IMPOSSIBLE";
            } else {
                StringBuilder result = new StringBuilder();
                for (int assign : assignedTo) {
                    result.append(assign == 1 ? 'J' : 'C');
                }
                answers[testCase] = result.toString();
            }
        }

        for (int i = 0; i < numberOfTestCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + answers[i]);
        }
    }
}