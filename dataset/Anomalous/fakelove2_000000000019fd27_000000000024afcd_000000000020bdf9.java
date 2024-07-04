import java.io.*;
import java.util.*;

public class Solution {
    static class Pair {
        int start, end, index;
        char assignee = 0;

        Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int i = 1; i <= testCases; ++i) {
                System.out.print("Case #" + i + ": ");
                processTestCase(scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processTestCase(Scanner scanner) {
        int n = scanner.nextInt();
        Pair[] tasks = new Pair[n];
        for (int i = 0; i < n; i++) {
            tasks[i] = new Pair(scanner.nextInt(), scanner.nextInt(), i);
        }

        Arrays.sort(tasks, Comparator.comparingInt(pair -> pair.start));

        List<Pair> cameron = new ArrayList<>();
        List<Pair> jamie = new ArrayList<>();

        for (Pair task : tasks) {
            if (!hasConflict(cameron, task)) {
                task.assignee = 'C';
                cameron.add(task);
            } else if (!hasConflict(jamie, task)) {
                task.assignee = 'J';
                jamie.add(task);
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

        Arrays.sort(tasks, Comparator.comparingInt(pair -> pair.index));
        for (Pair task : tasks) {
            System.out.print(task.assignee);
        }
        System.out.println();
    }

    private static boolean hasConflict(List<Pair> schedule, Pair task) {
        for (Pair existingTask : schedule) {
            if ((existingTask.end > task.start && existingTask.start < task.start)
                    || (existingTask.start < task.end && existingTask.end > task.start)
                    || (task.start < existingTask.start && task.end > existingTask.end)
                    || (existingTask.start < task.start && existingTask.end > task.end)) {
                return true;
            }
        }
        return false;
    }
}