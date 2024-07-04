import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCasesCount = in.nextInt();
        for (int i = 1; i <= testCasesCount; i++) {
            int activitiesCount = in.nextInt();
            List<Integer[]> activitiesTime = retrieveActivitiesTime(activitiesCount, in); 
            String output = taskAssignment(activitiesTime);
            System.out.println("Case #" + i + ": " + output);
        }
    }

    private static String taskAssignment(List<Integer[]> activitiesTime) {
        if (activitiesTime.isEmpty()) return "";

        StringBuilder sb = new StringBuilder("C");
        Integer[] firstActivityTime = activitiesTime.get(0);
        Person cameron = new Person("C");
        Person jamie = new Person("J");
        cameron.taskSchedules.add(new TaskSchedule(firstActivityTime[0], firstActivityTime[1]));
        
        // for (int i = 1; i < activitiesTime.size(); i++) {
        //     Integer[] currentActivityTime = activitiesTime.get(i);
        //     Integer[] previousActivityTime = activitiesTime.get(i - 1);
        //     String toBeAdded = "";
        //     if (cameron.hasOverlappingHours(currentActivityTime) &&
        //                jamie.hasOverlappingHours(currentActivityTime)) {
        //         return "IMPOSSIBLE";
        //     } else if (cameron.hasOverlappingHours(currentActivityTime)) {
        //         toBeAdded = "J";
        //     } else if (jamie.hasOverlappingHours(currentActivityTime)) {
        //         toBeAdded = "C";
        //     } else if (Objects.equals(currentActivityTime[0],previousActivityTime[1])) {
        //         toBeAdded = sb.substring(sb.length() - 1);
        //     } else {
        //         toBeAdded = "C";
        //     }

        //     TaskSchedule taskSchedule = new TaskSchedule(currentActivityTime[0], currentActivityTime[1]);
        //     if (Objects.equals("J", toBeAdded)) {
        //         jamie.taskSchedules.add(taskSchedule);
        //     } else {
        //         cameron.taskSchedules.add(taskSchedule);
        //     }

        //     sb.append(toBeAdded);
        // }

        return sb.toString();
    }

    private static List<Integer[]> retrieveActivitiesTime(int activitiesCount, Scanner in) {
        List<Integer[]> activitiesTime = new ArrayList<>();
        for (int i = 0; i < activitiesCount; i++) {
            int startTime = in.nextInt();
            int endTime = in.nextInt();
            activitiesTime.add(new Integer[] {startTime, endTime});
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

        public boolean hasOverlappingHours(Integer[] otherTaskTime) {
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

        public boolean hasOverlappingHours(Integer[] otherTaskTime) {
            int os = otherTaskTime[0];
            int oe = otherTaskTime[1];

            if (os >= startTime && os < endTime) return true;
            else if (oe > startTime && oe <= endTime) return true;
            else if (os <= startTime && endTime <= oe) return true;

            return false;
        }

    }    
}   

