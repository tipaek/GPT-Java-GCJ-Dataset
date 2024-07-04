import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            StringBuilder result = new StringBuilder();
            result.append('J');

            boolean possible = true;
            for (int i = 1; i < n; i++) {
                boolean overlapFound = false;
                char currentChar = 'J';

                for (int j = 0; j < i; j++) {
                    if (isOverlapping(intervals[i], intervals[j])) {
                        overlapFound = true;
                        currentChar = result.charAt(j);
                        break;
                    }
                }

                if (overlapFound) {
                    if (currentChar == 'J') {
                        result.append('C');
                    } else {
                        result.append('J');
                    }
                } else {
                    result.append('C');
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (isOverlapping(intervals[i], intervals[j]) && result.charAt(i) == result.charAt(j)) {
                        possible = false;
                        break;
                    }
                }
                if (!possible) break;
            }

            if (!possible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + result.toString());
            }

            caseNumber++;
        }
    }

    private static boolean isOverlapping(int[] interval1, int[] interval2) {
        return (interval1[0] < interval2[1] && interval1[1] > interval2[0]);
    }
}