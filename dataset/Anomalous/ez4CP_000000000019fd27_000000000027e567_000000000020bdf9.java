import java.util.*;

class Solution {
    int start, end;

    Solution(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int x = 1; x <= testCases; x++) {
            int n = sc.nextInt();
            List<Solution> jamTasks = new ArrayList<>();
            List<Solution> camTasks = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int begin = sc.nextInt();
                int end = sc.nextInt();
                boolean assigned = false;

                // Check if the task can be assigned to Jamie
                if (canAssignTask(jamTasks, begin, end)) {
                    jamTasks.add(new Solution(begin, end));
                    result.append("J");
                    assigned = true;
                } else if (canAssignTask(camTasks, begin, end)) { // Check if the task can be assigned to Cameron
                    camTasks.add(new Solution(begin, end));
                    result.append("C");
                    assigned = true;
                }

                if (!assigned) {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + x + ": " + result.toString());
        }
        sc.close();
    }

    private static boolean canAssignTask(List<Solution> tasks, int begin, int end) {
        for (Solution task : tasks) {
            if (Math.max(task.start, begin) < Math.min(task.end, end)) {
                return false;
            }
        }
        return true;
    }
}