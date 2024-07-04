import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int testCasesCount = Integer.parseInt(reader.readLine().trim());
            for (int i = 1; i <= testCasesCount; i++) {
                int activitiesCount = Integer.parseInt(reader.readLine().trim());
                List<TaskSchedule> activitiesTime = retrieveActivitiesTime(activitiesCount, reader); 
                String output = taskAssignment(activitiesTime);
                System.out.println("Case #" + i + ": " + output);
            }
        } catch (Exception e) {

        }

    }

    public static String taskAssignment(List<TaskSchedule> activitiesTimeList) {
        StringBuilder sb = new StringBuilder("");
        Person cameron = new Person("C");
        Person jamie = new Person("J");

        for (int i = 0; i < activitiesTimeList.size(); i++) {

            try {
                TaskSchedule currentActivityTime = activitiesTimeList.get(i);
                final String toBeAdded;

                boolean cameronHasOverlappingHours = cameron.hasOverlappingHours(currentActivityTime);
                boolean jamieHasOverlappingHours = jamie.hasOverlappingHours(currentActivityTime);

                if (cameronHasOverlappingHours && jamieHasOverlappingHours) {
                    return "IMPOSSIBLE";
                } else if (cameronHasOverlappingHours) {
                    toBeAdded = "J";
                } else if (jamieHasOverlappingHours) {
                    toBeAdded = "C";
                } else {
                    toBeAdded = "C";
                }

                TaskSchedule taskSchedule = new TaskSchedule(currentActivityTime.startTime, currentActivityTime.endTime);
                if (toBeAdded.equals("J")) {
                    jamie.taskSchedules.add(taskSchedule);
                } else {
                    cameron.taskSchedules.add(taskSchedule);
                }

                sb.append(toBeAdded);
            } catch (Exception e) {

            }

        }

        return sb.toString();
    }

    private static List<TaskSchedule> retrieveActivitiesTime(int activitiesCount, BufferedReader reader) {
        List<TaskSchedule> activitiesTime = new ArrayList<>();
        for (int i = 0; i < activitiesCount; i++) {
            try {
                String schedule = reader.readLine();
                if (schedule != null && !schedule.trim().isEmpty()) {
                    String[] scheduleParts = schedule.split(" ");
                    int startTime = Integer.parseInt(scheduleParts[0]);
                    int endTime = Integer.parseInt(scheduleParts[1]);
                    activitiesTime.add(new TaskSchedule(startTime, endTime));
                }
            } catch (Exception e) {

            }
        }
        return activitiesTime;
    }

    static class Person {

        String initial;
        List<TaskSchedule> taskSchedules;

        public Person(String initial) {
            this.initial = initial;
            this.taskSchedules = new ArrayList<>();
        }

        public boolean hasOverlappingHours(TaskSchedule otherTaskTime) {
            if (taskSchedules == null || taskSchedules.isEmpty()) return false;
            for (TaskSchedule t: taskSchedules) {
                if (t.hasOverlappingHours(otherTaskTime)) return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return initial;
        }

    }

    static class TaskSchedule {

        int startTime;
        int endTime;

        public TaskSchedule(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public boolean hasOverlappingHours(TaskSchedule otherTaskTime) {
            int os = otherTaskTime.startTime;
            int oe = otherTaskTime.endTime;

            if (os >= startTime && os < endTime) return true;
            else if (oe > startTime && oe <= endTime) return true;
            else if (os <= startTime && endTime <= oe) return true;

            return false;

        }
    }    
}   

