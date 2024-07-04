import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int test = 1; test <= testCases; test++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][3];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
                intervals[i][2] = i;
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            System.out.print("Case #" + test + ": ");
            int[] assignments = assignActivities(intervals);

            if (assignments == null) {
                System.out.println("IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (int assignment : assignments) {
                    result.append(assignment == 0 ? 'C' : 'J');
                }
                System.out.println(result);
            }
        }
    }

    private static int[] assignActivities(int[][] intervals) {
        int[] assignments = new int[intervals.length];
        int cEnd = 0, jEnd = 0;

        for (int[] interval : intervals) {
            if (interval[0] >= cEnd) {
                cEnd = interval[1];
                assignments[interval[2]] = 0;
            } else if (interval[0] >= jEnd) {
                jEnd = interval[1];
                assignments[interval[2]] = 1;
            } else {
                return null;
            }
        }

        return assignments;
    }
}