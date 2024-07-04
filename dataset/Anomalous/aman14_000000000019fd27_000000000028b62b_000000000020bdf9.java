import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int t1 = 1; t1 <= t; t1++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }

            StringBuilder schedule = new StringBuilder("C");
            boolean possible = true;

            for (int i = 1; i < n; i++) {
                int overlaps = 0;
                char currentChar = 'J';
                char previousChar = 'J';

                for (int j = 0; j < i; j++) {
                    if ((intervals[i][0] > intervals[j][0] && intervals[i][0] < intervals[j][1]) ||
                        (intervals[i][1] > intervals[j][0] && intervals[i][1] < intervals[j][1]) ||
                        (intervals[j][0] > intervals[i][0] && intervals[j][0] < intervals[i][1]) ||
                        (intervals[j][1] > intervals[i][0] && intervals[j][1] < intervals[i][1])) {

                        overlaps++;
                        currentChar = schedule.charAt(j);
                    }

                    if (overlaps == 2) {
                        possible = false;
                        break;
                    }
                    previousChar = currentChar;
                }

                if (!possible) {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }

                if (overlaps == 1) {
                    schedule.append(currentChar == 'J' ? 'C' : 'J');
                } else {
                    schedule.append('C');
                }
            }

            System.out.println("Case #" + t1 + ": " + schedule.toString());
        }
        sc.close();
    }
}