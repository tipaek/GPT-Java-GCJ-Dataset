import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int events = scanner.nextInt();
            int[][] cameronSchedule = new int[events][2];
            int[][] jamieSchedule = new int[events][2];
            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();

            for (int e = 0; e < events; e++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean canAssignToCameron = true;
                boolean canAssignToJamie = true;

                for (int c = 0; c < e; c++) {
                    if ((cameronSchedule[c][0] < start && start < cameronSchedule[c][1]) ||
                        (cameronSchedule[c][0] < end && end < cameronSchedule[c][1]) ||
                        (start <= cameronSchedule[c][0] && end >= cameronSchedule[c][1])) {
                        canAssignToCameron = false;
                    }
                    if ((jamieSchedule[c][0] < start && start < jamieSchedule[c][1]) ||
                        (jamieSchedule[c][0] < end && end < jamieSchedule[c][1]) ||
                        (start < jamieSchedule[c][0] && end > jamieSchedule[c][1])) {
                        canAssignToJamie = false;
                    }
                }

                if (canAssignToCameron) {
                    cameronSchedule[e][0] = start;
                    cameronSchedule[e][1] = end;
                    result.append("C");
                } else if (canAssignToJamie) {
                    jamieSchedule[e][0] = start;
                    jamieSchedule[e][1] = end;
                    result.append("J");
                } else {
                    isImpossible = true;
                    break;
                }
            }

            System.out.print("Case #" + (t + 1) + ": ");
            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result.toString());
            }
        }

        scanner.close();
    }
}