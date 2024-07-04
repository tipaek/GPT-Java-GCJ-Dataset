import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][3];

            for (int i = 0; i < numActivities; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activities[i][2] = i;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            char[] schedule = new char[numActivities];
            int cEndTime = 0, jEndTime = 0;
            boolean impossible = false;

            for (int[] activity : activities) {
                if (cEndTime <= activity[0]) {
                    schedule[activity[2]] = 'C';
                    cEndTime = activity[1];
                } else if (jEndTime <= activity[0]) {
                    schedule[activity[2]] = 'J';
                    jEndTime = activity[1];
                } else {
                    impossible = true;
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                    break;
                }
            }

            if (!impossible) {
                System.out.println("Case #" + t + ": " + new String(schedule));
            }
        }
    }
}