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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAssignTo() {
            return assignTo;
        }

        public void setAssignTo(String assignTo) {
            this.assignTo = assignTo;
        }
    }

    class Schedule {
        private Integer times;
        private List<Task> tasks = new ArrayList<>();

        public Integer getTimes() {
            return times;
        }

        public void setTimes(Integer times) {
            this.times = times;
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
            schedule.setTimes(size);

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
            Schedule schedule = schedules.get(i);
            List<Task> camTasks = new ArrayList<>();
            List<Task> jamTasks = new ArrayList<>();
            boolean isPossible = true;

            schedule.getTasks().get(0).setName("C");
            camTasks.add(schedule.getTasks().get(0));

            for (int j = 1; j < schedule.getTimes(); j++) {
                Task currentTask = schedule.getTasks().get(j);
                if (!canAssign(currentTask, camTasks)) {
                    if (canAssign(currentTask, jamTasks)) {
                        currentTask.setName("J");
                        jamTasks.add(currentTask);
                    } else {
                        System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                        isPossible = false;
                        break;
                    }
                }
            }

            if (isPossible) {
                List<Task> finalTasks = new ArrayList<>(camTasks);
                finalTasks.addAll(jamTasks);
                finalTasks.sort(Comparator.comparing(Task::getSequence));

                System.out.print("Case #" + (i + 1) + ": ");
                finalTasks.forEach(task -> System.out.print(task.getName()));
                System.out.println();
            }
        }
    }

    private static boolean canAssign(Task task, List<Task> assignedTasks) {
        for (Task assignedTask : assignedTasks) {
            if (task.getEndTime() > assignedTask.getStartTime() && assignedTask.getEndTime() > task.getStartTime()) {
                return false;
            }
        }
        return true;
    }
}