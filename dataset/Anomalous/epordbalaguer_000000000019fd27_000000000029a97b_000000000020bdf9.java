import java.util.*;

public class Solution {

    private static boolean areIntervalsOverlapping(int[] interval1, int[] interval2) {
        return (interval2[0] > interval1[0] && interval2[0] < interval1[1])
                || (interval2[1] > interval1[0] && interval2[1] < interval1[1])
                || (interval1[0] > interval2[0] && interval1[0] < interval2[1])
                || (interval1[1] > interval2[0] && interval1[1] < interval2[1]);
    }

    private static boolean taskOverlapExists(Set<Integer> assignedTasks, int[] currentTask, int[][] allTasks) {
        for (Integer taskIndex : assignedTasks) {
            if (areIntervalsOverlapping(allTasks[taskIndex], currentTask)) {
                return true;
            }
        }
        return false;
    }

    private static String generateSchedule(Set<Integer> cTasks, Set<Integer> jTasks, int totalTasks) {
        StringBuilder schedule = new StringBuilder();
        for (int i = 0; i < totalTasks; i++) {
            if (cTasks.contains(i)) {
                schedule.append('C');
            } else if (jTasks.contains(i)) {
                schedule.append('J');
            }
        }
        return schedule.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int taskCount = scanner.nextInt();
            int[][] tasks = new int[taskCount][2];
            boolean isImpossible = false;

            Set<Integer> jTasks = new HashSet<>();
            Set<Integer> cTasks = new HashSet<>();

            // Reading tasks
            for (int i = 0; i < taskCount; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
            }

            for (int i = 0; i < taskCount; i++) {
                int[] task = tasks[i];

                if (!taskOverlapExists(jTasks, task, tasks)) {
                    jTasks.add(i);
                } else if (!taskOverlapExists(cTasks, task, tasks)) {
                    cTasks.add(i);
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                String schedule = generateSchedule(cTasks, jTasks, taskCount);
                System.out.println("Case #" + caseNumber + ": " + schedule);
            }
        }
    }
}