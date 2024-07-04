import java.util.ArrayList;
import java.util.Arrays;
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
            List<Task> tasks = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isValidTime(start) && isValidTime(end)) {
                    tasks.add(new Task(start, end));
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
                task.setPerson(currentUser);
            } else {
                List<Task> currentTasks = filterTasksByPerson(tasks, currentUser);

                if (!isAvailable(task, currentTasks)) {
                    currentUser = currentUser.equals("J") ? "C" : "J";
                    currentTasks = filterTasksByPerson(tasks, currentUser);

                    if (!isAvailable(task, currentTasks)) {
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

    private static List<Task> filterTasksByPerson(List<Task> tasks, String person) {
        return tasks.stream().filter(task -> task.getPerson().equals(person)).collect(Collectors.toList());
    }

    private static boolean isAvailable(Task task, List<Task> tasks) {
        return tasks.stream().noneMatch(t -> isOverlapping(task.getStart(), task.getEnd(), t.getStart(), t.getEnd()));
    }

    private static boolean isOverlapping(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && end1 > start2);
    }

    static class Schedule {
        private final List<Task> tasks;

        public Schedule(List<Task> tasks) {
            this.tasks = tasks;
        }

        public List<Task> getTasks() {
            return tasks;
        }
    }

    static class Task {
        private final int start;
        private final int end;
        private String person;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public String getPerson() {
            return person;
        }

        public void setPerson(String person) {
            this.person = person;
        }
    }
}