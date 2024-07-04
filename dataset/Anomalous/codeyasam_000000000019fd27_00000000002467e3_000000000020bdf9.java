import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int numberOfActivities = scanner.nextInt();
            PriorityQueue<Activity> activitiesQueue = getActivities(numberOfActivities, scanner);
            String result = assignTasks(activitiesQueue);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static String assignTasks(PriorityQueue<Activity> activitiesQueue) {
        StringBuilder result = new StringBuilder();
        Person cameron = new Person("C");
        Person jamie = new Person("J");

        while (!activitiesQueue.isEmpty()) {
            Activity currentActivity = activitiesQueue.poll();
            String assignedPerson;

            if (cameron.isOverlapping(currentActivity) && jamie.isOverlapping(currentActivity)) {
                return "IMPOSSIBLE";
            } else if (cameron.isOverlapping(currentActivity)) {
                assignedPerson = "J";
            } else if (jamie.isOverlapping(currentActivity)) {
                assignedPerson = "C";
            } else {
                assignedPerson = "C";
            }

            if ("J".equals(assignedPerson)) {
                jamie.addActivity(currentActivity);
            } else {
                cameron.addActivity(currentActivity);
            }

            result.append(assignedPerson);
        }

        return result.toString();
    }

    private static PriorityQueue<Activity> getActivities(int numberOfActivities, Scanner scanner) {
        PriorityQueue<Activity> activitiesQueue = new PriorityQueue<>();
        for (int i = 0; i < numberOfActivities; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activitiesQueue.add(new Activity(start, end));
        }
        return activitiesQueue;
    }

    static class Person {
        private String name;
        private List<Activity> activities;

        public Person(String name) {
            this.name = name;
            this.activities = new ArrayList<>();
        }

        public boolean isOverlapping(Activity newActivity) {
            for (Activity activity : activities) {
                if (activity.isOverlapping(newActivity)) {
                    return true;
                }
            }
            return false;
        }

        public void addActivity(Activity activity) {
            activities.add(activity);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class Activity implements Comparable<Activity> {
        private int start;
        private int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean isOverlapping(Activity other) {
            return (this.start < other.end && this.end > other.start);
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }
    }
}