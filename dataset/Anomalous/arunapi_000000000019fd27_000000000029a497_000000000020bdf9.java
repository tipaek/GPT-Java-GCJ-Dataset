import java.util.*;
import java.io.*;

class Solution {
    private static final int J = 1;
    private static final int C = 2;
    private static final int BOTH_ARE_FREE = -1;
    private static final int J_IS_FREE = 1;
    private static final int C_IS_FREE = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int activities = in.nextInt();
            StringBuilder schedule = new StringBuilder();
            int[] minuteOfTheDay = new int[25 * 60];
            Arrays.fill(minuteOfTheDay, -1);

            boolean isPossible = true;

            for (int activityCount = 0; activityCount < activities; activityCount++) {
                int s = in.nextInt();
                int e = in.nextInt();
                int WHO_IS_FREE = BOTH_ARE_FREE;

                for (int k = s; k <= e; k++) {
                    if (minuteOfTheDay[k] <= WHO_IS_FREE) {
                        continue;
                    } else if (minuteOfTheDay[k] == J_IS_FREE) {
                        WHO_IS_FREE = J_IS_FREE;
                    } else if (minuteOfTheDay[k] == C_IS_FREE) {
                        WHO_IS_FREE = C_IS_FREE;
                    } else {
                        WHO_IS_FREE = minuteOfTheDay[k];
                        break;
                    }
                }

                if (WHO_IS_FREE == BOTH_ARE_FREE || WHO_IS_FREE == J_IS_FREE) {
                    schedule.append("J");
                    updateSchedule(minuteOfTheDay, s, e, J);
                } else if (WHO_IS_FREE == C_IS_FREE) {
                    schedule.append("C");
                    updateSchedule(minuteOfTheDay, s, e, C);
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + schedule.toString());
        }
    }

    private static void updateSchedule(int[] minuteOfTheDay, int s, int e, int scheduledFor) {
        for (int k = s; k <= e; k++) {
            minuteOfTheDay[k] += scheduledFor;
        }
    }
}