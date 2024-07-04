import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCasesCount = Integer.parseInt(reader.readLine().trim());
            for (int i = 1; i <= testCasesCount; i++) {
                int activitiesCount = Integer.parseInt(reader.readLine().trim());
                List<TaskSchedule> activitiesTime = retrieveActivitiesTime(activitiesCount, reader);
                String output = assignTasks(activitiesTime);
                System.out.println("Case #" + i + ": " + output);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String assignTasks(List<TaskSchedule> activitiesTimeList) {
        StringBuilder result = new StringBuilder();
        Person cameron = new Person("C");
        Person jamie = new Person("J");

        for (TaskSchedule activity : activitiesTimeList) {
            boolean cameronOverlap = cameron.hasOverlap(activity);
            boolean jamieOverlap = jamie.hasOverlap(activity);

            if (cameronOverlap && jamieOverlap) {
                return "IMPOSSIBLE";
            } else if (cameronOverlap) {
                jamie.addTask(activity);
                result.append("J");
            } else {
                cameron.addTask(activity);
                result.append("C");
            }
        }

        return result.toString();
    }

    private static List<TaskSchedule> retrieveActivitiesTime(int activitiesCount, BufferedReader reader) throws IOException {
        List<TaskSchedule> activitiesTime = new ArrayList<>();
        for (int i = 0; i < activitiesCount; i++) {
            String[] scheduleParts = reader.readLine().trim().split(" ");
            int startTime = Integer.parseInt(scheduleParts[0]);
            int endTime = Integer.parseInt(scheduleParts[1]);
            activitiesTime.add(new TaskSchedule(startTime, endTime));
        }
        return activitiesTime;
    }

    static class Person {
        private String initial;
        private List<TaskSchedule> tasks;

        public Person(String initial) {
            this.initial = initial;
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
            return initial;
        }
    }

    static class TaskSchedule {
        private int startTime;
        private int endTime;

        public TaskSchedule(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public boolean overlapsWith(TaskSchedule other) {
            return (this.startTime < other.endTime && other.startTime < this.endTime);
        }
    }
}