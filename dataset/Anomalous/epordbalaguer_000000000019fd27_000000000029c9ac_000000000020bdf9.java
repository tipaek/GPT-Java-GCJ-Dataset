import java.util.*;

public class Solution {

    private static boolean areOverlapping(int[] task1, int[] task2) {
        return task1[0] < task2[1] && task1[1] > task2[0];
    }

    private static boolean hasOverlappingTasks(Set<Integer> assignedTasks, int[] currentTask, int[][] allTasks) {
        for (Integer taskIndex : assignedTasks) {
            if (areOverlapping(allTasks[taskIndex], currentTask)) {
                return true;
            }
        }
        return false;
    }

    private static String computeSchedule(Set<Integer> cTasks, Set<Integer> jTasks, int totalTasks) {
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

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int taskCount = scanner.nextInt();
            int[][] tasks = new int[taskCount][2];
            boolean isImpossible = false;

            Set<Integer> jTasks = new HashSet<>();
            Set<Integer> cTasks = new HashSet<>();

            for (int i = 0; i < taskCount; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
            }

            Arrays.sort(tasks, Comparator.comparingInt(task -> task[0]));

            for (int i = 0; i < taskCount; i++) {
                int[] task = tasks[i];

                if (!hasOverlappingTasks(cTasks, task, tasks)) {
                    cTasks.add(i);
                } else if (!hasOverlappingTasks(jTasks, task, tasks)) {
                    jTasks.add(i);
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                String result = computeSchedule(cTasks, jTasks, taskCount);
                System.out.println("Case #" + caseNum + ": " + result);
            }
        }

        scanner.close();
    }
}