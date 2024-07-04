import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][3];

            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
                intervals[j][2] = j;
            }

            String result = assignActivities(intervals, n);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static void sortByColumn(int[][] array, int column) {
        Arrays.sort(array, (a, b) -> Integer.compare(a[column], b[column]));
    }

    private static String assignActivities(int[][] intervals, int n) {
        int cEnd = 0;
        int jEnd = 0;
        StringBuilder schedule = new StringBuilder();

        sortByColumn(intervals, 0);

        cEnd = intervals[0][1];
        schedule.append('C');

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= cEnd) {
                schedule.append('C');
                cEnd = intervals[i][1];
            } else if (intervals[i][0] >= jEnd) {
                schedule.append('J');
                jEnd = intervals[i][1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        char[] resultArray = new char[n];
        for (int i = 0; i < n; i++) {
            resultArray[intervals[i][2]] = schedule.charAt(i);
        }

        return new String(resultArray);
    }
}