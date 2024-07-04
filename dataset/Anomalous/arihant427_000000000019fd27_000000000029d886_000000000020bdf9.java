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

        // Getters and Setters
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
        Integer taskCount;
        List<Task> tasks = new ArrayList<>();

        // Getters and Setters
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
        int t = scanner.nextInt();
        List<Schedule> schedules = new ArrayList<>();
        Solution solution = new Solution();

        for (int i = 0; i < t; i++) {
            int size = scanner.nextInt();
            Schedule schedule = solution.new Schedule();
            schedule.setTaskCount(size);
            for (int j = 0; j < size; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                Task task = solution.new Task();
                task.setStartTime(startTime);
                task.setEndTime(endTime);
                task.setSequence(j);
                task.setName(null);
                schedule.getTasks().add(task);
            }
            schedules.add(schedule);
        }

        for (int i = 0; i < schedules.size(); i++) {
            boolean canPrint = true;
            Schedule schedule = schedules.get(i);
            List<Task> arihantTasks = new ArrayList<>();
            List<Task> rajatTasks = new ArrayList<>();
            schedule.getTasks().sort(Comparator.comparing(Task::getStartTime));
            schedule.getTasks().get(0).setName("C");
            arihantTasks.add(schedule.getTasks().get(0));

            for (int j = 1; j < schedule.getTaskCount(); j++) {
                Task currentTask = schedule.getTasks().get(j);
                if (currentTask.getName() == null || currentTask.getName().isEmpty()) {
                    if (isValid(currentTask, arihantTasks)) {
                        currentTask.setName("C");
                        arihantTasks.add(currentTask);
                    } else if (isValid(currentTask, rajatTasks)) {
                        currentTask.setName("J");
                        rajatTasks.add(currentTask);
                    } else {
                        System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                        canPrint = false;
                        break;
                    }
                }
            }

            if (canPrint) {
                List<Task> finalTasks = new ArrayList<>();
                finalTasks.addAll(arihantTasks);
                finalTasks.addAll(rajatTasks);
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