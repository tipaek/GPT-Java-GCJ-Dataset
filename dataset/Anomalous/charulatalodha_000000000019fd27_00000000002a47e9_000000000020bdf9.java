import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        StringBuilder output = new StringBuilder();

        for (int t = 0; t < numberOfTestCases; t++) {
            int numberOfActivities = scanner.nextInt();
            int[][] activities = new int[numberOfActivities][3];

            for (int i = 0; i < numberOfActivities; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activities[i][2] = i;
            }

            output.append("Case #").append(t + 1).append(": ").append(assignActivities(activities)).append("\n");
        }

        System.out.print(output.toString());
        scanner.close();
    }

    private static String assignActivities(int[][] activities) {
        int numberOfActivities = activities.length;
        Arrays.sort(activities, (a, b) -> Integer.compare(a[0], b[0]));

        int cEndTime = 0, jEndTime = 0;
        char[] assigned = new char[numberOfActivities];

        for (int[] activity : activities) {
            if (activity[0] >= cEndTime) {
                cEndTime = activity[1];
                assigned[activity[2]] = 'C';
            } else if (activity[0] >= jEndTime) {
                jEndTime = activity[1];
                assigned[activity[2]] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(assigned);
    }
}