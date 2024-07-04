import java.util.*;

class Task {
    int id;
    int start;
    int end;

    Task(int id, int start, int end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        for (int x = 1; x <= t; x++) {
            int n = Integer.parseInt(sc.nextLine());

            List<Task> taskList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] input = sc.nextLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                taskList.add(new Task(i, start, end));
            }

            StringBuilder result = new StringBuilder();
            boolean success = true;
            List<Task> cameronTasks = new ArrayList<>();
            List<Task> jamieTasks = new ArrayList<>();

            for (Task current : taskList) {
                if (canAssignTask(current, cameronTasks)) {
                    cameronTasks.add(current);
                    result.append("C");
                } else if (canAssignTask(current, jamieTasks)) {
                    jamieTasks.add(current);
                    result.append("J");
                } else {
                    success = false;
                    System.out.println("Case #" + x + ": IMPOSSIBLE");
                    break;
                }
            }

            if (success) {
                System.out.println("Case #" + x + ": " + result.toString());
            }
        }
    }

    private static boolean canAssignTask(Task current, List<Task> assignedTasks) {
        for (Task task : assignedTasks) {
            if ((current.start < task.end && current.end > task.start)) {
                return false;
            }
        }
        return true;
    }
}