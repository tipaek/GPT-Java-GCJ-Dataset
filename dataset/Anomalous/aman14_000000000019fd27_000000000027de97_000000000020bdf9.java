import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int testCaseNumber = 0;

        while (t-- > 0) {
            testCaseNumber++;
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }

            StringBuilder out = new StringBuilder("C");
            boolean isPossible = true;

            for (int i = 1; i < n && isPossible; i++) {
                char currentChar = 'C';
                char previousChar = 'J';
                int overlapCount = 0;

                for (int j = 0; j < i; j++) {
                    if (isOverlapping(intervals[i], intervals[j])) {
                        overlapCount++;
                        currentChar = out.charAt(j);
                    }

                    if (overlapCount >= 2 && currentChar != previousChar) {
                        isPossible = false;
                        break;
                    }

                    previousChar = currentChar;
                }

                if (!isPossible) {
                    out = new StringBuilder("IMPOSSIBLE");
                    break;
                }

                if (overlapCount >= 1) {
                    out.append(currentChar == 'J' ? 'C' : 'J');
                } else {
                    out.append('C');
                }
            }

            System.out.println("Case #" + testCaseNumber + ": " + out.toString());
        }

        sc.close();
    }

    private static boolean isOverlapping(int[] interval1, int[] interval2) {
        return (interval1[0] < interval2[1] && interval1[1] > interval2[0]);
    }
}