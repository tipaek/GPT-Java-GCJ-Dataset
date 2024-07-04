import java.util.*;

public class Solution {

    static void assignActivities(int[][] activities) {
        if (activities == null || activities.length == 0) {
            return;
        }

        int numActivities = activities.length;
        int[][] indexedActivities = new int[numActivities][2];

        for (int i = 0; i < numActivities; i++) {
            indexedActivities[i][0] = activities[i][0];
            indexedActivities[i][1] = i;
        }

        Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(indexedActivities, Comparator.comparingInt(a -> a[0]));

        int cameronEnd = -1, jamieEnd = -1;
        StringBuilder schedule = new StringBuilder();
        String[] result = new String[numActivities];

        for (int[] activity : activities) {
            int start = activity[0];
            int end = activity[1];

            if (cameronEnd <= start) {
                cameronEnd = end;
                schedule.append("C");
            } else if (jamieEnd <= start) {
                jamieEnd = end;
                schedule.append("J");
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

        for (int i = 0; i < numActivities; i++) {
            char assigned = schedule.charAt(i);
            result[indexedActivities[i][1]] = Character.toString(assigned);
        }

        for (String res : result) {
            System.out.print(res);
        }
        System.out.println();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            scanner.nextLine();

            int[][] activities = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] input = scanner.nextLine().split(" ");
                activities[i][0] = Integer.parseInt(input[0]);
                activities[i][1] = Integer.parseInt(input[1]);
            }

            System.out.print("Case #" + (t + 1) + ": ");
            assignActivities(activities);
        }

        scanner.close();
    }
}