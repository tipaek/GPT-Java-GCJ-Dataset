import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long numberOfCases = scanner.nextLong();

        for (long caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            boolean[] cameronSchedule = new boolean[24 * 60 + 1];
            boolean[] jamieSchedule = new boolean[24 * 60 + 1];
            int numberOfActivities = scanner.nextInt();

            boolean possible = true;
            StringBuilder schedule = new StringBuilder();

            for (int activityIndex = 0; activityIndex < numberOfActivities; activityIndex++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                boolean cameronAvailable = true;
                for (int time = startTime; time < endTime; time++) {
                    if (cameronSchedule[time]) {
                        cameronAvailable = false;
                        break;
                    }
                }

                if (cameronAvailable) {
                    schedule.append("C");
                    for (int time = startTime; time < endTime; time++) {
                        cameronSchedule[time] = true;
                    }
                } else {
                    boolean jamieAvailable = true;
                    for (int time = startTime; time < endTime; time++) {
                        if (jamieSchedule[time]) {
                            jamieAvailable = false;
                            break;
                        }
                    }

                    if (jamieAvailable) {
                        schedule.append("J");
                        for (int time = startTime; time < endTime; time++) {
                            jamieSchedule[time] = true;
                        }
                    } else {
                        possible = false;
                    }
                }
            }

            if (possible) {
                System.out.printf("Case #%d: %s%n", caseIndex, schedule.toString());
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE%n", caseIndex);
            }
        }
    }
}