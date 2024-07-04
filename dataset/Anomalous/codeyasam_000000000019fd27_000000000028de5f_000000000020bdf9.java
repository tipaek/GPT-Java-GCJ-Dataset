import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCasesCount = Integer.parseInt(reader.readLine().trim());
            for (int i = 1; i <= testCasesCount; i++) {
                int activitiesCount = Integer.parseInt(reader.readLine().trim());
                List<TaskSchedule> activities = getActivities(activitiesCount, reader);
                String result = assignTasks(activities);
                System.out.println("Case #" + i + ": " + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String assignTasks(List<TaskSchedule> activities) {
        StringBuilder result = new StringBuilder();
        Person cameron = new Person("C");
        Person jamie = new Person("J");

        for (TaskSchedule activity : activities) {
            boolean cameronOverlap = cameron.hasOverlap(activity);
            boolean jamieOverlap = jamie.hasOverlap(activity);

            if (cameronOverlap && jamieOverlap) {
                return "IMPOSSIBLE";
            } else if (cameronOverlap) {
                result.append("J");
                jamie.addTask(activity);
            } else {
                result.append("C");
                cameron.addTask(activity);
            }
        }
        return result.toString();
    }

    private static List<TaskSchedule> getActivities(int count, BufferedReader reader) throws IOException {
        List<TaskSchedule> activities = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] parts = reader.readLine().trim().split(" ");
            int start = Integer.parseInt(parts[0]);
            int end = Integer.parseInt(parts[1]);
            activities.add(new TaskSchedule(start, end));
        }
        return activities;
    }

    static class Person {
        private final String name;
        private final List<TaskSchedule> tasks;

        public Person(String name) {
            this.name = name;
            this.tasks = new ArrayList<>();
        }

        public boolean hasOverlap(TaskSchedule task) {
            return tasks.stream().anyMatch(t -> t.overlapsWith(task));
        }

        public void addTask(TaskSchedule task) {
            tasks.add(task);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class TaskSchedule {
        private final int start;
        private final int end;

        public TaskSchedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlapsWith(TaskSchedule other) {
            return (start < other.end && end > other.start);
        }
    }
}