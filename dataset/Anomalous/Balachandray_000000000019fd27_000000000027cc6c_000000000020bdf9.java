import java.util.*;

public class Solution {

    public static void sortByColumn(int[][] arr, int col) {
        Arrays.sort(arr, (entry1, entry2) -> Integer.compare(entry1[col], entry2[col]));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            sortByColumn(intervals, 0);
            System.out.print("Case #" + (t + 1) + ": ");

            boolean possible = true;
            StringBuilder schedule = new StringBuilder();
            int endC = 0;
            int endJ = 0;

            for (int[] interval : intervals) {
                if (endC <= interval[0]) {
                    schedule.append("C");
                    endC = interval[1];
                } else if (endJ <= interval[0]) {
                    schedule.append("J");
                    endJ = interval[1];
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println(schedule);
        }

        scanner.close();
    }
}