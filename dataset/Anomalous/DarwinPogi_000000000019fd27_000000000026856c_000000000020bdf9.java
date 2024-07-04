import java.util.*;
import java.io.*;

public class Solution {

    public static int[][] readIntervals(int N, Scanner scanner) {
        int[][] intervals = new int[N][2];
        for (int i = 0; i < N; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }
        return intervals;
    }

    public static void handleTestCase(int caseNumber, int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int endJ = -1;
        int endC = -1;
        StringBuilder result = new StringBuilder();

        for (int[] interval : intervals) {
            if (endJ == -1 || interval[0] >= endJ) {
                endJ = interval[1];
                result.append('J');
            } else if (endC == -1 || interval[0] >= endC) {
                endC = interval[1];
                result.append('C');
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = scanner.nextInt();
            int[][] intervals = readIntervals(N, scanner);
            handleTestCase(i, intervals);
        }
    }
}