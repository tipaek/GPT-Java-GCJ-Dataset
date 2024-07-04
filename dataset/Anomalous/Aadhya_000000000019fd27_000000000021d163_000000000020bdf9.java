import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        String[] results = new String[numTestCases];

        for (int i = 0; i < numTestCases; i++) {
            int numTasks = scanner.nextInt();
            int[][] tasks = new int[numTasks][2];
            List<int[]> events = new ArrayList<>();

            for (int j = 0; j < numTasks; j++) {
                tasks[j][0] = scanner.nextInt();
                tasks[j][1] = scanner.nextInt();
                events.add(new int[]{tasks[j][0], 1});
                events.add(new int[]{tasks[j][1], -1});
            }

            events.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

            int ongoingTasks = 0;
            boolean possible = true;

            for (int[] event : events) {
                ongoingTasks += event[1];
                if (ongoingTasks > 2) {
                    results[i] = "IMPOSSIBLE";
                    possible = false;
                    break;
                }
            }

            if (possible) {
                Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));
                int[] cameron = new int[]{0, 0};
                int[] jamie = new int[]{0, 0};
                StringBuilder schedule = new StringBuilder();

                for (int[] task : tasks) {
                    if (cameron[1] <= task[0]) {
                        cameron[0] = task[0];
                        cameron[1] = task[1];
                        schedule.append('C');
                    } else if (jamie[1] <= task[0]) {
                        jamie[0] = task[0];
                        jamie[1] = task[1];
                        schedule.append('J');
                    } else {
                        results[i] = "IMPOSSIBLE";
                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    results[i] = schedule.toString();
                }
            }
        }

        for (int i = 0; i < numTestCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }
}