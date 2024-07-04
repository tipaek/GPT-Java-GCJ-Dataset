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

        for (TaskSchedule currentActivity : activitiesTimeList) {
            boolean cameronHasOverlap = cameron.hasOverlappingHours(currentActivity);
            boolean jamieHasOverlap = jamie.hasOverlappingHours(currentActivity);

            if (cameronHasOverlap && jamieHasOverlap) {
                return "IMPOSSIBLE";
            }

            String assignedPerson = cameronHasOverlap ? "J" : "C";
            if (assignedPerson.equals("J")) {
                jamie.addTask(currentActivity);
            } else {
                cameron.addTask(currentActivity);
            }

            result.append(assignedPerson);
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
        private final String initial;
        private final List<TaskSchedule> taskSchedules;

        public Person(String initial) {
            this.initial = initial;
            this.taskSchedules = new ArrayList<>();
        }

        public boolean hasOverlappingHours(TaskSchedule otherTask) {
            for (TaskSchedule task : taskSchedules) {
                if (task.hasOverlappingHours(otherTask)) {
                    return true;
                }
            }
            return false;
        }

        public void addTask(TaskSchedule task) {
            taskSchedules.add(task);
        }
    }

    static class TaskSchedule {
        private final int startTime;
        private final int endTime;

        public TaskSchedule(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public boolean hasOverlappingHours(TaskSchedule otherTask) {
            return (otherTask.startTime < this.endTime && otherTask.endTime > this.startTime);
        }
    }
}