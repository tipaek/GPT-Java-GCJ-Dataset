import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        for (int i = 1; i <= numCases; i++) {
            boolean impossible = false;
            int numActivities = scanner.nextInt();
            Map<Task, String> assignment = new HashMap<>();
            List<Task> tasks = new ArrayList<>();
            for (int j = 0; j < numActivities; j++) {
                tasks.add(new Task(scanner.nextInt(), scanner.nextInt()));
            }
            List<Task> sortedTasks = new ArrayList<>(tasks);
            sortedTasks.sort(Comparator.comparingInt(task -> task.start));
            int cEndTime = 0;
            int jEndTime = 0;
            for (Task task : sortedTasks) {
                if (cEndTime <= task.start) {
                    assignment.put(task, "C");
                    cEndTime = task.end;
                } else if (jEndTime <= task.start) {
                    assignment.put(task, "J");
                    jEndTime = task.end;
                } else {
                    impossible = true;
                }
            }
            if (impossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                String order = "";
                for (Task task : tasks) {
                    order += assignment.get(task);
                }
                System.out.println("Case #" + i + ": " + order);
            }
        }
    }


}

class Task {
    public int start;
    public int end;

    public Task(int start, int end) {
        this.start = start;
        this.end = end;
    }
}