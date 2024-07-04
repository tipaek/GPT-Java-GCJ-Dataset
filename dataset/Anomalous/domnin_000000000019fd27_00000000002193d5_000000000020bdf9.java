import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int N = scanner.nextInt();
            int[][] intervals = new int[N][3];

            for (int i = 0; i < N; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                intervals[i][2] = i;
            }

            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            char[] result = new char[N];
            int[] endTimes = new int[2];
            int assignedTasks = 0;

            for (int[] interval : intervals) {
                if (endTimes[0] <= interval[0]) {
                    endTimes[0] = interval[1];
                    result[interval[2]] = 'C';
                    assignedTasks++;
                } else if (endTimes[1] <= interval[0]) {
                    endTimes[1] = interval[1];
                    result[interval[2]] = 'J';
                    assignedTasks++;
                } else {
                    break;
                }
            }

            if (assignedTasks < N) {
                System.out.println("Case #" + caseNumber++ + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber++ + ": " + new String(result));
            }
        }

        scanner.close();
    }
}