import java.util.*;

public class Solution {

    public static void sortTime(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
    }

    public static void sortImportance(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[3]));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][4];

            for (int i = 0; i < n; i++) {
                intervals[i][3] = i;
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                intervals[i][2] = 0;
            }

            sortTime(intervals);

            boolean impossible = false;
            int cameronEnd = intervals[0][1];
            int jamieEnd = 0;
            StringBuilder schedule = new StringBuilder();

            for (int i = 1; i < n; i++) {
                if (intervals[i][0] < cameronEnd && intervals[i][0] >= jamieEnd) {
                    intervals[i][2] = 1;
                    jamieEnd = intervals[i][1];
                } else if (intervals[i][0] < jamieEnd && intervals[i][0] >= cameronEnd) {
                    intervals[i][2] = 0;
                    cameronEnd = intervals[i][1];
                } else if (intervals[i][0] < cameronEnd && intervals[i][0] < jamieEnd) {
                    impossible = true;
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                    break;
                } else {
                    cameronEnd = intervals[i][0];
                }
            }

            sortImportance(intervals);

            if (!impossible) {
                for (int i = 0; i < n; i++) {
                    schedule.append(intervals[i][2] == 0 ? "C" : "J");
                }
                System.out.println("Case #" + caseNumber + ": " + schedule);
            }

            caseNumber++;
        }
        scanner.close();
    }
}