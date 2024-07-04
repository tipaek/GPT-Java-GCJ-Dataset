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
            short actQty = in.nextShort();
            activities[i] = actQty;
            jobs[i] = new short[actQty][3];

            for (short j = 0; j < actQty; j++) {
                jobs[i][j][0] = in.nextShort();
                jobs[i][j][1] = in.nextShort();
                jobs[i][j][2] = j;
            }

            Arrays.sort(jobs[i], Comparator.comparingInt(a -> a[0]));
        }

        for (byte i = 0; i < n; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            Arrays.fill(scheduleJ, (byte) 0);
            Arrays.fill(scheduleC, (byte) 0);

            char[] result = new char[activities[i]];
            boolean error = false;

            for (short j = 0; j < activities[i]; j++) {
                boolean foundJ = true;
                boolean foundC = true;

                for (short k = jobs[i][j][0]; k <= jobs[i][j][1]; k++) {
                    if (scheduleJ[k] != 0) {
                        if (k != jobs[i][j][0] && k != jobs[i][j][1]) foundJ = false;
                        if (k == jobs[i][j][1] && (k == 0 || scheduleJ[k - 1] == 1)) foundJ = false;
                        if (k == jobs[i][j][0] && (k == 1440 || scheduleJ[k + 1] == 1)) foundJ = false;
                    }
                    if (scheduleC[k] != 0) {
                        if (k != jobs[i][j][0] && k != jobs[i][j][1]) foundC = false;
                        if (k == jobs[i][j][1] && (k == 0 || scheduleC[k - 1] == 1)) foundC = false;
                        if (k == jobs[i][j][0] && (k == 1440 || scheduleC[k + 1] == 1)) foundC = false;
                    }
                }

                if (foundJ) {
                    for (short k = jobs[i][j][0]; k <= jobs[i][j][1]; k++) {
                        scheduleJ[k] = 1;
                    }
                    result[jobs[i][j][2]] = 'J';
                } else if (foundC) {
                    for (short k = jobs[i][j][0]; k <= jobs[i][j][1]; k++) {
                        scheduleC[k] = 1;
                    }
                    result[jobs[i][j][2]] = 'C';
                } else {
                    error = true;
                    break;
                }
            }

            if (error) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(new String(result));
            }
        }
    }
}