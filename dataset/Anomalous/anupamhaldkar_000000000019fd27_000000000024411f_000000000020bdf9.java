import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int numIntervals = scanner.nextInt();
            int[][] intervals = new int[numIntervals][4];

            for (int i = 0; i < numIntervals; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                intervals[i][2] = i;
            }

            String result = assignTasks(intervals);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    public static String assignTasks(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int endC = 0, endJ = 0;
        StringBuilder schedule = new StringBuilder();

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (start >= endC) {
                endC = end;
                interval[3] = 1; // Assigned to C
            } else if (start >= endJ) {
                endJ = end;
                interval[3] = 2; // Assigned to J
            } else {
                return "IMPOSSIBLE";
            }
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[2]));

        for (int[] interval : intervals) {
            if (interval[3] == 1) {
                schedule.append("C");
            } else if (interval[3] == 2) {
                schedule.append("J");
            }
        }

        return schedule.toString();
    }
}