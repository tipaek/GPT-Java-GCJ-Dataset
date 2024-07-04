import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            StringBuilder schedule = new StringBuilder();
            Map<Character, Integer> endTimes = new HashMap<>();
            boolean isPossible = true;

            endTimes.put('C', intervals[0][1]);
            schedule.append('C');

            for (int i = 1; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                int cEnd = endTimes.getOrDefault('C', -1);
                int jEnd = endTimes.getOrDefault('J', -1);

                if (start >= cEnd) {
                    endTimes.put('C', end);
                    schedule.append('C');
                } else if (start >= jEnd) {
                    endTimes.put('J', end);
                    schedule.append('J');
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            System.out.println(schedule.toString());
        }

        scanner.close();
    }
}