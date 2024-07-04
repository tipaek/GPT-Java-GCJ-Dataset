import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static class Task {
        int startTime;
        int endTime;

        public Task(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int k = 0; k < t; k++) {
            int n = scanner.nextInt();
            List<Task> tasks = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks.add(new Task(start, end));
            }
            String result = solve(tasks, k + 1);
            System.out.println(result);
        }
    }

    static String solve(List<Task> tasks, int caseNumber) {
        StringBuilder solution = new StringBuilder();
        Map<Integer, Integer> cSchedule = new HashMap<>();
        Map<Integer, Integer> jSchedule = new HashMap<>();

        for (Task task : tasks) {
            int start = task.getStartTime();
            int end = task.getEndTime();
            boolean clashing = false;

            for (Map.Entry<Integer, Integer> entry : jSchedule.entrySet()) {
                if ((entry.getKey() <= start && entry.getValue() > start) || 
                    (entry.getKey() >= start && entry.getKey() < end)) {
                    clashing = true;
                    break;
                }
            }

            if (!clashing) {
                jSchedule.put(start, end);
                solution.append("J");
                continue;
            }

            clashing = false;
            for (Map.Entry<Integer, Integer> entry : cSchedule.entrySet()) {
                if ((entry.getKey() <= start && entry.getValue() > start) || 
                    (entry.getKey() >= start && entry.getKey() < end)) {
                    clashing = true;
                    break;
                }
            }

            if (!clashing) {
                cSchedule.put(start, end);
                solution.append("C");
            } else {
                return "Case #" + caseNumber + ": IMPOSSIBLE";
            }
        }

        return "Case #" + caseNumber + ": " + solution.toString();
    }
}