import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.println("Case #" + i + ": " + solve(scanner));
        }
    }

    private static String solve(Scanner scanner) {
        int n = scanner.nextInt();
        int[][] activities = new int[n][3];
        for (int i = 0; i < n; i++) {
            activities[i][0] = scanner.nextInt();
            activities[i][1] = scanner.nextInt();
            activities[i][2] = i;
        }

        Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

        int[] assigned = new int[n];
        int cEndTime = 0, jEndTime = 0;
        for (int[] activity : activities) {
            int start = activity[0];
            int end = activity[1];
            int index = activity[2];
            if (start >= cEndTime) {
                assigned[index] = 'C';
                cEndTime = end;
            } else if (start >= jEndTime) {
                assigned[index] = 'J';
                jEndTime = end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder result = new StringBuilder(n);
        for (int assign : assigned) {
            result.append((char) assign);
        }

        return result.toString();
    }
}