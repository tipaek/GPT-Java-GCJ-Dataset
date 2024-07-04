import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    class Task {
        private Integer sequence;
        private int startTime;
        private int endTime;
        private String name;
        private String assignTo;

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

    class Schedule {
        private Integer taskCount;
        private List<Task> tasks = new ArrayList<>();

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
        List<Schedule> schedules = new ArrayList<>();
        Solution solution = new Solution();

        for (int i = 0; i < testCases; i++) {
            int taskCount = scanner.nextInt();
            Schedule schedule = solution.new Schedule();
            schedule.setTaskCount(taskCount);

            for (int j = 0; j < taskCount; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                Task task = solution.new Task();
                task.setStartTime(startTime);
                task.setEndTime(endTime);
                task.setSequence(j);
                schedule.getTasks().add(task);
            }
            schedules.add(schedule);
        }

        for (int i = 0; i < schedules.size(); i++) {
            boolean isPossible = true;
            Schedule schedule = schedules.get(i);
            List<Task> cameronTasks = new ArrayList<>();
            List<Task> jamieTasks = new ArrayList<>();

            schedule.getTasks().get(0).setName("C");
            cameronTasks.add(schedule.getTasks().get(0));

            for (int j = 1; j < schedule.getTaskCount(); j++) {
                Task currentTask = schedule.getTasks().get(j);
                if (!isValid(currentTask, cameronTasks)) {
                    if (isValid(currentTask, jamieTasks)) {
                        currentTask.setName("J");
                        jamieTasks.add(currentTask);
                    } else {
                        System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                        isPossible = false;
                        break;
                    }
                }
            }

            if (isPossible) {
                List<Task> finalTasks = new ArrayList<>(cameronTasks);
                finalTasks.addAll(jamieTasks);
                finalTasks.sort(Comparator.comparing(Task::getSequence));
                System.out.print("Case #" + (i + 1) + ": ");
                finalTasks.forEach(task -> System.out.print(task.getName()));
                System.out.println();
            }
        }
    }

    static boolean isValid(Task task, List<Task> taskList) {
        int startTime = task.getStartTime();
        int endTime = task.getEndTime();
        for (Task t : taskList) {
            if (endTime > t.getStartTime() && t.getEndTime() > startTime) {
                return false;
            }
        }
        return true;
    }
}