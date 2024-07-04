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

            boolean isImpossible = false;
            int cCurrentActivity = -1, jCurrentActivity = -1;
            int cEndTime = -1, jEndTime = -1;
            boolean cBusy = false, jBusy = false;
            String[] schedule = new String[N];
            Set<Integer> completedActivities = new HashSet<>();

            for (int time = 0; time <= 1440; time++) {
                if (isImpossible) break;

                if (time == jEndTime) {
                    jBusy = false;
                    schedule[jCurrentActivity] = "J";
                }
                if (time == cEndTime) {
                    cBusy = false;
                    schedule[cCurrentActivity] = "C";
                }

                for (int k = 0; k < N; k++) {
                    if (completedActivities.contains(k)) continue;

                    if (time >= activities[k][0] && time <= activities[k][1]) {
                        if (cBusy && jBusy) {
                            results[i] = "IMPOSSIBLE";
                            isImpossible = true;
                            break;
                        }

                        completedActivities.add(k);
                        if (cBusy) {
                            jBusy = true;
                            jEndTime = activities[k][1];
                            jCurrentActivity = k;
                            if (activities[k][0] == activities[k][1]) jBusy = false;
                        } else {
                            cBusy = true;
                            cEndTime = activities[k][1];
                            cCurrentActivity = k;
                            if (activities[k][0] == activities[k][1]) cBusy = false;
                        }
                    }
                }
            }

            if (isImpossible) continue;

            StringBuilder result = new StringBuilder();
            for (int[] original : originalActivities) {
                for (int j = 0; j < N; j++) {
                    if (activities[j][0] == original[0] && activities[j][1] == original[1]) {
                        result.append(schedule[j]);
                    }
                }
            }
            results[i] = result.toString();
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }
}