import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();

            boolean[] cameronSchedule = new boolean[1441];
            boolean[] jamieSchedule = new boolean[1441];
            StringBuilder result = new StringBuilder();

            for (int n = 0; n < N; n++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();

                if (result.toString().equals("IMPOSSIBLE")) {
                    continue;
                }

                if (isTimeSlotAvailable(cameronSchedule, startTime, endTime)) {
                    result.append("C");
                    markTimeSlot(cameronSchedule, startTime, endTime);
                } else if (isTimeSlotAvailable(jamieSchedule, startTime, endTime)) {
                    result.append("J");
                    markTimeSlot(jamieSchedule, startTime, endTime);
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static boolean isTimeSlotAvailable(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private static void markTimeSlot(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }
}