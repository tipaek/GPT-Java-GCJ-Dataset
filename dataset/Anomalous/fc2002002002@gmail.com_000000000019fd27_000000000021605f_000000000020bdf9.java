import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        for (int i = 0; i < testCaseCount; i++) {
            int activityCount = scanner.nextInt();
            List<int[]> activities = new ArrayList<>();
            for (int j = 0; j < activityCount; j++) {
                activities.add(new int[]{scanner.nextInt(), scanner.nextInt(), j});
            }
            String result = assignActivities(activities);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String assignActivities(List<int[]> activities) {
        PriorityQueue<Integer> startTimes = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        PriorityQueue<Integer> endTimes = new PriorityQueue<>(Comparator.comparingInt(a -> a));

        for (int[] activity : activities) {
            startTimes.offer(activity[0]);
            endTimes.offer(activity[1]);
        }

        int concurrentActivities = 0;
        while (!startTimes.isEmpty()) {
            if (startTimes.peek() < endTimes.peek()) {
                concurrentActivities++;
                startTimes.poll();
            } else {
                concurrentActivities--;
                endTimes.poll();
            }
            if (concurrentActivities > 2) {
                return "IMPOSSIBLE";
            }
        }

        activities.sort(Comparator.comparingInt(a -> a[0]));
        char[] assignment = new char[activities.size()];
        int currentEnd = -1;
        char currentPerson = 'C';

        for (int[] activity : activities) {
            if (activity[0] >= currentEnd) {
                currentEnd = activity[1];
                assignment[activity[2]] = currentPerson;
            } else {
                currentPerson = (currentPerson == 'C') ? 'J' : 'C';
                currentEnd = activity[1];
                assignment[activity[2]] = currentPerson;
            }
        }

        return new String(assignment);
    }
}