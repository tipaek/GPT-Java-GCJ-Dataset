import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int t = 1; t <= testCases; t++) {
                System.out.println("Case #" + t + ": " + processTestCase(scanner));
            }
        }
    }

    private static String processTestCase(Scanner scanner) {
        int activitiesCount = scanner.nextInt();
        int[][] activities = new int[activitiesCount][3];

        for (int i = 0; i < activitiesCount; i++) {
            activities[i][0] = scanner.nextInt();
            activities[i][1] = scanner.nextInt();
            activities[i][2] = i;
        }

        Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

        int lastCameronEnd = 0;
        int lastJamieEnd = 0;
        char[] schedule = new char[activitiesCount];

        for (int[] activity : activities) {
            if (lastCameronEnd <= activity[0]) {
                lastCameronEnd = activity[1];
                schedule[activity[2]] = 'C';
            } else if (lastJamieEnd <= activity[0]) {
                lastJamieEnd = activity[1];
                schedule[activity[2]] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(schedule);
    }
}