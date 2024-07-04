import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CParenting {
    public static void main(String[] args) {
        new CParenting().run();
    }

    private Scanner scanner;

    private void run() {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < testCases; i++) {
            List<Task> tasks = readTasks();
            String result = processTestCase(tasks);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private String processTestCase(List<Task> tasks) {
        tasks.sort(Comparator.comparingInt(task -> task.start));
        
        int cEnd = 0;
        int jEnd = 0;
        
        for (Task task : tasks) {
            if (cEnd <= task.start) {
                task.assignedTo = 'C';
                cEnd = task.end;
            } else if (jEnd <= task.start) {
                task.assignedTo = 'J';
                jEnd = task.end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        tasks.sort(Comparator.comparingInt(task -> task.index));
        StringBuilder resultBuilder = new StringBuilder();
        for (Task task : tasks) {
            resultBuilder.append(task.assignedTo);
        }
        return resultBuilder.toString();
    }

    private List<Task> readTasks() {
        int numTasks = scanner.nextInt();
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < numTasks; i++) {
            tasks.add(new Task(i, scanner.nextInt(), scanner.nextInt()));
        }
        return tasks;
    }

    private static class Task {
        int index;
        int start;
        int end;
        char assignedTo;

        Task(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }
}