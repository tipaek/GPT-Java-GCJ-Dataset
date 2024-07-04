import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        byte n = in.nextByte();

        short[][][] jobs = new short[n][][];
        short[] activities = new short[n];

        byte[] scheduleJ = new byte[1441];
        byte[] scheduleC = new byte[1441];

        for (byte i = 0; i < n; i++) {
            short activityCount = in.nextShort();
            activities[i] = activityCount;
            jobs[i] = new short[activityCount][2];

            for (short j = 0; j < activityCount; j++) {
                jobs[i][j][0] = in.nextShort();
                jobs[i][j][1] = in.nextShort();
            }
        }

        for (byte i = 0; i < n; i++) {
            System.out.print("Case #" + (i + 1) + ": ");

            Arrays.fill(scheduleJ, (byte) 0);
            Arrays.fill(scheduleC, (byte) 0);

            StringBuilder result = new StringBuilder();
            boolean impossible = false;

            for (short j = 0; j < activities[i]; j++) {
                short start = jobs[i][j][0];
                short end = jobs[i][j][1];
                boolean canAssignJ = true;
                boolean canAssignC = true;

                for (short t = start; t <= end; t++) {
                    if (scheduleJ[t] != 0) {
                        canAssignJ = false;
                    }
                    if (scheduleC[t] != 0) {
                        canAssignC = false;
                    }
                }

                if (canAssignJ) {
                    for (short t = start; t <= end; t++) {
                        scheduleJ[t] = 1;
                    }
                    result.append("J");
                } else if (canAssignC) {
                    for (short t = start; t <= end; t++) {
                        scheduleC[t] = 1;
                    }
                    result.append("C");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            System.out.println(result.toString());
        }
    }
}