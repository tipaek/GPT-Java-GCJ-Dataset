import java.util.*;

class Activity {
    int start;
    int end;
    int index;

    public Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < caseCount; i++) {
            int activityCount = Integer.parseInt(scanner.nextLine());
            int[][] activities = new int[activityCount][2];

            for (int j = 0; j < activityCount; j++) {
                String[] times = scanner.nextLine().split(" ");
                activities[j][0] = Integer.parseInt(times[0]);
                activities[j][1] = Integer.parseInt(times[1]);
            }

            System.out.println(solve(activities, i + 1));
        }
    }

    public static String solve(int[][] at, int index) {
        Activity[] activities = new Activity[at.length];

        for (int i = 0; i < at.length; i++) {
            activities[i] = new Activity(at[i][0], at[i][1], i);
        }

        Arrays.sort(activities, (a, b) -> {
            if (a.start != b.start) {
                return a.start - b.start;
            } else {
                return a.end - b.end;
            }
        });

        Activity c = null;
        Activity j = null;
        char[] result = new char[at.length];

        for (Activity activity : activities) {
            if (c == null || activity.start >= c.end) {
                c = activity;
                result[activity.index] = 'C';
            } else if (j == null || activity.start >= j.end) {
                j = activity;
                result[activity.index] = 'J';
            } else {
                return String.format("Case #%d: IMPOSSIBLE", index);
            }
        }

        return String.format("Case #%d: %s", index, new String(result));
    }
}