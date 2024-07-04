import java.io.*;
import java.util.*;

public class Solution {

    public static int findMinIndex(int[] endTimes, int[] assigned) {
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < endTimes.length; i++) {
            if (endTimes[i] <= minValue && assigned[i] == 0) {
                minValue = endTimes[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 1; caseNum < numCases + 1; caseNum++) {
            int numActivities = Integer.parseInt(scanner.nextLine());
            int[] startTimes = new int[numActivities];
            int[] endTimes = new int[numActivities];
            int[] assigned = new int[numActivities]; // 0: unassigned, 1: C, 2: J
            String result = "";

            for (int i = 0; i < numActivities; i++) {
                String[] times = scanner.nextLine().split(" ");
                startTimes[i] = Integer.parseInt(times[0]);
                endTimes[i] = Integer.parseInt(times[1]);
            }

            int currentEndC = 0, currentEndJ = 0;
            boolean impossible = false;

            for (int i = 0; i < numActivities; i++) {
                int minIndex = findMinIndex(endTimes, assigned);
                if (i == 0) {
                    assigned[minIndex] = 1;
                    currentEndC = endTimes[minIndex];
                } else {
                    if (startTimes[minIndex] < currentEndC && startTimes[minIndex] < currentEndJ) {
                        result = "IMPOSSIBLE";
                        impossible = true;
                        break;
                    } else if (startTimes[minIndex] >= currentEndC) {
                        assigned[minIndex] = 1;
                        currentEndC = endTimes[minIndex];
                    } else if (startTimes[minIndex] >= currentEndJ) {
                        assigned[minIndex] = 2;
                        currentEndJ = endTimes[minIndex];
                    }
                }
            }

            if (!impossible) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < numActivities; i++) {
                    if (assigned[i] == 1) {
                        sb.append("C");
                    } else if (assigned[i] == 2) {
                        sb.append("J");
                    } else {
                        result = "IMPOSSIBLE";
                        break;
                    }
                }
                if (!result.equals("IMPOSSIBLE")) {
                    result = sb.toString();
                }
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }
        scanner.close();
    }
}