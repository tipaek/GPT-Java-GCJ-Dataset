import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long testCases = scanner.nextLong();

        for (long caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            boolean[] cameronSchedule = new boolean[24 * 60 + 3];
            boolean[] jamieSchedule = new boolean[24 * 60 + 3];
            int numActivities = scanner.nextInt();

            boolean isFeasible = true;
            StringBuilder scheduleBuilder = new StringBuilder();

            for (int activity = 0; activity < numActivities; activity++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                startTime += 2;
                endTime++;

                boolean canAssignToCameron = true;
                for (int time = startTime; time <= endTime; time++) {
                    if (cameronSchedule[time]) {
                        canAssignToCameron = false;
                        break;
                    }
                }

                if (canAssignToCameron) {
                    scheduleBuilder.append("C");
                    for (int time = startTime; time <= endTime; time++) {
                        cameronSchedule[time] = true;
                    }
                } else {
                    boolean canAssignToJamie = true;
                    for (int time = startTime; time <= endTime; time++) {
                        if (jamieSchedule[time]) {
                            canAssignToJamie = false;
                            break;
                        }
                    }
                    if (canAssignToJamie) {
                        scheduleBuilder.append("J");
                        for (int time = startTime; time <= endTime; time++) {
                            jamieSchedule[time] = true;
                        }
                    } else {
                        isFeasible = false;
                        break;
                    }
                }
            }

            if (isFeasible) {
                System.out.println(String.format("Case #%d: %s", caseIndex, scheduleBuilder.toString()));
            } else {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", caseIndex));
            }
        }
    }
}