import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCasesCount = in.nextInt();
        for (int i = 1; i <= testCasesCount; i++) {
            int activitiesCount = in.nextInt();
            List<TaskSchedule> activitiesTime = retrieveActivitiesTime(activitiesCount, in); 
            String output = taskAssignment(activitiesTime);
            System.out.println("Case #" + i + ": " + output);
        }
    }

    private static String taskAssignment(List<TaskSchedule> activitiesTimeList) {
        StringBuilder sb = new StringBuilder();
        Person cameron = new Person("C");
        Person jamie = new Person("J");

        for (int i = 0; i < activitiesTimeList.size(); i++) {
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
            if (Objects.equals("J", toBeAdded)) {
                jamie.taskSchedules.add(taskSchedule);
            } else {
                cameron.taskSchedules.add(taskSchedule);
            }

            sb.append(toBeAdded);
        }

        return sb.toString();
    }

    private static List<TaskSchedule> retrieveActivitiesTime(int activitiesCount, Scanner in) {
        List<TaskSchedule> activitiesTime = new ArrayList<>();
        for (int i = 0; i < activitiesCount; i++) {
            int startTime = in.nextInt();
            int endTime = in.nextInt();
            activitiesTime.add(new TaskSchedule(startTime, endTime));
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

