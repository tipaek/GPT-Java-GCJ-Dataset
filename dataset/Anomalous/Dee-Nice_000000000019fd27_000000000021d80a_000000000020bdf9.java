import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.println("Case #" + i + ": " + solve(scanner));
        }
    }

    static String solve(Scanner scanner) {
        int n = scanner.nextInt();
        int[][] activities = new int[n][3];
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            activities[i][0] = scanner.nextInt(); // start time
            activities[i][1] = scanner.nextInt(); // end time
            activities[i][2] = i; // original index
        }

        Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

        int cEndTime = 0;
        int jEndTime = 0;
        char[] assignments = new char[n];

        for (int[] activity : activities) {
            int start = activity[0];
            int end = activity[1];
            int index = activity[2];

            if (start >= cEndTime) {
                assignments[index] = 'C';
                cEndTime = end;
            } else if (start >= jEndTime) {
                assignments[index] = 'J';
                jEndTime = end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(assignments);
    }
}