import java.util.ArrayList;
import java.util.Scanner;

class Task {
    int startTime;
    int endTime;

    Task(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

class Kid {
    String name;
    private ArrayList<Task> activeTasks;

    Kid(String name) {
        this.name = name;
        this.activeTasks = new ArrayList<>();
    }

    boolean canDoTask(Task task) {
        for (Task activeTask : activeTasks) {
            if (!(task.endTime <= activeTask.startTime || task.startTime >= activeTask.endTime)) {
                return false;
            }
        }
        return true;
    }

    void doTask(Task task) {
        activeTasks.add(task);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];

        for (int t = 0; t < testCases; t++) {
            int taskCount = scanner.nextInt();
            Task[] tasks = new Task[taskCount];
            Kid c = new Kid("C");
            Kid j = new Kid("J");
            StringBuilder schedule = new StringBuilder();

            for (int i = 0; i < taskCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks[i] = new Task(start, end);
            }

            for (Task task : tasks) {
                if (c.canDoTask(task)) {
                    c.doTask(task);
                    schedule.append(c.name);
                } else if (j.canDoTask(task)) {
                    j.doTask(task);
                    schedule.append(j.name);
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            results[t] = schedule.toString();
        }

        for (int t = 0; t < testCases; t++) {
            System.out.println("Case #" + (t + 1) + ": " + results[t]);
        }

        scanner.close();
    }
}