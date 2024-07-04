import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long numberOfCases = scanner.nextLong();

        for (long caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            boolean[] cameronSchedule = new boolean[24 * 60 + 3];
            boolean[] jamieSchedule = new boolean[24 * 60 + 3];
            int numberOfActivities = scanner.nextInt();

            boolean isFeasible = true;
            StringBuilder schedule = new StringBuilder();

            for (int activity = 0; activity < numberOfActivities; activity++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                startTime += 2;
                endTime++;

                // Check if Cameron can take the activity
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
                    // Check if Jamie can take the activity
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
                        isFeasible = false;
                    }
                }
            }

            if (isFeasible) {
                System.out.println(String.format("Case #%d: %s", caseIndex, schedule.toString()));
            } else {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", caseIndex));
            }
        }
    }
}