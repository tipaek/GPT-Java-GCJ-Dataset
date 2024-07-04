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

            StringBuilder output = new StringBuilder("C");
            boolean isPossible = true;

            for (int i = 1; i < n && isPossible; i++) {
                boolean overlap = false;
                char currentChar = 'C';

                for (int j = 0; j < i; j++) {
                    if (isOverlapping(intervals[i], intervals[j])) {
                        overlap = true;
                        currentChar = output.charAt(j);
                        break;
                    }
                }

                if (overlap) {
                    if (currentChar == 'C') {
                        output.append('J');
                    } else {
                        output.append('C');
                    }

                    for (int j = 0; j < i; j++) {
                        if (isOverlapping(intervals[i], intervals[j]) && output.charAt(j) == output.charAt(i)) {
                            isPossible = false;
                            break;
                        }
                    }
                } else {
                    output.append('C');
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + output.toString());
            }

            caseNumber++;
        }
    }

    private static boolean isOverlapping(int[] interval1, int[] interval2) {
        return (interval1[0] < interval2[1] && interval1[1] > interval2[0]);
    }
}