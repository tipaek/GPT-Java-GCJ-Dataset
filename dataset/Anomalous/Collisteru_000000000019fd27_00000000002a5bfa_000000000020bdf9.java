import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int numEvents = scanner.nextInt();
            int[][] cameronSchedule = new int[numEvents][2];
            int[][] jamieSchedule = new int[numEvents][2];
            boolean isImpossible = false;
            StringBuilder schedule = new StringBuilder();

            for (int e = 0; e < numEvents; e++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean canAssignToCameron = true;
                boolean canAssignToJamie = true;

                for (int i = 0; i < e; i++) {
                    if ((cameronSchedule[i][0] < start && start < cameronSchedule[i][1]) ||
                        (cameronSchedule[i][0] < end && end < cameronSchedule[i][1]) ||
                        (start <= cameronSchedule[i][0] && end >= cameronSchedule[i][1]) ||
                        (start == cameronSchedule[i][0] || end == cameronSchedule[i][1])) {
                        canAssignToCameron = false;
                    }

                    if ((jamieSchedule[i][0] < start && start < jamieSchedule[i][1]) ||
                        (jamieSchedule[i][0] < end && end < jamieSchedule[i][1]) ||
                        (start <= jamieSchedule[i][0] && end >= jamieSchedule[i][1]) ||
                        (start == jamieSchedule[i][0] || end == jamieSchedule[i][1])) {
                        canAssignToJamie = false;
                    }
                }

                if (canAssignToCameron) {
                    cameronSchedule[e][0] = start;
                    cameronSchedule[e][1] = end;
                    schedule.append("C");
                } else if (canAssignToJamie) {
                    jamieSchedule[e][0] = start;
                    jamieSchedule[e][1] = end;
                    schedule.append("J");
                } else {
                    isImpossible = true;
                    break;
                }
            }

            System.out.print("Case #" + (t + 1) + ": ");
            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(schedule.toString());
            }
        }

        scanner.close();
    }
}