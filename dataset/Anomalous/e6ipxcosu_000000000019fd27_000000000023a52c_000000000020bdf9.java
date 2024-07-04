import java.io.IOException;
import java.util.*;

public class Solution {
    public static class Task {
        int start;
        int end;
        int originalIndex;

        Task(int start, int end, int originalIndex) {
            this.start = start;
            this.end = end;
            this.originalIndex = originalIndex;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            List<Task> tasks = new ArrayList<>();
            Set<Integer> cTasks = new HashSet<>();

            for (int j = 0; j < n; j++) {
                String[] input = scanner.nextLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                tasks.add(new Task(start, end, j));
            }

            List<Task> originalList = new ArrayList<>(tasks);
            tasks.sort(Comparator.comparingInt(task -> task.end));

            int currentTime = 0;
            for (Task task : tasks) {
                if (task.start >= currentTime) {
                    cTasks.add(task.originalIndex);
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
                    if (originalList.get(j).start < currentTime) {
                        output = new StringBuilder("IMPOSSIBLE");
                        break;
                    } else {
                        currentTime = originalList.get(j).end;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + output);
        }
    }
}