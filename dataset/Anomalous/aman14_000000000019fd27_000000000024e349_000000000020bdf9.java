import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            char[] schedule = new char[n];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }

            schedule[0] = 'J';
            boolean impossible = false;

            for (int i = 1; i < n; i++) {
                int overlapCount = 0;
                char lastOverlapChar = '0';

                for (int j = 0; j < i; j++) {
                    if (isOverlapping(intervals[i], intervals[j])) {
                        overlapCount++;
                        lastOverlapChar = schedule[j];
                    }

                    if (overlapCount > 1) {
                        impossible = true;
                        break;
                    }
                }

                if (impossible) {
                    break;
                }

                schedule[i] = (overlapCount == 1 && lastOverlapChar == 'J') ? 'C' : 'J';
            }

            System.out.print("Case #" + caseNumber + " ");
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(new String(schedule));
            }

            caseNumber++;
        }
    }

    private static boolean isOverlapping(int[] interval1, int[] interval2) {
        return (interval1[0] < interval2[1] && interval1[1] > interval2[0]);
    }
}