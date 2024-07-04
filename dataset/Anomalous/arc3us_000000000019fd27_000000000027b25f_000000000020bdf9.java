import java.util.*;

public class Solution {
    
    public static void sortByTime(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
    }

    public static void sortByIndex(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[3], b[3]));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][4];

            for (int i = 0; i < n; i++) {
                intervals[i][3] = i;
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                intervals[i][2] = 0; // Initialize the assignment
            }

            sortByTime(intervals);
            boolean impossible = false;
            int cEnd = intervals[0][1];
            int jEnd = 0;
            StringBuilder schedule = new StringBuilder();

            for (int i = 1; i < n; i++) {
                if (intervals[i][0] >= cEnd && intervals[i][0] >= jEnd) {
                    cEnd = intervals[i][1];
                } else if (intervals[i][0] >= jEnd) {
                    intervals[i][2] = 1; // Assign to J
                    jEnd = intervals[i][1];
                } else if (intervals[i][0] >= cEnd) {
                    intervals[i][2] = 0; // Assign to C
                    cEnd = intervals[i][1];
                } else {
                    impossible = true;
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                    break;
                }
            }

            if (!impossible) {
                sortByIndex(intervals);
                for (int i = 0; i < n; i++) {
                    schedule.append(intervals[i][2] == 0 ? 'C' : 'J');
                }
                System.out.println("Case #" + caseNumber + ": " + schedule.toString());
            }

            caseNumber++;
        }

        scanner.close();
    }
}