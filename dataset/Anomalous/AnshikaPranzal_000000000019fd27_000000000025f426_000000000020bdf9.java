import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][4];

            for (int j = 0; j < n; j++) {
                intervals[j][0] = sc.nextInt();
                intervals[j][1] = sc.nextInt();
                intervals[j][2] = j;  // store original index
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            intervals[0][3] = 0;  // assign first task to C
            int cEnd = intervals[0][1];
            int jEnd = 0;
            boolean impossible = false;

            for (int j = 1; j < n; j++) {
                if (cEnd <= intervals[j][0]) {
                    intervals[j][3] = 0;  // assign to C
                    cEnd = intervals[j][1];
                } else if (jEnd <= intervals[j][0]) {
                    intervals[j][3] = 1;  // assign to J
                    jEnd = intervals[j][1];
                } else {
                    impossible = true;
                    break;
                }
            }

            System.out.print("Case #" + (i + 1) + ": ");
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                Arrays.sort(intervals, Comparator.comparingInt(a -> a[2]));
                for (int j = 0; j < n; j++) {
                    System.out.print(intervals[j][3] == 0 ? "C" : "J");
                }
                System.out.println();
            }
        }
    }
}