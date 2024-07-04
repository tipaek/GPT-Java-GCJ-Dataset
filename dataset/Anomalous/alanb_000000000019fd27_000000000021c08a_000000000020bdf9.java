import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][3];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                intervals[i][2] = i;
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            int endC = 0, endJ = 0;
            boolean isImpossible = false;
            char[] result = new char[n];

            for (int[] interval : intervals) {
                if (interval[0] >= endC) {
                    endC = interval[1];
                    result[interval[2]] = 'C';
                } else if (interval[0] >= endJ) {
                    endJ = interval[1];
                    result[interval[2]] = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + caseIndex + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseIndex + ": " + new String(result));
            }
        }

        scanner.close();
    }
}