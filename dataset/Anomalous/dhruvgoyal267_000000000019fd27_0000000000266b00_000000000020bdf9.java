import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            Map<String, List<Integer>> scheduleMap = new HashMap<>();
            scheduleMap.put("C", new ArrayList<>());
            scheduleMap.put("J", new ArrayList<>());

            String[] result = new String[n];
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                int[] currentInterval = intervals[i];
                if (canSchedule(scheduleMap.get("C"), intervals, currentInterval)) {
                    scheduleMap.get("C").add(i);
                    result[i] = "C";
                } else if (canSchedule(scheduleMap.get("J"), intervals, currentInterval)) {
                    scheduleMap.get("J").add(i);
                    result[i] = "J";
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + String.join("", result));
            }
        }
    }

    private static boolean canSchedule(List<Integer> scheduledIndices, int[][] intervals, int[] currentInterval) {
        for (int index : scheduledIndices) {
            if (intervalsOverlap(intervals[index], currentInterval)) {
                return false;
            }
        }
        return true;
    }

    private static boolean intervalsOverlap(int[] interval1, int[] interval2) {
        return interval1[0] < interval2[1] && interval2[0] < interval1[1];
    }
}