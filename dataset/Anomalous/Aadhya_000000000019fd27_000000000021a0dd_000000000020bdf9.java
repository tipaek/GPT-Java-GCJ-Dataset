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

            for (int i = 0; i < numTasks; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
                events[2 * i][0] = tasks[i][0];
                events[2 * i][1] = 1; // Start event
                events[2 * i + 1][0] = tasks[i][1];
                events[2 * i + 1][1] = -1; // End event
            }

            Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

            int concurrentTasks = 0;
            boolean possible = true;
            for (int[] event : events) {
                concurrentTasks += event[1];
                if (concurrentTasks > 2) {
                    results[testCase] = "IMPOSSIBLE";
                    possible = false;
                    break;
                }
            }

            if (possible) {
                Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));
                int[][] busy = new int[2][2]; // Busy intervals for C and J
                StringBuilder schedule = new StringBuilder();

                for (int[] task : tasks) {
                    if (busy[0][1] <= task[0]) {
                        busy[0][0] = task[0];
                        busy[0][1] = task[1];
                        schedule.append('C');
                    } else if (busy[1][1] <= task[0]) {
                        busy[1][0] = task[0];
                        busy[1][1] = task[1];
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
        }

        for (int i = 0; i < numTestCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }
}