import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int t1 = 1; t1 <= t; t1++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            char[] assignments = new char[n];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }

            assignments[0] = 'C';
            boolean possible = true;

            for (int i = 1; i < n && possible; i++) {
                int overlaps = 0;
                char lastAssigned = '0';

                for (int j = 0; j < i; j++) {
                    if ((intervals[i][0] < intervals[j][1] && intervals[i][1] > intervals[j][0])) {
                        overlaps++;
                        lastAssigned = assignments[j];
                        if (overlaps == 2) {
                            possible = false;
                            break;
                        }
                    }
                }

                if (overlaps == 1) {
                    assignments[i] = (lastAssigned == 'J') ? 'C' : 'J';
                } else if (overlaps == 0) {
                    assignments[i] = 'C';
                }
            }

            String result = possible ? new String(assignments) : "IMPOSSIBLE";
            System.out.println("Case #" + t1 + ": " + result);
        }

        sc.close();
    }
}