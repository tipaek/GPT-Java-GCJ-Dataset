import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int tasks = scanner.nextInt();

            int[] startTimes = new int[tasks];
            int[] endTimes = new int[tasks];
            char[] taskAllocations = new char[tasks];
            Arrays.fill(taskAllocations, '@');

            for (int j = 0; j < tasks; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
            }

            boolean isPossible = allocateTasks(startTimes, endTimes, taskAllocations, 'C') 
                              && allocateTasks(startTimes, endTimes, taskAllocations, 'J');

            String result = isPossible ? new String(taskAllocations) : "IMPOSSIBLE";
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static boolean allocateTasks(int[] startTimes, int[] endTimes, char[] taskAllocations, char person) {
        int lastEndTime = 0;

        for (int i = 0; i < startTimes.length; i++) {
            int earliestStartIndex = -1;
            int minStartTimeDiff = Integer.MAX_VALUE;

            for (int j = 0; j < startTimes.length; j++) {
                if (taskAllocations[j] == '@' && startTimes[j] >= lastEndTime) {
                    int startTimeDiff = startTimes[j] - lastEndTime;
                    if (startTimeDiff < minStartTimeDiff) {
                        minStartTimeDiff = startTimeDiff;
                        earliestStartIndex = j;
                    }
                }
            }

            if (earliestStartIndex != -1) {
                taskAllocations[earliestStartIndex] = person;
                lastEndTime = endTimes[earliestStartIndex];
            }
        }

        for (char allocation : taskAllocations) {
            if (allocation == '@') {
                return false;
            }
        }

        return true;
    }
}