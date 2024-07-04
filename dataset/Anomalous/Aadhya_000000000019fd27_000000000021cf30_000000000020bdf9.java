import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTests = scanner.nextInt();
        String[] results = new String[numTests];

        for (int test = 0; test < numTests; test++) {
            int numTasks = scanner.nextInt();
            int[][] tasks = new int[numTasks][2];
            int[][] events = new int[2 * numTasks][2];
            int eventIndex = 0;

            for (int i = 0; i < numTasks; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks[i][0] = start;
                tasks[i][1] = end;
                events[eventIndex++] = new int[]{start, 1};
                events[eventIndex++] = new int[]{end, -1};
            }

            Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

            int concurrentTasks = 0;
            boolean impossible = false;
            for (int[] event : events) {
                concurrentTasks += event[1];
                if (concurrentTasks > 2) {
                    results[test] = "IMPOSSIBLE";
                    impossible = true;
                    break;
                }
            }

            if (!impossible) {
                Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));
                int[] cameron = new int[]{0, 0};
                int[] jamie = new int[]{0, 0};
                StringBuilder schedule = new StringBuilder();

                for (int[] task : tasks) {
                    if (cameron[1] <= task[0]) {
                        cameron[0] = task[0];
                        cameron[1] = task[1];
                        schedule.append("C");
                    } else if (jamie[1] <= task[0]) {
                        jamie[0] = task[0];
                        jamie[1] = task[1];
                        schedule.append("J");
                    } else {
                        results[test] = "IMPOSSIBLE";
                        impossible = true;
                        break;
                    }
                }

                if (!impossible) {
                    results[test] = schedule.toString();
                }
            }
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}