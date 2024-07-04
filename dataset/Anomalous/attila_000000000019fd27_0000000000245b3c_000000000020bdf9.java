import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numActivities = Integer.parseInt(scanner.nextLine());
            char[] schedule = new char[numActivities];
            int[][] activities = new int[numActivities][3];
            for (int i = 0; i < numActivities; i++) {
                String[] input = scanner.nextLine().split(" ");
                activities[i][0] = Integer.parseInt(input[0]);
                activities[i][1] = Integer.parseInt(input[1]);
                activities[i][2] = i;
            }
            Arrays.sort(activities, Comparator.comparingInt(activity -> activity[0]));

            int cameronEnd = -1;
            int jamieEnd = -1;
            boolean isPossible = true;
            for (int i = 0; i < numActivities; i++) {
                if (cameronEnd <= activities[i][0]) {
                    cameronEnd = activities[i][1];
                    schedule[activities[i][2]] = 'C';
                } else if (jamieEnd <= activities[i][0]) {
                    jamieEnd = activities[i][1];
                    schedule[activities[i][2]] = 'J';
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + new String(schedule));
            }
        }
    }
}