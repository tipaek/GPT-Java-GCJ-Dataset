import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int J = 1;
            int C = 2;
            int BOTH_ARE_FREE = -1;
            int J_IS_FREE = 1;
            int C_IS_FREE = 0;

            int numberOfActivities = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();
            int[] minuteOfTheDay = new int[25 * 60];
            Arrays.fill(minuteOfTheDay, BOTH_ARE_FREE);

            for (int activityIndex = 0; activityIndex < numberOfActivities; activityIndex++) {
                int whoIsFree = BOTH_ARE_FREE;
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                for (int minute = start; minute <= end; minute++) {
                    if (minuteOfTheDay[minute] <= whoIsFree) {
                        continue;
                    } else if (minuteOfTheDay[minute] == J_IS_FREE) {
                        whoIsFree = J_IS_FREE;
                        continue;
                    } else if (minuteOfTheDay[minute] == C_IS_FREE) {
                        whoIsFree = C_IS_FREE;
                        continue;
                    } else {
                        whoIsFree = minuteOfTheDay[minute];
                        break;
                    }
                }

                if (whoIsFree == BOTH_ARE_FREE || whoIsFree == J_IS_FREE) {
                    schedule.append("J");
                    updateSchedule(minuteOfTheDay, start, end, J);
                } else if (whoIsFree == C_IS_FREE) {
                    schedule.append("C");
                    updateSchedule(minuteOfTheDay, start, end, C);
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + (t + 1) + ": " + schedule);
        }
    }

    private static void updateSchedule(int[] minuteOfTheDay, int start, int end, int scheduledFor) {
        for (int minute = start; minute <= end; minute++) {
            minuteOfTheDay[minute] += scheduledFor;
        }
    }
}