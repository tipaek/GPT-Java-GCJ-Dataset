import java.util.*;

public class Solution {

    public static void main(String[] args) {
        performCalculations();
    }

    public static void performCalculations() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int numberOfActivities = scanner.nextInt();
            int[] startTimes = new int[numberOfActivities];
            int[] endTimes = new int[numberOfActivities];

            for (int i = 0; i < numberOfActivities; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            List<Integer> cameronSchedule = new ArrayList<>(Collections.nCopies(findMaxTime(startTimes, endTimes), 0));
            List<Integer> jamieSchedule = new ArrayList<>(Collections.nCopies(cameronSchedule.size(), 0));
            StringBuilder assignment = new StringBuilder();

            boolean isImpossible = false;

            for (int i = 0; i < numberOfActivities; i++) {
                if (isAvailable(cameronSchedule, startTimes[i], endTimes[i])) {
                    assignTime(cameronSchedule, startTimes[i], endTimes[i]);
                    assignment.append("C");
                } else if (isAvailable(jamieSchedule, startTimes[i], endTimes[i])) {
                    assignTime(jamieSchedule, startTimes[i], endTimes[i]);
                    assignment.append("J");
                } else {
                    isImpossible = true;
                    break;
                }
            }

            int caseNumber = t + 1;
            if (isImpossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + assignment.toString());
            }
        }
    }

    private static int findMaxTime(int[] startTimes, int[] endTimes) {
        int maxTime = 0;
        for (int time : startTimes) {
            if (time > maxTime) {
                maxTime = time;
            }
        }
        for (int time : endTimes) {
            if (time > maxTime) {
                maxTime = time;
            }
        }
        return maxTime;
    }

    private static boolean isAvailable(List<Integer> schedule, int startTime, int endTime) {
        for (int i = startTime; i < endTime; i++) {
            if (schedule.get(i) != 0) {
                return false;
            }
        }
        return true;
    }

    private static void assignTime(List<Integer> schedule, int startTime, int endTime) {
        for (int i = startTime; i < endTime; i++) {
            schedule.set(i, 1);
        }
    }
}