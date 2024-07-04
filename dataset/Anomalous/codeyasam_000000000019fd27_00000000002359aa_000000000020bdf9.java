import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int numberOfActivities = scanner.nextInt();
            List<Activity> activities = getActivityTimes(numberOfActivities, scanner);
            String result = assignTasks(activities);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static String assignTasks(List<Activity> activities) {
        StringBuilder assignment = new StringBuilder("C");
        Activity firstActivity = activities.get(0);
        Person cameron = new Person("C");
        Person jamie = new Person("J");
        cameron.addTask(firstActivity);

        for (int i = 1; i < activities.size(); i++) {
            Activity currentActivity = activities.get(i);
            String taskAssignee = "C";
            
            if (cameron.hasConflict(currentActivity) && jamie.hasConflict(currentActivity)) {
                return "IMPOSSIBLE";
            } else if (cameron.hasConflict(currentActivity)) {
                taskAssignee = "J";
            } else if (jamie.hasConflict(currentActivity)) {
                taskAssignee = "C";
            } else if (currentActivity.getStartTime().equals(activities.get(i - 1).getEndTime())) {
                taskAssignee = assignment.substring(assignment.length() - 1);
            }

            if (taskAssignee.equals("J")) {
                jamie.addTask(currentActivity);
            } else {
                cameron.addTask(currentActivity);
            }

            assignment.append(taskAssignee);
        }

        return assignment.toString();
    }

    private static List<Activity> getActivityTimes(int numberOfActivities, Scanner scanner) {
        List<Activity> activities = new ArrayList<>();
        for (int i = 0; i < numberOfActivities; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.add(new Activity(start, end));
        }
        return activities;
    }

    static class Person {
        private String name;
        private List<Activity> tasks;

        public Person(String name) {
            this.name = name;
            this.tasks = new ArrayList<>();
        }

        public void addTask(Activity activity) {
            tasks.add(activity);
        }

        public boolean hasConflict(Activity activity) {
            for (Activity task : tasks) {
                if (task.conflictsWith(activity)) {
                    return true;
                }
            }
            return false;
        }
    }

    static class Activity {
        private Integer startTime;
        private Integer endTime;

        public Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public Integer getStartTime() {
            return startTime;
        }

        public Integer getEndTime() {
            return endTime;
        }

        public boolean conflictsWith(Activity other) {
            return (this.startTime < other.endTime && other.startTime < this.endTime);
        }
    }
}