import java.util.Scanner;

public class Solution {
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

            // Sorting intervals based on start time
            for (int i = 1; i < n; i++) {
                for (int j = i; j > 0 && intervals[j][0] < intervals[j - 1][0]; j--) {
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j - 1];
                    intervals[j - 1] = temp;
                }
            }

            int endC = -1;
            int endJ = -1;
            StringBuilder schedule = new StringBuilder();

            for (int i = 0; i < n; i++) {
                if (endC <= intervals[i][0]) {
                    endC = intervals[i][1];
                    schedule.append("C");
                } else if (endJ <= intervals[i][0]) {
                    endJ = intervals[i][1];
                    schedule.append("J");
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + schedule.toString());
        }

        scanner.close();
    }
}