import java.util.*;

class Task {
    int id;
    int start;
    int end;
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
                Task task = new Task();
                task.id = i;
                task.start = Integer.parseInt(input[0]);
                task.end = Integer.parseInt(input[1]);

                taskList.add(task);
            }

            List<Task> jag = new ArrayList<>();
            List<Task> cag = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            boolean success = true;

            for (Task current : taskList) {
                if (canAssignTask(cag, current)) {
                    cag.add(current);
                    result.append("C");
                } else if (canAssignTask(jag, current)) {
                    jag.add(current);
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

    private static boolean canAssignTask(List<Task> assignedTasks, Task current) {
        for (Task task : assignedTasks) {
            if (!(current.end <= task.start || current.start >= task.end)) {
                return false;
            }
        }
        return true;
    }
}