import java.util.*;
import java.io.*;

public class Solution {

    static class Activity implements Comparable<Activity> {
        int start;
        int end;

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
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
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int numberOfActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < numberOfActivities; i++) {
                Activity activity = new Activity();
                activity.start = scanner.nextInt();
                activity.end = scanner.nextInt();
                activities.add(activity);
            }

            Collections.sort(activities);
            StringBuilder result = new StringBuilder();
            PriorityQueue<Task> taskQueue = new PriorityQueue<>();
            boolean isJAssigned = false;
            boolean isCAssigned = false;

            for (Activity activity : activities) {
                while (!taskQueue.isEmpty() && taskQueue.peek().end <= activity.start) {
                    Task finishedTask = taskQueue.poll();
                    if (finishedTask.assignedTo == 'J') {
                        isJAssigned = false;
                    } else if (finishedTask.assignedTo == 'C') {
                        isCAssigned = false;
                    }
                }

                if (!isCAssigned) {
                    isCAssigned = true;
                    taskQueue.add(new Task(activity.start, activity.end, 'C'));
                    result.append('C');
                } else if (!isJAssigned) {
                    isJAssigned = true;
                    taskQueue.add(new Task(activity.start, activity.end, 'J'));
                    result.append('J');
                } else {
                    System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                    continue;
                }
            }

            System.out.println("Case #" + caseNum + ": " + result.toString());
        }
    }
}