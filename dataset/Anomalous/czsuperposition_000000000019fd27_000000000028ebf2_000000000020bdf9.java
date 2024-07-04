import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String[] results = new String[T];

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] activities = new int[N][2];
            int maxEndTime = Integer.MIN_VALUE;

            for (int j = 0; j < N; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
                maxEndTime = Math.max(maxEndTime, activities[j][1]);
            }

            int[][] originalActivities = activities.clone();
            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            boolean isImpossible = false;
            int cCurrent = -1, jCurrent = -1;
            int cEnd = -1, jEnd = -1;
            boolean cBusy = false, jBusy = false;
            char[] activityAssignment = new char[N];
            Set<Integer> completedActivities = new HashSet<>();

            for (int time = 0; time <= maxEndTime; time++) {
                if (time == jEnd) {
                    jBusy = false;
                    activityAssignment[jCurrent] = 'J';
                }
                if (time == cEnd) {
                    cBusy = false;
                    activityAssignment[cCurrent] = 'C';
                }

                for (int k = 0; k < N; k++) {
                    if (!completedActivities.contains(k) && time == activities[k][0]) {
                        completedActivities.add(k);
                        if (cBusy && jBusy) {
                            results[i] = "IMPOSSIBLE";
                            isImpossible = true;
                            break;
                        }
                        if (cBusy) {
                            jBusy = true;
                            jEnd = activities[k][1];
                            jCurrent = k;
                        } else {
                            cBusy = true;
                            cEnd = activities[k][1];
                            cCurrent = k;
                        }
                    }
                }
                if (isImpossible) break;
            }

            if (!isImpossible) {
                StringBuilder schedule = new StringBuilder();
                for (int[] activity : originalActivities) {
                    for (int j = 0; j < N; j++) {
                        if (activities[j][0] == activity[0] && activities[j][1] == activity[1]) {
                            schedule.append(activityAssignment[j]);
                        }
                    }
                }
                results[i] = schedule.toString();
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }
}