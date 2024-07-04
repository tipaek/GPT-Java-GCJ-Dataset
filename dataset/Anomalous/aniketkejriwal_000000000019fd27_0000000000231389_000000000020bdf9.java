import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            StringBuilder result = new StringBuilder();
            int cEnd = 0, jEnd = 0;

            for (int[] interval : intervals) {
                if (interval[0] >= cEnd) {
                    cEnd = interval[1];
                    result.append('C');
                } else if (interval[0] >= jEnd) {
                    jEnd = interval[1];
                    result.append('J');
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }

        scanner.close();
    }
}