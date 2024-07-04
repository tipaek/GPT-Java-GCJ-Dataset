import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int numIntervals = scanner.nextInt();
            int[][] intervals = new int[numIntervals][2];

            for (int i = 0; i < numIntervals; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            StringBuilder result = new StringBuilder();
            int[] endTimes = new int[2];

            for (int[] interval : intervals) {
                if (endTimes[0] <= interval[0]) {
                    endTimes[0] = interval[1];
                    result.append('C');
                } else if (endTimes[1] <= interval[0]) {
                    endTimes[1] = interval[1];
                    result.append('J');
                } else {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNumber++ + ": " + result.toString());
        }

        scanner.close();
    }
}