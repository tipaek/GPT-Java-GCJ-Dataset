import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][3];

            for (int i = 0; i < numActivities; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activities[i][2] = i;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            int[] schedule = new int[1440];
            char[] result = new char[numActivities];
            boolean possible = true;

            for (int i = 0; i < numActivities && possible; i++) {
                int start = activities[i][0];
                int end = activities[i][1];
                int index = activities[i][2];

                boolean cameronFree = true;
                boolean jamieFree = true;

                for (int j = start; j < end; j++) {
                    if (schedule[j] == 1) cameronFree = false;
                    if (schedule[j] == 2) jamieFree = false;
                }

                if (cameronFree) {
                    Arrays.fill(schedule, start, end, 1);
                    result[index] = 'C';
                } else if (jamieFree) {
                    Arrays.fill(schedule, start, end, 2);
                    result[index] = 'J';
                } else {
                    possible = false;
                }
            }

            if (possible) {
                System.out.println("Case #" + caseNumber + ": " + new String(result));
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }
}