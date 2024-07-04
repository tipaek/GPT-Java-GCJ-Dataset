import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activityCount = scanner.nextInt();
            int[] parentEndTimes = new int[]{-1, -1};

            PriorityQueue<int[]> activitiesQueue = new PriorityQueue<>(activityCount, Comparator.comparingInt(a -> a[0]));
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;

            for (int j = 0; j < activityCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activitiesQueue.add(new int[]{start, end});
            }

            while (!activitiesQueue.isEmpty()) {
                int[] currentActivity = activitiesQueue.poll();

                if (parentEndTimes[0] <= currentActivity[0]) {
                    parentEndTimes[0] = currentActivity[1];
                    schedule.append("C");
                } else if (parentEndTimes[1] <= currentActivity[0]) {
                    parentEndTimes[1] = currentActivity[1];
                    schedule.append("J");
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + schedule);
            }
        }
    }
}