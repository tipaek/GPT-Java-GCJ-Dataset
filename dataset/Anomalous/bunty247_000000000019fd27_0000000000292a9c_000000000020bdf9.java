package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class ParentingPartneringReturns {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                                     .mapToInt(Integer::parseInt)
                                     .toArray();
            }

            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

            StringBuilder schedule = new StringBuilder("C");
            int endC = intervals[0][1];
            int endJ = -1;
            boolean possible = true;

            for (int i = 1; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];

                if (start >= endC) {
                    schedule.append('C');
                    endC = end;
                } else if (start >= endJ) {
                    schedule.append('J');
                    endJ = end;
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                schedule = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + testCase + ": " + schedule.toString());
        }
    }
}