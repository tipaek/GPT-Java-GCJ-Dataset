import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; t++) {
            int activityCount = scanner.nextInt();
            scanner.nextLine();

            int[][] activities = new int[activityCount][2];
            for (int i = 0; i < activityCount; i++) {
                String[] activity = scanner.nextLine().split(" ");
                activities[i][0] = Integer.parseInt(activity[0]);
                activities[i][1] = Integer.parseInt(activity[1]);
            }

            Integer[] indices = new Integer[activityCount];
            for (int i = 0; i < activityCount; i++) {
                indices[i] = i;
            }

            Arrays.sort(indices, Comparator.comparingInt(i -> activities[i][0]));

            int[] cEnd = {0, 0};
            int[] jEnd = {0, 0};
            StringBuilder result = new StringBuilder("C");

            for (int i = 1; i < activityCount; i++) {
                int[] currentActivity = activities[indices[i]];

                if (currentActivity[0] >= cEnd[1]) {
                    cEnd = currentActivity;
                    result.append("C");
                } else if (currentActivity[0] >= jEnd[1]) {
                    jEnd = currentActivity;
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            if (!result.toString().equals("IMPOSSIBLE")) {
                char[] finalResult = new char[activityCount];
                for (int i = 0; i < activityCount; i++) {
                    finalResult[indices[i]] = result.charAt(i);
                }
                result = new StringBuilder(new String(finalResult));
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}