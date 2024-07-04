import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[] cameronSchedule = new int[1440];
            int[] jamieSchedule = new int[1440];
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;

            for (int jobIndex = 0; jobIndex < n; jobIndex++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                boolean assignedToCameron = true;

                for (int time = startTime; time < endTime; time++) {
                    if (cameronSchedule[time] != 0) {
                        assignedToCameron = false;
                        break;
                    }
                }

                if (assignedToCameron) {
                    schedule.append('C');
                    Arrays.fill(cameronSchedule, startTime, endTime, 1);
                } else {
                    boolean assignedToJamie = true;
                    for (int time = startTime; time < endTime; time++) {
                        if (jamieSchedule[time] != 0) {
                            assignedToJamie = false;
                            break;
                        }
                    }

                    if (assignedToJamie) {
                        schedule.append('J');
                        Arrays.fill(jamieSchedule, startTime, endTime, 1);
                    } else {
                        isImpossible = true;
                        break;
                    }
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + schedule.toString());
            }
        }
    }
}