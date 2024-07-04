import java.io.*;
import java.util.*;

public class Solution {

    public static int findMinIndex(int[] endTimes, int[] assignments) {
        int minTime = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < endTimes.length; i++) {
            if (endTimes[i] <= minTime && assignments[i] == 0) {
                minTime = endTimes[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int taskCount = Integer.parseInt(scanner.nextLine());
            int[] startTimes = new int[taskCount];
            int[] endTimes = new int[taskCount];
            int[] assignments = new int[taskCount];
            StringBuilder result = new StringBuilder();

            for (int taskIndex = 0; taskIndex < taskCount; taskIndex++) {
                String[] times = scanner.nextLine().split(" ");
                startTimes[taskIndex] = Integer.parseInt(times[0]);
                endTimes[taskIndex] = Integer.parseInt(times[1]);
            }

            int cameronEnd = 0, jamieEnd = 0;

            outerLoop:
            for (int taskIndex = 0; taskIndex < taskCount; taskIndex++) {
                int minIndex = findMinIndex(endTimes, assignments);

                if (taskIndex == 0) {
                    assignments[minIndex] = 1;
                    cameronEnd = endTimes[minIndex];
                } else {
                    if (startTimes[minIndex] < cameronEnd && startTimes[minIndex] < jamieEnd) {
                        result = new StringBuilder("IMPOSSIBLE");
                        break outerLoop;
                    } else if (startTimes[minIndex] < cameronEnd && startTimes[minIndex] >= jamieEnd) {
                        assignments[minIndex] = 2;
                        jamieEnd = endTimes[minIndex];
                    } else if (startTimes[minIndex] < jamieEnd && startTimes[minIndex] >= cameronEnd) {
                        assignments[minIndex] = 1;
                        cameronEnd = endTimes[minIndex];
                    } else {
                        if (startTimes[minIndex] - cameronEnd > startTimes[minIndex] - jamieEnd) {
                            assignments[minIndex] = 2;
                            jamieEnd = endTimes[minIndex];
                        } else {
                            assignments[minIndex] = 1;
                            cameronEnd = endTimes[minIndex];
                        }
                    }
                }
            }

            if (!result.toString().equals("IMPOSSIBLE")) {
                for (int taskIndex = 0; taskIndex < taskCount; taskIndex++) {
                    if (assignments[taskIndex] == 0) {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    } else if (assignments[taskIndex] == 1) {
                        result.append("C");
                    } else {
                        result.append("J");
                    }
                }
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + result);
        }
    }
}