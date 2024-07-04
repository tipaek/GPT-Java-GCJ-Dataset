import java.util.*;
import java.io.*;

public class Solution {

    public static String sequence(int[][] intervals, int N) {
        int[] assignments = new int[N];
        assignments[0] = 1;

        for (int i = 1; i < N; i++) {
            int c = 1;
            int j1 = 1;
            for (int j = 0; j < i; j++) {
                if ((intervals[i][0] > intervals[j][0] && intervals[i][0] < intervals[j][1]) ||
                    (intervals[i][1] > intervals[j][0] && intervals[i][1] < intervals[j][1]) ||
                    (intervals[i][0] <= intervals[j][0] && intervals[i][1] >= intervals[j][1])) {
                    if (assignments[j] == 1) {
                        c--;
                    } else if (assignments[j] == 0) {
                        j1--;
                    }
                }
            }
            if (c == 1) {
                assignments[i] = 1;
            } else if (j1 == 1) {
                assignments[i] = 0;
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder sequence = new StringBuilder("C");
        for (int k = 1; k < N; k++) {
            sequence.append(assignments[k] == 1 ? "C" : "J");
        }
        return sequence.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = scanner.nextInt();
            int[][] intervals = new int[N][2];
            for (int j = 0; j < N; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }
            String result = sequence(intervals, N);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}