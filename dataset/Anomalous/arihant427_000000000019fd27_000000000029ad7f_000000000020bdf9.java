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
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        List<Schedule> schedules = new ArrayList<>();
        Solution solution = new Solution();

        for (int i = 0; i < t; i++) {
            int size = scn.nextInt();
            Schedule schedule = solution.new Schedule();
            schedule.setTimes(size);

            for (int j = 0; j < schedule.getTimes(); j++) {
                int startTime = scn.nextInt();
                int endTime = scn.nextInt();
                Task task = solution.new Task();
                task.setStartTime(startTime);
                task.setEndTime(endTime);
                task.setSequence(j);
                schedule.getTasks().add(task);
            }
            schedules.add(schedule);
        }

        for (int i = 0; i < schedules.size(); i++) {
            Schedule schedule = schedules.get(i);
            List<Task> cameronTasks = new ArrayList<>();
            List<Task> jamieTasks = new ArrayList<>();
            boolean possible = true;

            schedule.getTasks().get(0).setName("C");
            cameronTasks.add(schedule.getTasks().get(0));

            for (int j = 1; j < schedule.getTimes(); j++) {
                Task currentTask = schedule.getTasks().get(j);

                if (!isValid(currentTask, cameronTasks)) {
                    if (isValid(currentTask, jamieTasks)) {
                        currentTask.setName("J");
                        jamieTasks.add(currentTask);
                    } else {
                        System.out.println("CASE #" + (i + 1) + ": IMPOSSIBLE");
                        possible = false;
                        break;
                    }
                }
            }

            if (possible) {
                List<Task> finalTasks = new ArrayList<>();
                finalTasks.addAll(cameronTasks);
                finalTasks.addAll(jamieTasks);
                finalTasks.sort(Comparator.comparing(Task::getSequence));
                System.out.print("CASE #" + (i + 1) + ":");
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