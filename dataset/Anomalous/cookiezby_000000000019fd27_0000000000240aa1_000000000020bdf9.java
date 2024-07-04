import java.util.*;

class Solution {

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

    public static String solve(int[][] activities, int index) {
        Map<String, Integer> activityMap = new HashMap<>();
        for (int i = 0; i < activities.length; i++) {
            String key = activities[i][0] + "~" + activities[i][1];
            activityMap.put(key, i);
        }

        Arrays.sort(activities, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        int[] cEnd = null;
        int[] jEnd = null;
        char[] result = new char[activities.length];
        for (int[] activity : activities) {
            String key = activity[0] + "~" + activity[1];
            if (cEnd == null || activity[0] >= cEnd[1]) {
                cEnd = activity;
                result[activityMap.get(key)] = 'C';
            } else if (jEnd == null || activity[0] >= jEnd[1]) {
                jEnd = activity;
                result[activityMap.get(key)] = 'J';
            } else {
                return String.format("Case #%d: IMPOSSIBLE", index);
            }
        }
        return String.format("Case #%d: %s", index, new String(result));
    }
}