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
            int eventCount = 0;

            for (int task = 0; task < numTasks; task++) {
                tasks[task][0] = scanner.nextInt();
                tasks[task][1] = scanner.nextInt();
                events[eventCount++] = new int[]{tasks[task][0], 1}; // Start event
                events[eventCount++] = new int[]{tasks[task][1], -1}; // End event
            }

            Arrays.sort(events, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

            int concurrentTasks = 0;
            boolean possible = true;
            for (int[] event : events) {
                concurrentTasks += event[1];
                if (concurrentTasks > 2) {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                results[testCase] = "IMPOSSIBLE";
                continue;
            }

            Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));
            int[] cBusy = new int[2];
            int[] jBusy = new int[2];
            StringBuilder schedule = new StringBuilder();

            for (int[] task : tasks) {
                if (cBusy[1] <= task[0]) {
                    cBusy[0] = task[0];
                    cBusy[1] = task[1];
                    schedule.append('C');
                } else if (jBusy[1] <= task[0]) {
                    jBusy[0] = task[0];
                    jBusy[1] = task[1];
                    schedule.append('J');
                } else {
                    results[testCase] = "IMPOSSIBLE";
                    possible = false;
                    break;
                }
            }

            if (possible) {
                results[testCase] = schedule.toString();
            }
        }

        for (int i = 0; i < numTestCases; i++) {
            System.out.println("Case " + (i + 1) + ": " + results[i]);
        }
    }
}