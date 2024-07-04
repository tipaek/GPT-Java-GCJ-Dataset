import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

            for (int i = 0; i < n; i++) {
                startTimes[i] = intervals[i][0];
                endTimes[i] = intervals[i][1];
            }

            for (int i = 0; i < n; i++) {
                System.out.println(startTimes[i] + " " + endTimes[i]);
            }

            int count = 0;
            int i = 0, j = 0;
            StringBuilder result = new StringBuilder();

            while (i < n && j < n) {
                if (startTimes[i] < endTimes[j]) {
                    count++;
                    i++;
                } else {
                    count--;
                    j++;
                }

                if (count == 1 && result.length() < n) {
                    result.append("C");
                } else if (count == 2 && result.length() < n) {
                    result.append("J");
                }
            }

            if (count > 2) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println(result.toString());
        }

        scanner.close();
    }
}