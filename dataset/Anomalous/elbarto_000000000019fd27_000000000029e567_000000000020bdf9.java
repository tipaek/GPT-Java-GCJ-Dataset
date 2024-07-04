import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long numberOfCases = scanner.nextLong();

        for (long caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            boolean[] cameronSchedule = new boolean[24 * 60 + 3];
            boolean[] jamieSchedule = new boolean[24 * 60 + 3];
            int numberOfActivities = scanner.nextInt();

            boolean isSchedulePossible = true;
            StringBuilder scheduleBuilder = new StringBuilder();

            for (int activityIndex = 0; activityIndex < numberOfActivities; activityIndex++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                startTime += 2;
                endTime++;

                boolean canCameronDo = true;
                for (int time = startTime; time <= endTime; time++) {
                    if (cameronSchedule[time]) {
                        canCameronDo = false;
                        break;
                    }
                }

                if (canCameronDo) {
                    scheduleBuilder.append("C");
                    for (int time = startTime; time <= endTime; time++) {
                        cameronSchedule[time] = true;
                    }
                } else {
                    boolean canJamieDo = true;
                    for (int time = startTime; time <= endTime; time++) {
                        if (jamieSchedule[time]) {
                            canJamieDo = false;
                            break;
                        }
                    }

                    if (canJamieDo) {
                        scheduleBuilder.append("J");
                        for (int time = startTime; time <= endTime; time++) {
                            jamieSchedule[time] = true;
                        }
                    } else {
                        isSchedulePossible = false;
                        break;
                    }
                }
            }

            if (isSchedulePossible) {
                System.out.println(String.format("Case #%d: %s", caseIndex, scheduleBuilder.toString()));
            } else {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", caseIndex));
            }
        }

        scanner.close();
    }
}