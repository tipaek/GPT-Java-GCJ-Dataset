import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCasesCount = in.nextInt();
        for (int i = 1; i <= testCasesCount; i++) {
            int activitiesCount = in.nextInt();
            PriorityQueue<TaskSchedule> activitiesTime = retrieveActivitiesTime(activitiesCount, in); 
            String output = taskAssignment(activitiesTime);
            System.out.println("Case #" + i + ": " + output);
        }
    }

    private static String taskAssignment(PriorityQueue<TaskSchedule> activitiesQueue) {
        StringBuilder sb = new StringBuilder();
        Person cameron = new Person("C");
        Person jamie = new Person("J");
        TaskSchedule previousActivityTime = null;
        while (!activitiesQueue.isEmpty()) {
            TaskSchedule currentActivityTime = activitiesQueue.remove();
            final String toBeAdded;

            if (cameron.hasOverlappingHours(currentActivityTime) &&
                       jamie.hasOverlappingHours(currentActivityTime)) {
                return "IMPOSSIBLE";
            } else if (cameron.hasOverlappingHours(currentActivityTime)) {
                toBeAdded = "J";
            } else if (jamie.hasOverlappingHours(currentActivityTime)) {
                toBeAdded = "C";
            } else {
                toBeAdded = "C";
            }

            if (Objects.equals("J", toBeAdded)) {
                jamie.taskSchedules.add(currentActivityTime);
            } else {
                cameron.taskSchedules.add(currentActivityTime);
            }
            previousActivityTime = currentActivityTime;
            sb.append(toBeAdded);
        }

        return sb.toString();
    }

    private static PriorityQueue<TaskSchedule> retrieveActivitiesTime(int activitiesCount, Scanner in) {
        PriorityQueue<TaskSchedule> activitiesTime = new PriorityQueue<>();
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

    static class TaskSchedule implements Comparable<TaskSchedule> {

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

        @Override 
        public int compareTo(TaskSchedule taskSchedule) {
            if (startTime > taskSchedule.startTime) return 1;
            else if (startTime < taskSchedule.startTime) return -1;
            return 0;
        }
    }    
}   

