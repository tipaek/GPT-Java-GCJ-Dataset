import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activityCount = scanner.nextInt();
            scanner.nextLine();

            int[][] activities = new int[activityCount][2];
            for (int i = 0; i < activityCount; i++) {
                String[] activityTimes = scanner.nextLine().split(" ");
                activities[i][0] = Integer.parseInt(activityTimes[0]);
                activities[i][1] = Integer.parseInt(activityTimes[1]);
            }

            int[] cameron = activities[0];
            int[] jamie = {0, 0};
            StringBuilder schedule = new StringBuilder("C");

            for (int i = 1; i < activityCount; i++) {
                if (activities[i][0] >= cameron[1]) {
                    cameron = activities[i];
                    schedule.append("C");
                } else if (activities[i][0] >= jamie[1]) {
                    jamie = activities[i];
                    schedule.append("J");
                } else if (activities[i][1] <= cameron[0]) {
                    schedule.append("C");
                } else if (activities[i][1] <= jamie[0]) {
                    schedule.append("J");
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + schedule.toString());
        }
    }
}