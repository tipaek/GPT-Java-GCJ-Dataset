import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numActivities = scanner.nextInt();
            boolean[] cameronSchedule = new boolean[24 * 60];
            boolean[] jamieSchedule = new boolean[24 * 60];
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean canAssignToCameron = true;

                for (int time = start; time < end; time++) {
                    if (cameronSchedule[time]) {
                        canAssignToCameron = false;
                        break;
                    }
                }

                if (canAssignToCameron) {
                    result.append("C");
                    for (int time = start; time < end; time++) {
                        cameronSchedule[time] = true;
                    }
                } else {
                    boolean canAssignToJamie = true;
                    for (int time = start; time < end; time++) {
                        if (jamieSchedule[time]) {
                            canAssignToJamie = false;
                            break;
                        }
                    }

                    if (canAssignToJamie) {
                        result.append("J");
                        for (int time = start; time < end; time++) {
                            jamieSchedule[time] = true;
                        }
                    } else {
                        result.append("Q");
                    }
                }
            }

            if (result.toString().contains("Q")) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}