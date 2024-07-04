import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        class Task {
            int position;
            int startTime;
            int endTime;
            String assignedPerson;

            Task(int startTime, int endTime, int position) {
                this.startTime = startTime;
                this.endTime = endTime;
                this.position = position;
            }
        }

        boolean DEBUG = false;
        InputStream is = DEBUG ? new FileInputStream("test1.in") : System.in;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)));

        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            int numberOfTasks = in.nextInt();
            Map<String, Integer> worker = new HashMap<>();
            worker.put("C", -1);
            worker.put("J", -1);
            StringBuilder result = new StringBuilder();

            List<Task> tasks = new ArrayList<>();
            for (int j = 0; j < numberOfTasks; j++) {
                int taskStartTime = in.nextInt();
                int taskEndTime = in.nextInt();
                tasks.add(new Task(taskStartTime, taskEndTime, j));
            }

            tasks.sort(Comparator.comparingInt(task -> task.endTime));

            Task prevTask = null;
            boolean overlappingTasks = false;
            boolean firstIteration = true;
            for (Task currentTask : tasks) {
                if (firstIteration) {
                    firstIteration = false;
                    currentTask.assignedPerson = "C";
                    worker.put("C", currentTask.endTime);
                } else {
                    if (prevTask.endTime <= currentTask.startTime) {
                        currentTask.assignedPerson = "C";
                        overlappingTasks = false;
                        worker.put("C", currentTask.endTime);
                    } else {
                        if (overlappingTasks) {
                            if (worker.get("C") <= currentTask.startTime) {
                                currentTask.assignedPerson = "C";
                                worker.put("C", currentTask.endTime);
                                overlappingTasks = false;
                                prevTask = currentTask;
                                continue;
                            } else {
                                result = new StringBuilder("IMPOSSIBLE");
                                break;
                            }
                        }
                        overlappingTasks = true;
                        currentTask.assignedPerson = "J";
                        worker.put("J", currentTask.endTime);
                    }
                }
                prevTask = currentTask;
            }

            if (result.toString().equals("IMPOSSIBLE")) {
                System.out.println("Case #" + i + ": " + result);
            } else {
                tasks.sort(Comparator.comparingInt(task -> task.position));
                for (Task task : tasks) {
                    result.append(task.assignedPerson);
                }
                System.out.println("Case #" + i + ": " + result);
            }
        }

        in.close();
    }
}