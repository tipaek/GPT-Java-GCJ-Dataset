import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static class Pair {
        int start, end;
        char assignedTo;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
            this.assignedTo = 0;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int i = 1; i <= testCases; ++i) {
                System.out.print("Case #");
                System.out.print(i);
                System.out.print(": ");
                solve(scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        Pair[] tasks = new Pair[n];
        for (int i = 0; i < n; i++) {
            tasks[i] = new Pair(scanner.nextInt(), scanner.nextInt());
        }

        ArrayList<Pair> cameronTasks = new ArrayList<>();
        ArrayList<Pair> jamieTasks = new ArrayList<>();

        for (Pair task : tasks) {
            if (isValid(cameronTasks, task)) {
                task.assignedTo = 'C';
                cameronTasks.add(task);
            } else if (isValid(jamieTasks, task)) {
                task.assignedTo = 'J';
                jamieTasks.add(task);
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

        for (Pair task : tasks) {
            System.out.print(task.assignedTo);
        }
        System.out.println();
    }

    private static boolean isValid(ArrayList<Pair> assignedTasks, Pair newTask) {
        for (Pair task : assignedTasks) {
            if ((task.end > newTask.start && task.start < newTask.start)
                    || (task.start < newTask.end && task.end > newTask.start)
                    || (newTask.start < task.start && newTask.end > task.end)
                    || (task.start < newTask.start && task.end > newTask.end)) {
                return false;
            }
        }
        return true;
    }
}