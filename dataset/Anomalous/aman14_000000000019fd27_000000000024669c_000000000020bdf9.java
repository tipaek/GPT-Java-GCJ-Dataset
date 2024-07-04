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

            assignments[0] = 'J';
            boolean impossible = false;

            for (int i = 1; i < n; i++) {
                int overlapCount = 0;
                char lastConflict = '0';

                for (int j = 0; j < i; j++) {
                    boolean overlap = (intervals[i][0] < intervals[j][1] && intervals[i][1] > intervals[j][0]);
                    if (overlap) {
                        overlapCount++;
                        if (overlapCount == 1) {
                            lastConflict = assignments[j];
                        } else if (overlapCount >= 2 && assignments[j] != lastConflict) {
                            impossible = true;
                            break;
                        }
                    }
                }

                if (impossible) {
                    break;
                }

                if (overlapCount == 0) {
                    assignments[i] = assignments[i - 1];
                } else {
                    assignments[i] = (lastConflict == 'J') ? 'C' : 'J';
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNumber + " IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (char assignment : assignments) {
                    result.append(assignment);
                }
                System.out.println("Case #" + caseNumber + " " + result.toString());
            }

            caseNumber++;
        }
    }
}