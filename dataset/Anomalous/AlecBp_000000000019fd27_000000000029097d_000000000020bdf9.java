import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][3];
            char[] schedule = new char[numActivities];

            for (int i = 0; i < numActivities; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activities[i][2] = i;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            int jNextFree = 0, cNextFree = 0;
            boolean possible = true;

            for (int[] activity : activities) {
                int start = activity[0];
                int end = activity[1];
                int index = activity[2];

                if (start >= jNextFree) {
                    schedule[index] = 'J';
                    jNextFree = end;
                } else if (start >= cNextFree) {
                    schedule[index] = 'C';
                    cNextFree = end;
                } else {
                    possible = false;
                    break;
                }
            }

            String result = possible ? new String(schedule) : "IMPOSSIBLE";
            System.out.println("Case #" + (testCase + 1) + ": " + result);
        }
    }
}