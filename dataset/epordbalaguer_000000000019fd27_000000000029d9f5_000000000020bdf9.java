import java.lang.reflect.Array;
import java.util.*;

public class Solution {

    private static boolean areOverlapping(int[] t1, int[] t2) {
        int x1 = t1[0];
        int y1 = t1[1];
        int x2 = t2[0];
        int y2 = t2[1];
        return x1 < y2 && x2 < y1;
    }

    private static boolean hasOverlappingTasks(Set<Integer> taskList, int[] task, int[][] tasks) {
        for (Integer i: taskList) {
            if (areOverlapping(tasks[i], task)) return true;
        }
        return false;
    }

    private static String computeSchedule(Set<Integer> cTasks, Set<Integer> jTasks, int tasksCount) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tasksCount; i++) {
            if (cTasks.contains(i)) sb.append('C');
            if (jTasks.contains(i)) sb.append('J');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer t = sc.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            Integer tasksCount = sc.nextInt();
            int[][] tasks = new int[tasksCount][2];
            boolean isImpossible = false;

            Set<Integer> jTasks = new HashSet<>();
            Set<Integer> cTasks = new HashSet<>();

            // Read all tasks
            for (int i = 0; i < tasksCount; i++) {
                tasks[i][0] = sc.nextInt();
                tasks[i][1] = sc.nextInt();
            }

            Arrays.sort(tasks, Comparator.comparingInt(task -> task[0]));

            for (int i = 0; i < tasksCount; i++) {
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
                System.out.println("Case #" + caseNum + ": " + "IMPOSSIBLE");
            } else {
                String result = computeSchedule(cTasks, jTasks, tasksCount);
                System.out.println("Case #" + caseNum + ": " + result);
            }
        }
    }

}
