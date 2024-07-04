import java.util.Scanner;
import java.util.Arrays;

public class ParentingPartneringReturns {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            boolean[] cTime = new boolean[1440];
            boolean[] jTime = new boolean[1440];
            String result = "CJ";

            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            // Assign the first two intervals
            Arrays.fill(cTime, intervals[0][0], intervals[0][1], true);
            Arrays.fill(jTime, intervals[1][0], intervals[1][1], true);

            boolean possible = true;

            for (int i = 2; i < n && possible; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];

                boolean cAvailable = !isBusy(cTime, start, end);
                boolean jAvailable = !isBusy(jTime, start, end);

                if (cAvailable) {
                    Arrays.fill(cTime, start, end, true);
                    result += "C";
                } else if (jAvailable) {
                    Arrays.fill(jTime, start, end, true);
                    result += "J";
                } else {
                    result = "IMPOSSIBLE";
                    possible = false;
                }
            }

            System.out.println("Case #" + t + ": " + result);
        }

        scanner.close();
    }

    private static boolean isBusy(boolean[] time, int start, int end) {
        for (int i = start; i < end; i++) {
            if (time[i]) {
                return true;
            }
        }
        return false;
    }
}