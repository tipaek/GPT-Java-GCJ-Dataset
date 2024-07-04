import java.util.*;

public class Solution {
    public static class Task {
        int start;
        int end;
        int index;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= T; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            List<Task> tasks = new ArrayList<>();
            Set<Integer> cTasks = new HashSet<>();

            for (int j = 0; j < n; j++) {
                String[] input = scanner.nextLine().split(" ");
                Task task = new Task();
                task.start = Integer.parseInt(input[0]);
                task.end = Integer.parseInt(input[1]);
                task.index = j;
                tasks.add(task);
            }

            List<Task> originalTasks = new ArrayList<>(tasks);
            tasks.sort(Comparator.comparingInt(t -> t.end));

            int currentTime = 0;
            for (Task task : tasks) {
                if (task.start >= currentTime) {
                    cTasks.add(task.index);
                    currentTime = task.end;
                }
            }

            StringBuilder output = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (cTasks.contains(j)) {
                    output.append("C");
                } else {
                    output.append("J");
                }
            }

            currentTime = 0;
            for (int j = 0; j < n; j++) {
                if (output.charAt(j) == 'J') {
                    Task task = originalTasks.get(tasks.get(j).index);
                    if (task.start < currentTime) {
                        output = new StringBuilder("IMPOSSIBLE");
                        break;
                    } else {
                        currentTime = task.end;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + output);
        }
    }
}