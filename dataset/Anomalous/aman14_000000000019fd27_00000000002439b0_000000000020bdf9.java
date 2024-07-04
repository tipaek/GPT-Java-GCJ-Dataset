import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            char[] assignments = new char[n];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }

            assignments[0] = 'C';
            boolean isImpossible = false;

            for (int i = 1; i < n && !isImpossible; i++) {
                char lastAssignedChar = ' ';
                int overlapCount = 0;

                for (int j = 0; j < i; j++) {
                    if (isOverlapping(intervals[i], intervals[j])) {
                        overlapCount++;
                        if (overlapCount == 1) {
                            lastAssignedChar = assignments[j];
                        } else if (overlapCount >= 2 && lastAssignedChar != assignments[j]) {
                            isImpossible = true;
                            break;
                        }
                    }
                }

                if (isImpossible) {
                    break;
                }

                if (overlapCount == 0) {
                    assignments[i] = assignments[i - 1];
                } else {
                    assignments[i] = (lastAssignedChar == 'C') ? 'J' : 'C';
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + caseNumber + ": ");
                for (char assignment : assignments) {
                    System.out.print(assignment);
                }
                System.out.println();
            }

            caseNumber++;
        }
        sc.close();
    }

    private static boolean isOverlapping(int[] interval1, int[] interval2) {
        return (interval1[0] < interval2[1] && interval1[1] > interval2[0]);
    }
}