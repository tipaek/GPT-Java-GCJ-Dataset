import java.util.*;

public class Solution {

    static Map<Integer, Integer> realToTmp = new HashMap<>();
    static Map<Integer, Integer> tmpToReal = new HashMap<>();

    private static boolean areOverlapping(int[] t1, int[] t2) {
        return t1[0] < t2[1] && t2[0] < t1[1];
    }

    private static boolean hasOverlappingTasks(Set<Integer> taskList, int[] task, int[][] tasks) {
        for (Integer i : taskList) {
            if (areOverlapping(tasks[i], task)) {
                return true;
            }
        }
        return false;
    }

    private static String computeSchedule(Set<Integer> cTasks, Set<Integer> jTasks, int tasksCount) {
        StringBuilder sb = new StringBuilder(tasksCount);
        for (int i = 0; i < tasksCount; i++) {
            if (cTasks.contains(tmpToReal.get(i))) {
                sb.append('C');
            } else if (jTasks.contains(tmpToReal.get(i))) {
                sb.append('J');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int tasksCount = sc.nextInt();
            int[][] tasks = new int[tasksCount][3];
            boolean isImpossible = false;

            Set<Integer> jTasks = new HashSet<>();
            Set<Integer> cTasks = new HashSet<>();

            for (int i = 0; i < tasksCount; i++) {
                tasks[i][0] = sc.nextInt();
                tasks[i][1] = sc.nextInt();
                tasks[i][2] = i;
            }

            Arrays.sort(tasks, Comparator.comparingInt(task -> task[0]));

            for (int i = 0; i < tasksCount; i++) {
                realToTmp.put(i, tasks[i][2]);
                tmpToReal.put(tasks[i][2], i);
            }

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
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                String result = computeSchedule(cTasks, jTasks, tasksCount);
                System.out.println("Case #" + caseNum + ": " + result);
            }
        }
    }
}