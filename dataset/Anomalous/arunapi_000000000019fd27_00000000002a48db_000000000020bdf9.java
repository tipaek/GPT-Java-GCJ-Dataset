import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int CAMERON = 2;
            int JAMIE = 1;
            int BOTH_FREE = -1;
            int CAMERON_FREE = 0;
            int JAMIE_FREE = 1;

            int activityCount = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();
            int[] minuteSchedule = new int[24 * 60 + 1];
            Arrays.fill(minuteSchedule, BOTH_FREE);

            boolean possible = true;

            for (int i = 0; i < activityCount; ++i) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                int whoIsFree = BOTH_FREE;

                for (int minute = start; minute < end; minute++) {
                    if (minuteSchedule[minute] != BOTH_FREE) {
                        whoIsFree = minuteSchedule[minute];
                        break;
                    }
                }

                if (whoIsFree == BOTH_FREE || whoIsFree == CAMERON_FREE) {
                    schedule.append("C");
                    updateSchedule(minuteSchedule, start, end, CAMERON);
                } else if (whoIsFree == JAMIE_FREE) {
                    schedule.append("J");
                    updateSchedule(minuteSchedule, start, end, JAMIE);
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNum + ": " + schedule.toString());
            }
        }
    }

    private static void updateSchedule(int[] minuteSchedule, int start, int end, int person) {
        for (int minute = start; minute < end; minute++) {
            minuteSchedule[minute] = person;
        }
    }
}