import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activityCount = scanner.nextInt();
            int[] startTimes = new int[activityCount];
            int[] endTimes = new int[activityCount];
            char[] assignments = new char[activityCount];
            int[] sortedStartTimes = new int[activityCount];

            for (int i = 0; i < activityCount; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
                sortedStartTimes[i] = startTimes[i];
            }

            Arrays.sort(sortedStartTimes);
            boolean isImpossible = false;
            int cameronEndTime = 0, jamieEndTime = 0;

            for (int i = 0; i < activityCount; i++) {
                int currentStartTime = sortedStartTimes[i];
                int index = -1;

                for (int j = 0; j < activityCount; j++) {
                    if (startTimes[j] == currentStartTime) {
                        index = j;
                        break;
                    }
                }

                if (startTimes[index] >= jamieEndTime) {
                    assignments[index] = 'J';
                    jamieEndTime = endTimes[index];
                } else if (startTimes[index] >= cameronEndTime) {
                    assignments[index] = 'C';
                    cameronEndTime = endTimes[index];
                } else {
                    isImpossible = true;
                    break;
                }
            }

            System.out.print("Case #" + testCase + ": ");
            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (char assignment : assignments) {
                    System.out.print(assignment);
                }
                System.out.println();
            }
        }
    }
}