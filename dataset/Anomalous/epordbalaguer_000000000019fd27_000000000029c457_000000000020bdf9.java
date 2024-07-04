import java.util.*;

public class Solution {

    private static boolean areOverlapping(int[] t1, int[] t2) {
        return (t2[0] > t1[0] && t2[0] < t1[1])
                || (t2[1] > t1[0] && t2[1] < t1[1])
                || (t1[0] > t2[0] && t1[0] < t2[1])
                || (t1[1] > t2[0] && t1[1] < t2[1]);
    }

    private static boolean hasOverlappingTasks(Set<Integer> taskSet, int[] task, int[][] tasks) {
        for (int i : taskSet) {
            if (areOverlapping(tasks[i], task)) return true;
        }
        return false;
    }

    private static String computeSchedule(Set<Integer> cTasks, Set<Integer> jTasks, int taskCount) {
        StringBuilder schedule = new StringBuilder(taskCount);

        for (int i = 0; i < taskCount; i++) {
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

            for (int i = 0; i < taskCount; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
            }

            Arrays.sort(tasks, Comparator.comparingInt(task -> task[0]));

            Set<Integer> cTasks = new HashSet<>();
            Set<Integer> jTasks = new HashSet<>();
            boolean isImpossible = false;

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