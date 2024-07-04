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

            int[][] original = activities.clone();
            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            boolean isImpossible = false;
            int cActivityIndex = -1;
            int jActivityIndex = -1;
            int cEndTime = -1;
            int jEndTime = -1;
            Set<Integer> completedActivities = new HashSet<>();
            boolean isCWorking = false;
            boolean isJWorking = false;
            String[] assignments = new String[N];

            for (int time = 0; time <= 1440; time++) {
                if (isImpossible) break;

                if (time == jEndTime) {
                    jEndTime = -1;
                    isJWorking = false;
                    assignments[jActivityIndex] = "J";
                }

                if (time == cEndTime) {
                    cEndTime = -1;
                    isCWorking = false;
                    assignments[cActivityIndex] = "C";
                }

                for (int k = 0; k < N; k++) {
                    if (completedActivities.contains(k)) continue;

                    if (time >= activities[k][0] && time < activities[k][1]) {
                        if (isCWorking && isJWorking) {
                            results[i] = "IMPOSSIBLE";
                            isImpossible = true;
                            break;
                        }

                        completedActivities.add(k);

                        if (isCWorking) {
                            isJWorking = true;
                            jEndTime = activities[k][1];
                            jActivityIndex = k;
                        } else {
                            isCWorking = true;
                            cEndTime = activities[k][1];
                            cActivityIndex = k;
                        }
                    }
                }
            }

            if (isImpossible) continue;

            StringBuilder schedule = new StringBuilder();
            for (int[] activity : original) {
                for (int j = 0; j < N; j++) {
                    if (activities[j][0] == activity[0] && activities[j][1] == activity[1]) {
                        schedule.append(assignments[j]);
                    }
                }
            }
            results[i] = schedule.toString();
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }
}