import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t1 = sc.nextInt();

        for (int z = 1; z <= t1; z++) {
            StringBuilder schedule = new StringBuilder();
            int n = sc.nextInt();
            int[][] cActivities = new int[n][2];
            int[][] jActivities = new int[n][2];
            int cCount = 0, jCount = 0;
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                boolean cConflict = false, jConflict = false;

                if (!isPossible) continue;

                for (int h = 0; h < cCount; h++) {
                    if ((cActivities[h][1] > s && cActivities[h][0] <= s) ||
                        (cActivities[h][1] >= e && cActivities[h][0] < e) ||
                        (s <= cActivities[h][0] && e >= cActivities[h][1])) {
                        cConflict = true;
                        break;
                    }
                }

                if (cConflict) {
                    for (int h = 0; h < jCount; h++) {
                        if ((jActivities[h][1] > s && jActivities[h][0] <= s) ||
                            (jActivities[h][1] >= e && jActivities[h][0] < e) ||
                            (s <= jActivities[h][0] && e >= jActivities[h][1])) {
                            jConflict = true;
                            break;
                        }
                    }
                }

                if (!cConflict) {
                    schedule.append('C');
                    cActivities[cCount][0] = s;
                    cActivities[cCount][1] = e;
                    cCount++;
                } else if (!jConflict) {
                    schedule.append('J');
                    jActivities[jCount][0] = s;
                    jActivities[jCount][1] = e;
                    jCount++;
                } else {
                    isPossible = false;
                }
            }

            System.out.println("Case #" + z + ": " + (isPossible ? schedule.toString() : "IMPOSSIBLE"));
        }
    }
}