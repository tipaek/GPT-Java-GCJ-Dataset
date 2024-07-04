import java.util.*;
import java.io.*;

public class Solution {

    private static int[] findOriginalInterval(int[][] intervals, int[][] sortedIntervals, int index) {
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] == sortedIntervals[index][0] && intervals[i][1] == sortedIntervals[index][1]) {
                return intervals[i];
            }
        }
        return intervals[0];
    }

    private static void scheduleIntervals(int[][] intervals, int caseNumber) {
        int[][] sortedIntervals = Arrays.copyOf(intervals, intervals.length);
        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        Map<int[], String> assignmentMap = new HashMap<>();
        StringBuilder result = new StringBuilder();

        List<int[]> jIntervals = new ArrayList<>();
        List<int[]> cIntervals = new ArrayList<>();

        jIntervals.add(sortedIntervals[0]);
        assignmentMap.put(findOriginalInterval(intervals, sortedIntervals, 0), "J");

        for (int i = 1; i < sortedIntervals.length; i++) {
            int[] currentInterval = sortedIntervals[i];
            int[] lastJInterval = jIntervals.get(jIntervals.size() - 1);
            int[] lastCInterval = cIntervals.isEmpty() ? null : cIntervals.get(cIntervals.size() - 1);

            if (lastCInterval == null) {
                cIntervals.add(currentInterval);
                assignmentMap.put(findOriginalInterval(intervals, sortedIntervals, i), "C");
            } else if ((currentInterval[0] < lastJInterval[1] && currentInterval[0] < lastCInterval[1])) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            } else if (currentInterval[0] < lastJInterval[1]) {
                cIntervals.add(currentInterval);
                assignmentMap.put(findOriginalInterval(intervals, sortedIntervals, i), "C");
            } else {
                jIntervals.add(currentInterval);
                assignmentMap.put(findOriginalInterval(intervals, sortedIntervals, i), "J");
            }
        }

        for (int[] interval : intervals) {
            result.append(assignmentMap.get(interval));
        }
        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }
            scheduleIntervals(intervals, i);
        }
    }
}