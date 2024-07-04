import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int[][] tasks = new int[N][2];
            for (int i = 0; i < N; i++) {
                tasks[i][0] = in.nextInt();
                tasks[i][1] = in.nextInt();
            }
            Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));
            String result = scheduleTasks(tasks);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String scheduleTasks(int[][] tasks) {
        Map<Character, Integer> startTimes = new HashMap<>();
        Map<Character, Integer> endTimes = new HashMap<>();
        char[] workers = {'C', 'J'};
        StringBuilder schedule = new StringBuilder();

        for (int[] task : tasks) {
            boolean assigned = false;
            for (char worker : workers) {
                if (canAssign(worker, startTimes, endTimes, task)) {
                    schedule.append(worker);
                    assigned = true;
                    break;
                }
            }
            if (!assigned) {
                return "IMPOSSIBLE";
            }
        }
        return schedule.toString();
    }

    private static boolean canAssign(char worker, Map<Character, Integer> startTimes, Map<Character, Integer> endTimes, int[] task) {
        int start = task[0];
        int end = task[1];

        if (!startTimes.containsKey(worker)) {
            startTimes.put(worker, start);
            endTimes.put(worker, end);
            return true;
        }

        int workerEnd = endTimes.get(worker);
        if (start >= workerEnd) {
            startTimes.put(worker, start);
            endTimes.put(worker, end);
            return true;
        }

        return false;
    }
}