import java.util.*;

class Solution {

    public static void assignActivities(int caseNo, int noActivities, List<int[]> activities) {
        PriorityQueue<int[]> activityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        activityQueue.addAll(activities);

        StringBuilder result = new StringBuilder("C");
        int cLastEndTime = activityQueue.peek()[1];
        int jLastEndTime = 0;

        activityQueue.poll(); // Remove the first activity as it's already assigned to 'C'

        while (!activityQueue.isEmpty()) {
            int[] currentActivity = activityQueue.poll();

            if (cLastEndTime <= currentActivity[0]) {
                result.append('C');
                cLastEndTime = currentActivity[1];
            } else if (jLastEndTime <= currentActivity[0]) {
                result.append('J');
                jLastEndTime = currentActivity[1];
            } else {
                System.out.println("Case #" + caseNo + ": IMPOSSIBLE");
                return;
            }
        }

        System.out.println("Case #" + caseNo + ": " + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for (int caseNo = 1; caseNo <= cases; caseNo++) {
            int noActivities = scanner.nextInt();
            List<int[]> activities = new ArrayList<>();

            for (int i = 0; i < noActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new int[]{start, end});
            }

            assignActivities(caseNo, noActivities, activities);
        }

        scanner.close();
    }
}