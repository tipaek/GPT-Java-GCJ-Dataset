import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int scheduleNumber = in.nextInt();

            int[] scheduleC = new int[60 * 24 + 1];
            int[] scheduleJ = new int[60 * 24 + 1];
            String res = "";

            // Iterate over schedule
            for (int j = 0; j < scheduleNumber; j++) {
                int minSchedule = in.nextInt();
                int maxSchedule = in.nextInt();

                if (isScheduleFree(scheduleC, minSchedule, maxSchedule)) {
                    setSchedule(scheduleC, minSchedule, maxSchedule);
                    res = res.concat("C");
                } else if (isScheduleFree(scheduleJ, minSchedule, maxSchedule)) {
                    setSchedule(scheduleJ, minSchedule, maxSchedule);
                    res = res.concat("J");
                } else {
                    res = "IMPOSSIBLE";
                    break;
                }

            }
            System.out.println("Case #" + i + ": " + res);
        }
    }

    private static boolean isScheduleFree(int[] schedule, int min, int max) {
        for (int i = min; i < max; i++) {
            if (schedule[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static void setSchedule(int[] schedule, int min, int max) {
        for (int i = min; i < max; i++) {
            schedule[i] = 1;
        }
    }

}