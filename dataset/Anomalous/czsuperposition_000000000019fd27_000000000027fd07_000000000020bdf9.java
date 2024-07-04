import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String[] results = new String[T];

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[][] activities = new int[N][2];
            int[][] originalActivities = new int[N][2];

            for (int i = 0; i < N; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                originalActivities[i] = Arrays.copyOf(activities[i], 2);
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));
            boolean impossible = false;
            int cEnd = -1, jEnd = -1;
            String[] assignments = new String[N];
            Map<int[], Integer> activityIndexMap = new HashMap<>();

            for (int i = 0; i < N; i++) {
                activityIndexMap.put(originalActivities[i], i);
            }

            for (int i = 0; i < N; i++) {
                int start = activities[i][0];
                int end = activities[i][1];

                if (start >= cEnd) {
                    cEnd = end;
                    assignments[i] = "C";
                } else if (start >= jEnd) {
                    jEnd = end;
                    assignments[i] = "J";
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                results[t] = "IMPOSSIBLE";
            } else {
                StringBuilder schedule = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    int originalIndex = activityIndexMap.get(originalActivities[i]);
                    schedule.append(assignments[originalIndex]);
                }
                results[t] = schedule.toString();
            }
        }

        for (int t = 0; t < T; t++) {
            System.out.println("Case #" + (t + 1) + ": " + results[t]);
        }
    }
}