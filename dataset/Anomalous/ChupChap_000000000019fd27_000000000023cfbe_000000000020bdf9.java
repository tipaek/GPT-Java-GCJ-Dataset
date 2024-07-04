import java.util.*;
import java.io.*;

public class Solution {

    public static String sequence(int[][] intervals, int N) {
        int[] assignments = new int[N];
        assignments[0] = 1; // Assign the first task to Cameron ('C')

        for (int i = 1; i < N; i++) {
            boolean canAssignToCameron = true;
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] < intervals[j][1] && intervals[i][1] > intervals[j][0]) {
                    if (assignments[j] == 1) {
                        canAssignToCameron = false;
                        break;
                    }
                }
            }
            assignments[i] = canAssignToCameron ? 1 : 0;
        }

        StringBuilder schedule = new StringBuilder("C");
        for (int i = 1; i < N; i++) {
            schedule.append(assignments[i] == 1 ? 'C' : 'J');
        }

        return schedule.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int i = 1; i <= T; ++i) {
            int N = in.nextInt();
            int[][] intervals = new int[N][2];
            for (int j = 0; j < N; j++) {
                intervals[j][0] = in.nextInt();
                intervals[j][1] = in.nextInt();
            }
            String result = sequence(intervals, N);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}