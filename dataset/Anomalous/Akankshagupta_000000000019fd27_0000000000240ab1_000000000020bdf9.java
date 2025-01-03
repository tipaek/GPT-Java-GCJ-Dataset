import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        System.out.println("No of cases " + numberOfCases);

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int numberOfActivities = Integer.parseInt(scanner.nextLine());
            System.out.println("No of activities " + numberOfActivities);

            int[] startTimes = new int[numberOfActivities];
            int[] endTimes = new int[numberOfActivities];

            for (int activityIndex = 0; activityIndex < numberOfActivities; activityIndex++) {
                String[] times = scanner.nextLine().split(" ");
                startTimes[activityIndex] = Integer.parseInt(times[0]);
                endTimes[activityIndex] = Integer.parseInt(times[1]);
            }

            for (int activityIndex = 0; activityIndex < numberOfActivities; activityIndex++) {
                System.out.println("startAndEndTime " + startTimes[activityIndex] + " " + endTimes[activityIndex]);
            }

            bubbleSort(endTimes, startTimes);

            int cameron = 0, jamie = -1;
            StringBuilder schedule = new StringBuilder("C");

            for (int activityIndex = 1; activityIndex < numberOfActivities; activityIndex++) {
                if (endTimes[cameron] <= startTimes[activityIndex]) {
                    schedule.append("C");
                    cameron = activityIndex;
                } else if (jamie == -1 || endTimes[jamie] <= startTimes[activityIndex]) {
                    schedule.append("J");
                    jamie = activityIndex;
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + schedule.toString());
        }
        scanner.close();
    }

    private static void bubbleSort(int[] endTimes, int[] startTimes) {
        int n = endTimes.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (endTimes[j] > endTimes[j + 1]) {
                    int tempEnd = endTimes[j];
                    endTimes[j] = endTimes[j + 1];
                    endTimes[j + 1] = tempEnd;

                    int tempStart = startTimes[j];
                    startTimes[j] = startTimes[j + 1];
                    startTimes[j + 1] = tempStart;
                }
            }
        }
    }
}