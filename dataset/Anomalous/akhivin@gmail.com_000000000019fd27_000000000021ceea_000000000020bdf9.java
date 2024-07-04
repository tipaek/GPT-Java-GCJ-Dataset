import java.util.*;
import java.io.*;

public class Solution {

    static class Activity implements Comparable<Activity> {
        int index;
        int start;
        int end;
        char assignedTo = '?';

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "index=" + index +
                    ", start=" + start +
                    ", end=" + end +
                    ", assignedTo=" + assignedTo +
                    '}';
        }
    }

    static class Task implements Comparable<Task> {
        int start;
        int end;
        char assignedTo;

        public Task(int start, int end, char assignedTo) {
            this.start = start;
            this.end = end;
            this.assignedTo = assignedTo;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.end, other.end);
        }

        @Override
        public String toString() {
            return "Task{" +
                    "start=" + start +
                    ", end=" + end +
                    ", assignedTo=" + assignedTo +
                    '}';
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int numActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < numActivities; i++) {
                Activity activity = new Activity();
                activity.index = i;
                activity.start = scanner.nextInt();
                activity.end = scanner.nextInt();
                activities.add(activity);
            }

            PriorityQueue<Task> taskQueue = new PriorityQueue<>();
            boolean isJBusy = false;
            boolean isCBusy = false;

            Collections.sort(activities);

            for (Activity activity : activities) {
                while (!taskQueue.isEmpty() && taskQueue.peek().end <= activity.start) {
                    Task finishedTask = taskQueue.poll();
                    if (finishedTask.assignedTo == 'J') {
                        isJBusy = false;
                    } else if (finishedTask.assignedTo == 'C') {
                        isCBusy = false;
                    }
                }

                if (!isCBusy) {
                    isCBusy = true;
                    taskQueue.add(new Task(activity.start, activity.end, 'C'));
                    activity.assignedTo = 'C';
                } else if (!isJBusy) {
                    isJBusy = true;
                    taskQueue.add(new Task(activity.start, activity.end, 'J'));
                    activity.assignedTo = 'J';
                } else {
                    System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                    continue;
                }
            }

            activities.sort(Comparator.comparingInt(a -> a.index));
            StringBuilder result = new StringBuilder();
            for (Activity activity : activities) {
                result.append(activity.assignedTo);
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }
}