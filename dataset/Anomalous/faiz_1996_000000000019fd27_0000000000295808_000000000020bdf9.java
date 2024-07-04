import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        List<Schedule> schedules = new ArrayList<>(t);
        Solution solution = new Solution();

        while (t-- > 0) {
            int n = scanner.nextInt();
            List<Task> tasks = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (isValidTime(startTime) && isValidTime(endTime)) {
                    tasks.add(new Task(startTime, endTime));
                }
            }

            if (!tasks.isEmpty()) {
                schedules.add(new Schedule(tasks));
            }
        }
        scanner.close();

        for (int i = 0; i < schedules.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + calculateResult(schedules.get(i)));
        }
    }

    private static boolean isValidTime(int time) {
        return time >= 0 && time <= 1440;
    }

    private static String calculateResult(Schedule schedule) {
        List<String> users = Arrays.asList("C", "J");
        List<Task> tasks = schedule.getTasks();
        String currentUser = users.get(0);

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);

            if (i == 0) {
                task.setUser(currentUser);
            } else {
                List<Task> assignedTasks = getTasksByUser(tasks, currentUser);

                if (!isTaskAssignable(task, assignedTasks)) {
                    currentUser = switchUser(currentUser);
                    assignedTasks = getTasksByUser(tasks, currentUser);

                    if (!isTaskAssignable(task, assignedTasks)) {
                        return "IMPOSSIBLE";
                    } else {
                        task.setUser(currentUser);
                    }
                } else {
                    task.setUser(currentUser);
                }
            }
        }
        return tasks.stream().map(Task::getUser).collect(Collectors.joining());
    }

    private static String switchUser(String currentUser) {
        return currentUser.equals("C") ? "J" : "C";
    }

    private static List<Task> getTasksByUser(List<Task> tasks, String user) {
        return tasks.stream().filter(task -> user.equals(task.getUser())).collect(Collectors.toList());
    }

    private static boolean isTaskAssignable(Task task, List<Task> assignedTasks) {
        return assignedTasks.stream().noneMatch(assignedTask -> isOverlapping(task, assignedTask));
    }

    private static boolean isOverlapping(Task task1, Task task2) {
        return (task1.getStartTime() < task2.getEndTime() && task1.getEndTime() > task2.getStartTime());
    }

    static class Schedule {
        private List<Task> tasks;

        public Schedule(List<Task> tasks) {
            this.tasks = tasks;
        }

        public List<Task> getTasks() {
            return tasks;
        }
    }

    static class Task {
        private String user;
        private int startTime;
        private int endTime;

        public Task(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }
    }
}