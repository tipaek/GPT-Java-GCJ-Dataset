import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] jTasks = new int[n + 1][2];
            int jCount = 0;
            int[][] cTasks = new int[n + 1][2];
            int cCount = 0;
            char[] schedule = new char[n];
            String result = "";
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (result.equals("IMPOSSIBLE")) break;

                int earliestIndex = -1;
                int earliestStart = Integer.MAX_VALUE;

                for (int j = 0; j < n; j++) {
                    if (!visited[j] && startTimes[j] < earliestStart) {
                        earliestStart = startTimes[j];
                        earliestIndex = j;
                    }
                }

                visited[earliestIndex] = true;
                int currentStart = startTimes[earliestIndex];
                int currentEnd = endTimes[earliestIndex];

                boolean canAssignToJ = true;
                for (int k = 0; k < jCount; k++) {
                    if (overlaps(jTasks[k][0], jTasks[k][1], currentStart, currentEnd)) {
                        canAssignToJ = false;
                        break;
                    }
                }

                boolean canAssignToC = true;
                for (int k = 0; k < cCount; k++) {
                    if (overlaps(cTasks[k][0], cTasks[k][1], currentStart, currentEnd)) {
                        canAssignToC = false;
                        break;
                    }
                }

                if (canAssignToJ) {
                    jTasks[jCount][0] = currentStart;
                    jTasks[jCount][1] = currentEnd;
                    jCount++;
                    schedule[earliestIndex] = 'J';
                } else if (canAssignToC) {
                    cTasks[cCount][0] = currentStart;
                    cTasks[cCount][1] = currentEnd;
                    cCount++;
                    schedule[earliestIndex] = 'C';
                } else {
                    result = "IMPOSSIBLE";
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                result = new String(schedule);
            }

            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }

    private static boolean overlaps(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && start2 < end1);
    }
}