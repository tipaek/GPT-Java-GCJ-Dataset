import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String[] results = new String[T];

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] activities = new int[N][2];
            for (int j = 0; j < N; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }

            int[][] originalActivities = Arrays.copyOf(activities, activities.length);
            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            boolean impossible = false;
            int cEnd = 0, jEnd = 0;
            String[] assignments = new String[N];
            Map<int[], Integer> activityMap = new HashMap<>();

            for (int j = 0; j < N; j++) {
                activityMap.put(activities[j], j);
            }

            for (int[] activity : activities) {
                if (activity[0] >= cEnd) {
                    cEnd = activity[1];
                    assignments[activityMap.get(activity)] = "C";
                } else if (activity[0] >= jEnd) {
                    jEnd = activity[1];
                    assignments[activityMap.get(activity)] = "J";
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                results[i] = "IMPOSSIBLE";
            } else {
                StringBuilder result = new StringBuilder();
                for (int[] activity : originalActivities) {
                    result.append(assignments[activityMap.get(activity)]);
                }
                results[i] = result.toString();
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }
}