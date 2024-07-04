import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nt = sc.nextInt();
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < nt; t++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }

            result.append("Case #").append(t + 1).append(": ").append(assignTasks(intervals)).append("\n");
        }

        System.out.print(result.toString());
    }

    private static String assignTasks(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        int cEnd = 0, jEnd = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (intervals[i][0] >= cEnd) {
                cEnd = intervals[i][1];
                result.append("C");
            } else if (intervals[i][0] >= jEnd) {
                jEnd = intervals[i][1];
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }
}