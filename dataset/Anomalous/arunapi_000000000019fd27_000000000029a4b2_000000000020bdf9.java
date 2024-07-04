import java.util.*;
import java.io.*;

class Solution {
    private static final int J = 1;
    private static final int C = 2;
    private static final int BOTH_ARE_FREE = -1;
    private static final int J_IS_FREE = 1;
    private static final int C_IS_FREE = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int activities = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();
            int[] minuteOfTheDay = new int[25 * 60];
            Arrays.fill(minuteOfTheDay, BOTH_ARE_FREE);

            boolean possible = true;

            for (int j = 0; j < activities; j++) {
                int s = scanner.nextInt();
                int e = scanner.nextInt();
                int whoIsFree = BOTH_ARE_FREE;

                for (int k = s; k <= e; k++) {
                    if (minuteOfTheDay[k] > whoIsFree) {
                        if (minuteOfTheDay[k] == J_IS_FREE) {
                            whoIsFree = J_IS_FREE;
                        } else if (minuteOfTheDay[k] == C_IS_FREE) {
                            whoIsFree = C_IS_FREE;
                        } else {
                            whoIsFree = minuteOfTheDay[k];
                            break;
                        }
                    }
                }

                if (whoIsFree == BOTH_ARE_FREE || whoIsFree == J_IS_FREE) {
                    schedule.append("J");
                    updateSchedule(minuteOfTheDay, s, e, J);
                } else if (whoIsFree == C_IS_FREE) {
                    schedule.append("C");
                    updateSchedule(minuteOfTheDay, s, e, C);
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + schedule.toString());
        }
    }

    private static void updateSchedule(int[] minuteOfTheDay, int s, int e, int scheduledFor) {
        for (int k = s; k <= e; k++) {
            minuteOfTheDay[k] += scheduledFor;
        }
    }
}