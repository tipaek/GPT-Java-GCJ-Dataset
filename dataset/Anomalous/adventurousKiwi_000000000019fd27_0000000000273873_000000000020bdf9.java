import java.util.Scanner;
import java.util.StringTokenizer;

public class ParentingPartneringReturns {

    public static boolean isFreeSlot(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int activities = Integer.parseInt(scanner.nextLine());
            boolean[] jamieSchedule = new boolean[24 * 60 + 1];
            boolean[] cameronSchedule = new boolean[24 * 60 + 1];
            int[] dayTracker = new int[24 * 60 + 1];

            boolean isImpossible = false;
            StringBuilder resultBuilder = new StringBuilder();

            for (int activityIndex = 0; activityIndex < activities; activityIndex++) {
                StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
                int startTime = Integer.parseInt(tokenizer.nextToken());
                int endTime = Integer.parseInt(tokenizer.nextToken());

                for (int time = startTime; time < endTime; time++) {
                    dayTracker[time]++;
                    if (dayTracker[time] > 2) {
                        isImpossible = true;
                    }
                }

                if (isFreeSlot(jamieSchedule, startTime, endTime)) {
                    for (int time = startTime; time < endTime; time++) {
                        jamieSchedule[time] = true;
                    }
                    resultBuilder.append("J");
                } else {
                    for (int time = startTime; time < endTime; time++) {
                        cameronSchedule[time] = true;
                    }
                    resultBuilder.append("C");
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + (caseIndex + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (caseIndex + 1) + ": " + resultBuilder.toString());
            }
        }
        scanner.close();
    }
}