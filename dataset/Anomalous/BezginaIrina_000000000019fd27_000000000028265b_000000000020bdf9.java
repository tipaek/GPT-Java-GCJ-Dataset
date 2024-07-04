import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(scanner.nextLine());
            int[][] intervals = new int[N][3];
            int[][] assignments = new int[N][2];

            boolean impossible = false;
            for (int i = 0; i < N; i++) {
                String[] input = (scanner.nextLine() + " " + i).split(" ");
                intervals[i][0] = Integer.parseInt(input[0]);
                intervals[i][1] = Integer.parseInt(input[1]);
                intervals[i][2] = Integer.parseInt(input[2]);

                if (intervals[i][0] > 1440 || intervals[i][1] > 1440) {
                    System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            if (impossible) continue;

            Arrays.sort(intervals, Comparator.comparingInt((int[] x) -> x[0]).thenComparingInt(x -> x[1]));

            int endC = 0, endJ = 0;
            assignments[0][0] = intervals[0][2];
            assignments[0][1] = 1; // Cameron
            endC = intervals[0][1];

            for (int i = 1; i < N; i++) {
                if (intervals[i][0] >= endC) {
                    assignments[i][1] = 1; // Cameron
                    endC = intervals[i][1];
                } else if (intervals[i][0] >= endJ) {
                    assignments[i][1] = 2; // Jamie
                    endJ = intervals[i][1];
                } else {
                    System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                    impossible = true;
                    break;
                }
                assignments[i][0] = intervals[i][2];
            }

            if (impossible) continue;

            Arrays.sort(assignments, Comparator.comparingInt(x -> x[0]));

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < N; i++) {
                result.append(assignments[i][1] == 1 ? 'C' : 'J');
            }

            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }
}