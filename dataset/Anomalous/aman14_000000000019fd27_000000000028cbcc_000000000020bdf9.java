import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }

            StringBuilder schedule = new StringBuilder("C");
            boolean isPossible = true;

            for (int i = 1; i < n; i++) {
                int overlaps = 0;
                char currentChar = 'J';
                char previousChar = 'J';

                for (int j = 0; j < i; j++) {
                    if (isOverlapping(intervals[i], intervals[j])) {
                        overlaps++;
                        currentChar = schedule.charAt(j);
                    }

                    if (overlaps >= 2 && currentChar != previousChar) {
                        overlaps = -1;
                        break;
                    }

                    previousChar = currentChar;
                }

                if (overlaps == -1) {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }

                if (overlaps >= 1) {
                    schedule.append(currentChar == 'J' ? 'C' : 'J');
                } else {
                    schedule.append('C');
                }
            }

            System.out.println("Case #" + caseNumber + ": " + schedule);
            caseNumber++;
        }
    }

    private static boolean isOverlapping(int[] interval1, int[] interval2) {
        return (interval1[0] < interval2[1] && interval1[1] > interval2[0]);
    }
}