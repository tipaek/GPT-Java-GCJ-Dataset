import java.util.*;

public class Solution {

    private static boolean areOverlapping(int[] t1, int[] t2) {
        return (t2[0] > t1[0] && t2[0] < t1[1])
                || (t2[1] > t1[0] && t2[1] < t1[1])
                || (t1[0] > t2[0] && t1[0] < t2[1])
                || (t1[1] > t2[0] && t1[1] < t2[1]);
    }

    private static boolean hasOverlappingTasks(Set<Integer> assignedTasks, int[] task, int[][] tasks) {
        for (Integer i : assignedTasks) {
            if (areOverlapping(tasks[i], task)) return true;
        }
        return false;
    }

    private static String buildSchedule(Set<Integer> cTasks, Set<Integer> jTasks, int totalTasks) {
        StringBuilder schedule = new StringBuilder(totalTasks);

        for (int i = 0; i < totalTasks; i++) {
            if (cTasks.contains(i)) schedule.append('C');
            else if (jTasks.contains(i)) schedule.append('J');
        }

        return schedule.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int tasksCount = scanner.nextInt();
            int[][] tasks = new int[tasksCount][2];
            boolean isImpossible = false;

            Set<Integer> jTasks = new HashSet<>();
            Set<Integer> cTasks = new HashSet<>();

            for (int i = 0; i < tasksCount; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
            }

            int[][] originalTasks = Arrays.copyOf(tasks, tasks.length);
            Arrays.sort(tasks, Comparator.comparingInt(task -> task[0]));

            Map<int[], Integer> taskIndexMap = new HashMap<>();
            for (int i = 0; i < tasksCount; i++) {
                taskIndexMap.put(tasks[i], i);
            }

            for (int i = 0; i < tasksCount; i++) {
                int[] task = tasks[i];

                if (!hasOverlappingTasks(jTasks, task, tasks)) {
                    jTasks.add(i);
                } else if (!hasOverlappingTasks(cTasks, task, tasks)) {
                    cTasks.add(i);
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                String result = buildSchedule(cTasks, jTasks, tasksCount);
                char[] finalResult = new char[tasksCount];
                for (int i = 0; i < tasksCount; i++) {
                    int originalIndex = taskIndexMap.get(originalTasks[i]);
                    finalResult[originalIndex] = result.charAt(i);
                }
                System.out.println("Case #" + caseNum + ": " + new String(finalResult));
            }
        }
    }
}