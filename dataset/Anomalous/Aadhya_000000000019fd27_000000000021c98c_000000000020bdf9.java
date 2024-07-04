import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        String[] results = new String[numTestCases];

        for (int testCase = 0; testCase < numTestCases; testCase++) {
            int numTasks = scanner.nextInt();
            int[][] tasks = new int[numTasks][2];
            int[][] events = new int[2 * numTasks][2];
            int eventIndex = 0;

            for (int i = 0; i < numTasks; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
                events[eventIndex++] = new int[]{tasks[i][0], 1};  // Start event
                events[eventIndex++] = new int[]{tasks[i][1], -1}; // End event
            }

            Arrays.sort(events, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

            int concurrentTasks = 0;
            boolean isPossible = true;
            for (int[] event : events) {
                concurrentTasks += event[1];
                if (concurrentTasks > 2) {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                results[testCase] = "IMPOSSIBLE";
                continue;
            }

            Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));
            int[] cEnd = {0};
            int[] jEnd = {0};
            StringBuilder schedule = new StringBuilder();

            for (int[] task : tasks) {
                if (cEnd[0] <= task[0]) {
                    cEnd[0] = task[1];
                    schedule.append('C');
                } else if (jEnd[0] <= task[0]) {
                    jEnd[0] = task[1];
                    schedule.append('J');
                } else {
                    isPossible = false;
                    break;
                }
            }

            results[testCase] = isPossible ? schedule.toString() : "IMPOSSIBLE";
        }

        for (int i = 0; i < numTestCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }

        scanner.close();
    }
}