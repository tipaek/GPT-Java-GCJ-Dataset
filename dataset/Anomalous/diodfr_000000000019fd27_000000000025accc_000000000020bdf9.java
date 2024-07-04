import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static class Task {
        int start;
        int end;
        int id;

        Task(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            scanner.nextLine();

            for (int t = 1; t <= testCases; t++) {
                int taskCount = scanner.nextInt();
                scanner.nextLine();

                List<Task> tasks = new ArrayList<>();
                for (int i = 0; i < taskCount; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    tasks.add(new Task(start, end, i));
                }

                tasks.sort((task1, task2) -> {
                    if (task1.start != task2.start) {
                        return Integer.compare(task1.start, task2.start);
                    }
                    return Integer.compare(task1.end, task2.end);
                });

                char[] result = new char[taskCount];
                int endJ = -1;
                int endC = -1;
                boolean possible = true;

                for (Task task : tasks) {
                    if (task.start >= endJ) {
                        result[task.id] = 'J';
                        endJ = task.end;
                    } else if (task.start >= endC) {
                        result[task.id] = 'C';
                        endC = task.end;
                    } else {
                        possible = false;
                        break;
                    }
                }

                System.out.println("Case #" + t + ": " + (possible ? new String(result) : "IMPOSSIBLE"));
            }
        }
    }
}