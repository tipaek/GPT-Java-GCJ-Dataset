import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            int[][] intervals = new int[2000][2];

            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                int n = scanner.nextInt();
                boolean isImpossible = false;

                // Reset intervals
                for (int[] interval : intervals) {
                    interval[0] = 0;
                    interval[1] = 0;
                }

                // Read intervals
                for (int i = 1; i <= n; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();

                    for (int j = start; j < end; j++) {
                        if (intervals[j][0] == 0) {
                            intervals[j][0] = i;
                        } else if (intervals[j][1] == 0) {
                            intervals[j][1] = i;
                        } else {
                            isImpossible = true;
                            break;
                        }
                    }

                    if (isImpossible) {
                        break;
                    }
                }

                if (isImpossible) {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                } else {
                    char[] result = new char[2 * n];
                    int temp;

                    for (int i = 1; i < intervals.length; i++) {
                        if (intervals[i - 1][1] == intervals[i][0] && intervals[i][0] != 0) {
                            temp = intervals[i][0];
                            intervals[i][0] = intervals[i][1];
                            intervals[i][1] = temp;
                        } else if (intervals[i - 1][0] == intervals[i][1] && intervals[i][1] != 0) {
                            temp = intervals[i][1];
                            intervals[i][1] = intervals[i][0];
                            intervals[i][0] = temp;
                        }

                        if (intervals[i - 1][0] != intervals[i][0] && intervals[i - 1][0] != 0) {
                            result[intervals[i - 1][0] - 1] = 'C';
                        }
                        if (intervals[i - 1][1] != intervals[i][1] && intervals[i - 1][1] != 0) {
                            result[intervals[i - 1][1] - 1] = 'J';
                        }
                    }

                    System.out.println("Case #" + caseNumber + ": " + String.valueOf(result).trim());
                }
            }
        }
    }
}