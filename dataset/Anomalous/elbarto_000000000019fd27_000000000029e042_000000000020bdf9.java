import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long numberOfCases = scanner.nextLong();

        for (long caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            boolean[] cameronSchedule = new boolean[24 * 60 + 3];
            boolean[] jamieSchedule = new boolean[24 * 60 + 3];
            int numberOfActivities = scanner.nextInt();

            boolean possible = true;
            StringBuilder schedule = new StringBuilder();

            for (int activityIndex = 0; activityIndex < numberOfActivities; activityIndex++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                startTime += 2;
                endTime++;

                boolean cameronAvailable = true;
                for (int time = startTime; time <= endTime; time++) {
                    if (cameronSchedule[time]) {
                        cameronAvailable = false;
                        break;
                    }
                }

                if (cameronAvailable) {
                    schedule.append("C");
                    for (int time = startTime; time <= endTime; time++) {
                        cameronSchedule[time] = true;
                    }
                } else {
                    boolean jamieAvailable = true;
                    for (int time = startTime; time <= endTime; time++) {
                        if (jamieSchedule[time]) {
                            jamieAvailable = false;
                            break;
                        }
                    }
                    if (jamieAvailable) {
                        schedule.append("J");
                        for (int time = startTime; time <= endTime; time++) {
                            jamieSchedule[time] = true;
                        }
                    } else {
                        possible = false;
                        break;
                    }
                }
            }

            if (possible) {
                System.out.println("Case #" + caseIndex + ": " + schedule.toString());
            } else {
                System.out.println("Case #" + caseIndex + ": IMPOSSIBLE");
            }
        }
        scanner.close();
    }
}