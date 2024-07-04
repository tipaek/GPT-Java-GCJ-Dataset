import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int numActivities = scanner.nextInt();
            int[] startTimes = new int[numActivities];
            int[] endTimes = new int[numActivities];
            boolean[] assignedToCameron = new boolean[numActivities];

            String schedule = "J";

            for (int j = 0; j < numActivities; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
            }

            boolean assignToCameron = false;
            assignedToCameron[0] = assignToCameron;

            outerLoop:
            for (int j = 1; j < numActivities; j++) {
                int overlapCount = 0;
                for (int k = 0; k < j; k++) {
                    if (startTimes[j] >= endTimes[k] || endTimes[j] <= startTimes[k]) {
                        assignedToCameron[j] = assignToCameron;
                    } else {
                        overlapCount++;
                        if (overlapCount > 1 && (assignedToCameron[k] != assignedToCameron[j])) {
                            overlapCount--;
                        } else {
                            assignToCameron = !assignedToCameron[k];
                            assignedToCameron[j] = assignToCameron;
                        }
                        if (overlapCount > 1) {
                            schedule = "IMPOSSIBLE";
                            break outerLoop;
                        }
                    }
                }
                schedule += assignedToCameron[j] ? "C" : "J";
            }

            System.out.println("Case #" + (t + 1) + ": " + schedule);
        }
    }
}