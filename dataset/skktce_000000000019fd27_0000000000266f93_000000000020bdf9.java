import java.util.*;
import java.io.*;

public class Solution {
    boolean[] t1;
    boolean[] t2;

    public Solution(int k, Scanner in) {
        int tasks = in.nextInt();
        t1 = new boolean[1440];
        t2 = new boolean[1440];

        int[][] taskTime = new int[tasks][2];
        StringBuilder output = new StringBuilder();
        boolean isInvalid = false;

        for (int i=0; i< tasks; i++) {
            taskTime[i][0] = in.nextInt();
            taskTime[i][1] = in.nextInt();
        }

        System.out.print("Case #" + k + ": ");
        for (int i=0; i< tasks; i++) {
            int startTime = taskTime[i][0];
            int endTime = taskTime[i][1];

            if(isT1AvailbleToSchedule(startTime, endTime)) {
                scheduleTaskInT1(startTime, endTime);
                output.append("J");
            } else if (isT2AvailbleToSchedule(startTime, endTime)) {
                scheduleTaskInT2(startTime, endTime);
                output.append("C");
            } else {
                System.out.println("IMPOSSIBLE");
                isInvalid = true;
                break;
            }
        }

        if (!isInvalid) {
            System.out.println(output.toString());
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k = 1; k <= t; ++k) {
            new Solution(k, in);
        }
    }


    private boolean isT1AvailbleToSchedule(int startTime, int endTime) {
        for (int i=startTime; i<endTime; i++) {
            if (t1[i]) {
                return false;
            }
        }

        return true;
    }

    private void scheduleTaskInT1(int startTime, int endTime) {
        for (int i=startTime; i<endTime; i++) {
            t1[i] = true;
        }
    }

    private boolean isT2AvailbleToSchedule(int startTime, int endTime) {
        for (int i=startTime; i<endTime; i++) {
            if (t2[i]) {
                return false;
            }
        }

        return true;
    }

    private void scheduleTaskInT2(int startTime, int endTime) {
        for (int i=startTime; i<endTime; i++) {
            t2[i] = true;
        }
    }
}