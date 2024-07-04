import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long numberOfCases = scanner.nextLong();

        for (long caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            boolean[] cameronSchedule = new boolean[24 * 60];
            boolean[] jamieSchedule = new boolean[24 * 60];
            int numberOfActivities = scanner.nextInt();

            boolean assignmentPossible = true;
            StringBuilder schedule = new StringBuilder();

            for (int activityIndex = 0; activityIndex < numberOfActivities; activityIndex++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                boolean canAssignToCameron = true;
                for (int time = startTime; time < endTime; time++) {
                    if (cameronSchedule[time]) {
                        canAssignToCameron = false;
                        break;
                    }
                }

                if (canAssignToCameron) {
                    schedule.append("C");
                    for (int time = startTime; time < endTime; time++) {
                        cameronSchedule[time] = true;
                    }
                } else {
                    boolean canAssignToJamie = true;
                    for (int time = startTime; time < endTime; time++) {
                        if (jamieSchedule[time]) {
                            canAssignToJamie = false;
                            break;
                        }
                    }

                    if (canAssignToJamie) {
                        schedule.append("J");
                        for (int time = startTime; time < endTime; time++) {
                            jamieSchedule[time] = true;
                        }
                    } else {
                        assignmentPossible = false;
                        break;
                    }
                }
            }

            if (assignmentPossible) {
                System.out.printf("Case #%d: %s%n", caseIndex, schedule.toString());
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE%n", caseIndex);
            }
        }
    }
}