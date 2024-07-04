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

            int[][] originalActivities = activities.clone();
            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            boolean impossible = false;
            for (int time = activities[0][0]; time <= 1440; time++) {
                int ongoingActivities = 0;
                for (int[] activity : activities) {
                    if (activity[0] <= time && activity[1] > time) {
                        ongoingActivities++;
                    }
                }
                if (ongoingActivities > 2) {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                results[i] = "IMPOSSIBLE";
                continue;
            }

            String[] assignments = new String[N];
            int cEndTime = -1, jEndTime = -1;
            boolean cBusy = false, jBusy = false;
            int cIndex = -1, jIndex = -1;

            for (int time = 0; time <= 1440; time++) {
                if (time == cEndTime) {
                    cBusy = false;
                    assignments[cIndex] = "C";
                    cIndex = -1;
                }
                if (time == jEndTime) {
                    jBusy = false;
                    assignments[jIndex] = "J";
                    jIndex = -1;
                }

                for (int k = 0; k < N; k++) {
                    if (time >= activities[k][0] && time < activities[k][1]) {
                        if (k == cIndex || k == jIndex) continue;
                        if (cBusy) {
                            jBusy = true;
                            jEndTime = activities[k][1];
                            jIndex = k;
                        } else {
                            cBusy = true;
                            cEndTime = activities[k][1];
                            cIndex = k;
                        }
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (int[] originalActivity : originalActivities) {
                for (int j = 0; j < N; j++) {
                    if (Arrays.equals(activities[j], originalActivity)) {
                        result.append(assignments[j]);
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