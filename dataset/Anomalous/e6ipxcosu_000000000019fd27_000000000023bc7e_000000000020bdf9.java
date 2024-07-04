import java.util.*;

public class Solution {

    public static class Task {
        int start;
        int end;
        int orig;

        Task(int start, int end, int orig) {
            this.start = start;
            this.end = end;
            this.orig = orig;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= T; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            List<Task> tasks = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                String[] input = scanner.nextLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                tasks.add(new Task(start, end, j));
            }

            tasks.sort(Comparator.comparingInt(task -> task.end));

            Set<Integer> cSet = new HashSet<>();
            Set<Integer> dSet = new HashSet<>();
            int currTime = 0;

            for (Task task : tasks) {
                if (task.start >= currTime) {
                    cSet.add(task.orig);
                    dSet.add(tasks.indexOf(task));
                    currTime = task.end;
                }
            }

            StringBuilder result = new StringBuilder();
            StringBuilder check = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if (cSet.contains(j)) {
                    result.append("C");
                } else {
                    result.append("J");
                }
            }

            for (int j = 0; j < n; j++) {
                if (dSet.contains(j)) {
                    check.append("C");
                } else {
                    check.append("J");
                }
            }

            currTime = 0;
            for (int j = 0; j < n; j++) {
                if (check.charAt(j) == 'J') {
                    if (tasks.get(j).start < currTime) {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    } else {
                        currTime = tasks.get(j).end;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}