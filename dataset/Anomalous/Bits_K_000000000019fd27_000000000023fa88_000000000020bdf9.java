import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }

            String result = assignActivities(intervals);
            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }

    private static String assignActivities(int[][] intervals) {
        Map<Character, List<int[]>> schedules = new HashMap<>();
        schedules.put('C', new ArrayList<>());
        schedules.put('J', new ArrayList<>());

        StringBuilder ans = new StringBuilder();

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (canAssign(schedules.get('C'), start, end)) {
                schedules.get('C').add(new int[]{start, end});
                ans.append('C');
            } else if (canAssign(schedules.get('J'), start, end)) {
                schedules.get('J').add(new int[]{start, end});
                ans.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }
        return ans.toString();
    }

    private static boolean canAssign(List<int[]> schedule, int start, int end) {
        for (int[] interval : schedule) {
            if (intervalsOverlap(interval, new int[]{start, end})) {
                return false;
            }
        }
        return true;
    }

    private static boolean intervalsOverlap(int[] interval1, int[] interval2) {
        return !(interval1[1] <= interval2[0] || interval2[1] <= interval1[0]);
    }
}