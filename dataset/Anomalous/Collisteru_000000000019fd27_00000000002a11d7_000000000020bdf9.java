import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int numEvents = scanner.nextInt();
            int[][] cameronSchedule = new int[numEvents][2];
            int[][] jamieSchedule = new int[numEvents][2];
            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();

            for (int e = 0; e < numEvents; e++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (e == 0) {
                    cameronSchedule[0][0] = start;
                    cameronSchedule[0][1] = end;
                    result.append("C");
                } else {
                    boolean canAssignToCameron = true;
                    boolean canAssignToJamie = true;

                    for (int i = 0; i < e; i++) {
                        if ((cameronSchedule[i][0] < start && start < cameronSchedule[i][1]) || 
                            (cameronSchedule[i][0] < end && end < cameronSchedule[i][1])) {
                            canAssignToCameron = false;
                        }
                        if ((jamieSchedule[i][0] < start && start < jamieSchedule[i][1]) || 
                            (jamieSchedule[i][0] < end && end < jamieSchedule[i][1])) {
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
            }

            System.out.print("Case #" + t + ": ");
            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result.toString());
            }
        }
    }
}