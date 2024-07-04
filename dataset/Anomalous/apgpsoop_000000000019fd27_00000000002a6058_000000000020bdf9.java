import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            int[][] intervals = new int[n][4];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                intervals[i][2] = i;
                intervals[i][3] = 0;
                scanner.nextLine();
            }

            Arrays.sort(intervals, (a, b) -> {
                if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            });

            intervals[0][3] = 1;
            int endTimeC = intervals[0][1];
            boolean isPossible = true;

            for (int i = 1; i < n; i++) {
                if (intervals[i][0] >= endTimeC) {
                    intervals[i][3] = 1;
                    endTimeC = intervals[i][1];
                }
            }

            int endTimeJ = -1;
            for (int i = 1; i < n; i++) {
                if (intervals[i][3] == 0) {
                    if (endTimeJ > intervals[i][0]) {
                        isPossible = false;
                        break;
                    }
                    endTimeJ = intervals[i][1];
                }
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[2]));

            System.out.print("Case #" + (t + 1) + ": ");
            if (isPossible) {
                for (int[] interval : intervals) {
                    System.out.print(interval[3] == 0 ? "J" : "C");
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}