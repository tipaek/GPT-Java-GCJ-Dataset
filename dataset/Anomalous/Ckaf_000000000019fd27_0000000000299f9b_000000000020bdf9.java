import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int numActivities = scanner.nextInt();
            int[] startTimes = new int[numActivities];
            int[] endTimes = new int[numActivities];
            boolean[] isCameron = new boolean[numActivities];
            StringBuilder schedule = new StringBuilder("J");

            for (int j = 0; j < numActivities; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
            }

            boolean currentParent = false;
            isCameron[0] = currentParent;

            outerLoop:
            for (int j = 1; j < numActivities; j++) {
                int overlapCount = 0;

                for (int k = 0; k < j; k++) {
                    if (startTimes[j] >= endTimes[k] || endTimes[j] <= startTimes[k]) {
                        isCameron[j] = currentParent;
                    } else {
                        overlapCount++;
                        if (overlapCount > 1 && (isCameron[k] != isCameron[j])) {
                            overlapCount--;
                        } else {
                            currentParent = !isCameron[k];
                            isCameron[j] = currentParent;
                        }
                        if (overlapCount > 1) {
                            schedule = new StringBuilder("IMPOSSIBLE");
                            break outerLoop;
                        }
                    }
                }
                schedule.append(isCameron[j] ? "C" : "J");
            }

            System.out.println("Case #" + (t + 1) + ": " + schedule);
        }
        scanner.close();
    }
}