import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long numCases = scanner.nextLong();

        for (long caseIndex = 1; caseIndex <= numCases; caseIndex++) {
            boolean[] cameronSchedule = new boolean[24 * 60 + 3];
            boolean[] jamieSchedule = new boolean[24 * 60 + 3];
            int numActivities = scanner.nextInt();

            boolean possible = true;
            StringBuilder result = new StringBuilder();

            for (int activityIndex = 0; activityIndex < numActivities; activityIndex++) {
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
                    result.append("C");
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
                        result.append("J");
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
                System.out.println(String.format("Case #%d: %s", caseIndex, result.toString()));
            } else {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", caseIndex));
            }
        }
    }
}