import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String assignTasks(List<TaskSchedule> activitiesTimeList) {
        StringBuilder result = new StringBuilder();
        Person cameron = new Person("C");
        Person jamie = new Person("J");

        for (TaskSchedule activity : activitiesTimeList) {
            String assignedPerson;

            boolean cameronConflict = cameron.hasConflict(activity);
            boolean jamieConflict = jamie.hasConflict(activity);

            if (cameronConflict && jamieConflict) {
                return "IMPOSSIBLE";
            } else if (cameronConflict) {
                assignedPerson = "J";
            } else {
                assignedPerson = "C";
            }

            TaskSchedule newTask = new TaskSchedule(activity.startTime, activity.endTime);
            if ("J".equals(assignedPerson)) {
                jamie.addTask(newTask);
            } else {
                cameron.addTask(newTask);
            }

            result.append(assignedPerson);
        }

        return result.toString();
    }

    private static List<TaskSchedule> retrieveActivitiesTime(int activitiesCount, BufferedReader reader) {
        List<TaskSchedule> activities = new ArrayList<>();
        for (int i = 0; i < activitiesCount; i++) {
            try {
                String schedule = reader.readLine();
                if (schedule != null && !schedule.trim().isEmpty()) {
                    String[] times = schedule.split(" ");
                    int startTime = Integer.parseInt(times[0]);
                    int endTime = Integer.parseInt(times[1]);
                    activities.add(new TaskSchedule(startTime, endTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
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

        public boolean hasConflict(TaskSchedule task) {
            for (TaskSchedule t : tasks) {
                if (t.conflictsWith(task)) {
                    return true;
                }
            }
            return false;
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
        private final int startTime;
        private final int endTime;

        public TaskSchedule(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public boolean conflictsWith(TaskSchedule other) {
            return (other.startTime < this.endTime && other.endTime > this.startTime);
        }
    }
}