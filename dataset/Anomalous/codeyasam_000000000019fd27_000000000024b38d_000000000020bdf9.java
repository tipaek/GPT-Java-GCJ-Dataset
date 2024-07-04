import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        
        for (int i = 1; i <= testCaseCount; i++) {
            int activityCount = scanner.nextInt();
            PriorityQueue<TaskSchedule> activitiesQueue = getActivitiesQueue(activityCount, scanner);
            String result = assignTasks(activitiesQueue);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String assignTasks(PriorityQueue<TaskSchedule> activitiesQueue) {
        StringBuilder resultBuilder = new StringBuilder();
        Person cameron = new Person("C");
        Person jamie = new Person("J");

        while (!activitiesQueue.isEmpty()) {
            TaskSchedule currentTask = activitiesQueue.poll();
            String assignedPerson;

            if (cameron.isOverlapping(currentTask) && jamie.isOverlapping(currentTask)) {
                return "IMPOSSIBLE";
            } else if (cameron.isOverlapping(currentTask)) {
                assignedPerson = "J";
            } else {
                assignedPerson = "C";
            }

            if (assignedPerson.equals("J")) {
                jamie.addTask(currentTask);
            } else {
                cameron.addTask(currentTask);
            }

            resultBuilder.append(assignedPerson);
        }

        return resultBuilder.toString();
    }

    private static PriorityQueue<TaskSchedule> getActivitiesQueue(int activityCount, Scanner scanner) {
        PriorityQueue<TaskSchedule> activitiesQueue = new PriorityQueue<>();
        for (int i = 0; i < activityCount; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activitiesQueue.add(new TaskSchedule(start, end));
        }
        return activitiesQueue;
    }

    static class Person {
        private final String name;
        private final List<TaskSchedule> tasks;

        public Person(String name) {
            this.name = name;
            this.tasks = new ArrayList<>();
        }

        public boolean isOverlapping(TaskSchedule task) {
            for (TaskSchedule t : tasks) {
                if (t.isOverlapping(task)) {
                    return true;
                }
            }
            return false;
        }

        public void addTask(TaskSchedule task) {
            tasks.add(task);
        }
    }

    static class TaskSchedule implements Comparable<TaskSchedule> {
        private final int start;
        private final int end;

        public TaskSchedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean isOverlapping(TaskSchedule other) {
            return (this.start < other.end && other.start < this.end);
        }

        @Override
        public int compareTo(TaskSchedule other) {
            return Integer.compare(this.start, other.start);
        }
    }
}