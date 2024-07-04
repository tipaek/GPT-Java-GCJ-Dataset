import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    class Task {
        Integer sequence;
        int startTime;
        int endTime;
        String name;
        String assignTo;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getSequence() {
            return sequence;
        }

        public void setSequence(Integer sequence) {
            this.sequence = sequence;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        public String getAssignTo() {
            return assignTo;
        }

        public void setAssignTo(String assignTo) {
            this.assignTo = assignTo;
        }
    }

    class TaskSet {
        Integer taskCount;
        List<Task> tasks = new ArrayList<>();

        public Integer getTaskCount() {
            return taskCount;
        }

        public void setTaskCount(Integer taskCount) {
            this.taskCount = taskCount;
        }

        public List<Task> getTasks() {
            return tasks;
        }

        public void setTasks(List<Task> tasks) {
            this.tasks = tasks;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<TaskSet> taskSets = new ArrayList<>();
        Solution solution = new Solution();

        for (int i = 0; i < testCases; i++) {
            int taskCount = scanner.nextInt();
            TaskSet taskSet = solution.new TaskSet();
            taskSet.setTaskCount(taskCount);

            for (int j = 0; j < taskCount; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                Task task = solution.new Task();
                task.setStartTime(startTime);
                task.setEndTime(endTime);
                task.setSequence(j);
                task.setName(null);
                taskSet.getTasks().add(task);
            }
            taskSets.add(taskSet);
        }

        for (int i = 0; i < taskSets.size(); i++) {
            boolean isPossible = true;
            TaskSet taskSet = taskSets.get(i);
            List<Task> cameronTasks = new ArrayList<>();
            List<Task> jamieTasks = new ArrayList<>();

            taskSet.getTasks().get(0).setName("C");
            cameronTasks.add(taskSet.getTasks().get(0));

            for (int j = 1; j < taskSet.getTaskCount(); j++) {
                Task currentTask = taskSet.getTasks().get(j);
                if (!isTaskAssignable(currentTask, cameronTasks)) {
                    if (isTaskAssignable(currentTask, jamieTasks)) {
                        currentTask.setName("J");
                        jamieTasks.add(currentTask);
                    } else {
                        System.out.println("CASE #" + (i + 1) + ": IMPOSSIBLE");
                        isPossible = false;
                        break;
                    }
                } else {
                    currentTask.setName("C");
                    cameronTasks.add(currentTask);
                }
            }

            if (isPossible) {
                List<Task> finalTasks = new ArrayList<>(cameronTasks);
                finalTasks.addAll(jamieTasks);
                finalTasks.sort(Comparator.comparing(Task::getSequence));
                System.out.print("CASE #" + (i + 1) + ":");
                for (Task task : finalTasks) {
                    System.out.print(task.getName());
                }
                System.out.println();
            }
        }
    }

    static boolean isTaskAssignable(Task task, List<Task> assignedTasks) {
        int startTime = task.getStartTime();
        int endTime = task.getEndTime();
        for (Task assignedTask : assignedTasks) {
            if (endTime > assignedTask.getStartTime() && startTime < assignedTask.getEndTime()) {
                return false;
            }
        }
        return true;
    }
}