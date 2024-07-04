import java.util.*;
import java.io.*;

public class Solution {

    public static String sequence(int[][] intervals, int N) {
        int[] assignments = new int[N];
        assignments[0] = 1;

        for (int i = 1; i < N; i++) {
            int countC = 1;
            int countJ = 1;

            for (int j = 0; j < i; j++) {
                boolean overlap = (intervals[i][0] < intervals[j][1] && intervals[i][1] > intervals[j][0]);

                if (overlap) {
                    if (assignments[j] == 1) {
                        countC--;
                    } else {
                        countJ--;
                    }
                }
            }

            if (countC == 1) {
                assignments[i] = 1;
            } else if (countJ == 1) {
                assignments[i] = 0;
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder seq = new StringBuilder("C");
        for (int i = 1; i < N; i++) {
            seq.append(assignments[i] == 1 ? "C" : "J");
        }

        return seq.toString();
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

            String sequence = sequence(intervals, N);
            System.out.println("Case #" + i + ": " + sequence);
        }
    }
}