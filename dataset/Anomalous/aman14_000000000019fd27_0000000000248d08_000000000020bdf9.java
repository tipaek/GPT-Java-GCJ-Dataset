import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            char[] assignedChars = new char[n];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }

            assignedChars[0] = 'J';
            boolean impossible = false;

            for (int i = 1; i < n && !impossible; i++) {
                int overlapCount = 0;
                char lastOverlapChar = '0';
                char secondLastOverlapChar = '0';

                for (int j = 0; j < i; j++) {
                    if (hasOverlap(intervals[i], intervals[j])) {
                        overlapCount++;
                        lastOverlapChar = assignedChars[j];
                        if (overlapCount >= 2 && lastOverlapChar != secondLastOverlapChar) {
                            impossible = true;
                            break;
                        }
                        secondLastOverlapChar = lastOverlapChar;
                    }
                }

                if (impossible) {
                    break;
                }

                if (overlapCount > 0) {
                    assignedChars[i] = (lastOverlapChar == 'J') ? 'C' : 'J';
                } else {
                    assignedChars[i] = 'J';
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + caseNumber + ": ");
                for (char c : assignedChars) {
                    System.out.print(c);
                }
                System.out.println();
            }

            caseNumber++;
        }

        sc.close();
    }

    private static boolean hasOverlap(int[] interval1, int[] interval2) {
        return (interval1[0] < interval2[1] && interval1[1] > interval2[0]);
    }
}