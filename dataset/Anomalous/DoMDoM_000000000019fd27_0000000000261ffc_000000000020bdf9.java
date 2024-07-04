import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int[][] schedule = new int[1440][2];
            boolean isImpossible = false;

            int w = in.nextInt();
            int[][] activities = new int[w][3];
            for (int j = 0; j < w; j++) {
                activities[j][0] = in.nextInt();
                activities[j][1] = in.nextInt();
                activities[j][2] = j;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            String[] result = new String[w];
            for (int[] activity : activities) {
                int start = activity[0];
                int end = activity[1];
                int index = activity[2];

                boolean cameronFree = true;
                boolean jamieFree = true;

                for (int k = start; k < end; k++) {
                    if (schedule[k][0] == 1) cameronFree = false;
                    if (schedule[k][1] == 1) jamieFree = false;
                }

                if (cameronFree) {
                    Arrays.fill(schedule, start, end, new int[]{1, schedule[start][1]});
                    result[index] = "C";
                } else if (jamieFree) {
                    Arrays.fill(schedule, start, end, new int[]{schedule[start][0], 1});
                    result[index] = "J";
                } else {
                    isImpossible = true;
                    break;
                }
            }

            StringBuilder answer = new StringBuilder();
            if (isImpossible) {
                answer.append("IMPOSSIBLE");
            } else {
                for (String res : result) {
                    answer.append(res);
                }
            }

            System.out.println("Case #" + i + ": " + answer.toString());
        }
    }
}