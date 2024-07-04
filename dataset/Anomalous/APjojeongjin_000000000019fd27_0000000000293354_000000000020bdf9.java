import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int activities = scanner.nextInt();
            int[][] intervals = new int[activities][2];
            int[] originalOrder = new int[activities];

            for (int i = 0; i < activities; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                originalOrder[i] = i;
            }

            // Sort intervals by start time
            for (int i = 0; i < activities; i++) {
                for (int j = i + 1; j < activities; j++) {
                    if (intervals[i][0] > intervals[j][0]) {
                        swap(intervals, i, j);
                        int temp = originalOrder[i];
                        originalOrder[i] = originalOrder[j];
                        originalOrder[j] = temp;
                    }
                }
            }

            StringBuilder schedule = new StringBuilder();
            int endJ = 0, endC = 0;
            boolean possible = true;

            for (int i = 0; i < activities; i++) {
                if (endJ <= intervals[i][0]) {
                    endJ = intervals[i][1];
                    schedule.append('J');
                } else if (endC <= intervals[i][0]) {
                    endC = intervals[i][1];
                    schedule.append('C');
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                char[] result = new char[activities];
                for (int i = 0; i < activities; i++) {
                    result[originalOrder[i]] = schedule.charAt(i);
                }
                System.out.println("Case #" + (t + 1) + ": " + new String(result));
            }
        }
    }

    private static void swap(int[][] arr, int i, int j) {
        int temp0 = arr[i][0];
        int temp1 = arr[i][1];
        arr[i][0] = arr[j][0];
        arr[i][1] = arr[j][1];
        arr[j][0] = temp0;
        arr[j][1] = temp1;
    }
}