import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int t1 = 1; t1 <= t; t1++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            StringBuilder schedule = new StringBuilder("J");
            boolean impossible = false;

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
                    impossible = true;
                    break;
                }

                if (overlaps >= 1) {
                    schedule.append(currentChar == 'J' ? 'C' : 'J');
                } else {
                    schedule.append(schedule.charAt(i - 1));
                }
            }

            System.out.println("Case #" + t1 + ": " + schedule.toString());
        }
    }

    private static boolean isOverlapping(int[] interval1, int[] interval2) {
        return (interval1[0] < interval2[1] && interval1[1] > interval2[0]);
    }
}