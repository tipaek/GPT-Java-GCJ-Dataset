import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int J = 1;
            int C = 2;
            int BOTH_ARE_FREE = -1;
            int J_IS_FREE = 1;
            int C_IS_FREE = 0;

            int activities = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();
            int[] minuteOfTheDay = new int[25 * 60];
            Arrays.fill(minuteOfTheDay, BOTH_ARE_FREE);

            for (int activityCount = 0; activityCount < activities; activityCount++) {
                int whoIsFree = BOTH_ARE_FREE;
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                for (int k = start; k <= end; k++) {
                    if (minuteOfTheDay[k] <= whoIsFree) {
                        continue;
                    } else {
                        if (minuteOfTheDay[k] == C_IS_FREE) {
                            whoIsFree = C_IS_FREE;
                            continue;
                        } else if (minuteOfTheDay[k] == J_IS_FREE) {
                            whoIsFree = J_IS_FREE;
                            continue;
                        } else {
                            if (minuteOfTheDay[k] == 2 && (k == end || k == start)) {
                                continue;
                            }
                            whoIsFree = minuteOfTheDay[k];
                            break;
                        }
                    }
                }

                if (whoIsFree == BOTH_ARE_FREE || whoIsFree == C_IS_FREE) {
                    schedule.append("C");
                    updateSchedule(minuteOfTheDay, start, end, C);
                } else if (whoIsFree == J_IS_FREE) {
                    schedule.append("J");
                    updateSchedule(minuteOfTheDay, start, end, J);
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + schedule);
        }
    }

    private static void updateSchedule(int[] minuteOfTheDay, int start, int end, int scheduledFor) {
        for (int k = start; k <= end; k++) {
            minuteOfTheDay[k] += scheduledFor;
        }
    }
}