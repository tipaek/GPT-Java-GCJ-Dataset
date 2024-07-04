import java.io.*;
import java.util.*;

public class Solution {

    static class Task {
        int startTime;
        int endTime;
        String assignedPerson;

        public Task(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        boolean DEBUG = false;
        InputStream input = DEBUG ? new FileInputStream("test1.in") : System.in;
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(input)));

        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            int numberOfTasks = scanner.nextInt();
            Map<String, Integer> workerAvailability = new HashMap<>();
            workerAvailability.put("C", -1);
            workerAvailability.put("J", -1);

            List<Task> tasks = new ArrayList<>();
            for (int j = 0; j < numberOfTasks; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks.add(new Task(start, end));
            }

            tasks.sort(Comparator.comparingInt(task -> task.endTime));

            StringBuilder result = new StringBuilder();
            Task prevTask = null;
            boolean overlappingTasks = false;

            for (Task currentTask : tasks) {
                if (prevTask == null || prevTask.endTime <= currentTask.startTime) {
                    result.append("C");
                    workerAvailability.put("C", currentTask.endTime);
                    overlappingTasks = false;
                } else {
                    if (overlappingTasks) {
                        if (workerAvailability.get("C") <= currentTask.startTime) {
                            result.append("C");
                            workerAvailability.put("C", currentTask.endTime);
                        } else {
                            result = new StringBuilder("IMPOSSIBLE");
                            break;
                        }
                    } else {
                        result.append("J");
                        workerAvailability.put("J", currentTask.endTime);
                        overlappingTasks = true;
                    }
                }
                prevTask = currentTask;
            }

            System.out.println("Case #" + i + ": " + result);
        }

        scanner.close();
    }
}