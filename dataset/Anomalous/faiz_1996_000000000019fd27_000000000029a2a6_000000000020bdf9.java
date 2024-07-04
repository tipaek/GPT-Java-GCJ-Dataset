import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<Schedule> schedules = new ArrayList<>(testCases);
        Solution solution = new Solution();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            List<Task> tasks = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                tasks.add(solution.new Task(startTime, endTime));
            }

            schedules.add(solution.new Schedule(tasks));
        }

        scanner.close();

        for (int i = 0; i < schedules.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + solution.calculateResult(schedules.get(i)));
        }
    }

    public class Schedule {
        private List<Task> tasks;

        public Schedule(List<Task> tasks) {
            this.tasks = tasks;
        }

        public List<Task> getTasks() {
            return tasks;
        }
    }

    public class Task {
        private String person;
        private int startTime;
        private int endTime;

        public Task(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public String getPerson() {
            return person;
        }

        public void setPerson(String person) {
            this.person = person;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }
    }

    private String calculateResult(Schedule schedule) {
        List<String> users = List.of("C", "J");
        List<Task> tasks = schedule.getTasks();
        String currentUser = users.get(0);

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (i == 0) {
                task.setPerson(currentUser);
            } else {
                List<Task> assignedTasks = getTasksAssignedToUser(tasks, currentUser);
                if (!isTimeSlotAvailable(task.getStartTime(), task.getEndTime(), assignedTasks)) {
                    currentUser = currentUser.equals("J") ? "C" : "J";
                    assignedTasks = getTasksAssignedToUser(tasks, currentUser);
                    if (!isTimeSlotAvailable(task.getStartTime(), task.getEndTime(), assignedTasks)) {
                        return "IMPOSSIBLE";
                    } else {
                        task.setPerson(currentUser);
                    }
                } else {
                    task.setPerson(currentUser);
                }
            }
        }
        return tasks.stream().map(Task::getPerson).collect(Collectors.joining());
    }

    private List<Task> getTasksAssignedToUser(List<Task> tasks, String user) {
        return tasks.stream().filter(task -> user.equals(task.getPerson())).collect(Collectors.toList());
    }

    private boolean isTimeSlotAvailable(int startTime, int endTime, List<Task> tasks) {
        return tasks.stream().noneMatch(task -> isOverlapping(startTime, endTime, task.getStartTime(), task.getEndTime()));
    }

    private boolean isOverlapping(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && end1 > start2);
    }
}