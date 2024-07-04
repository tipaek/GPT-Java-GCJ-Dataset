import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int[][] schedule = new int[1440][2];
            boolean impossible = false;

            int n = in.nextInt();
            int[][] activities = new int[n][3];
            for (int j = 0; j < n; j++) {
                activities[j][0] = in.nextInt();
                activities[j][1] = in.nextInt();
                activities[j][2] = j;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            int[] result = new int[n];
            for (int[] activity : activities) {
                int start = activity[0];
                int end = activity[1];
                int index = activity[2];
                boolean camAvailable = true;
                boolean jamieAvailable = true;

                for (int k = start; k < end; k++) {
                    if (schedule[k][0] == 1) camAvailable = false;
                    if (schedule[k][1] == 1) jamieAvailable = false;
                }

                if (camAvailable) {
                    for (int k = start; k < end; k++) schedule[k][0] = 1;
                    result[index] = 1;
                } else if (jamieAvailable) {
                    for (int k = start; k < end; k++) schedule[k][1] = 1;
                    result[index] = 2;
                } else {
                    impossible = true;
                    break;
                }
            }

            StringBuilder answer = new StringBuilder();
            if (impossible) {
                answer.append("IMPOSSIBLE");
            } else {
                for (int res : result) {
                    answer.append(res == 1 ? "C" : "J");
                }
            }

            System.out.println("Case #" + i + ": " + answer);
        }
    }
}