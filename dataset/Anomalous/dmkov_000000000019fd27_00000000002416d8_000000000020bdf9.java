import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int k = scanner.nextInt();
            int[][] intervals = new int[2 * k][3];
            char[] schedule = new char[k];

            for (int index = 0; index < 2 * k; index += 2) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[index] = new int[]{index / 2, start, 0};
                intervals[index + 1] = new int[]{index / 2, end, 1};
            }

            Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

            int activeIntervals = 0;
            boolean isPossible = true;

            for (int[] interval : intervals) {
                if (interval[2] == 0) {
                    activeIntervals++;
                    if (activeIntervals == 1) {
                        schedule[interval[0]] = 'C';
                    } else if (activeIntervals == 2) {
                        schedule[interval[0]] = 'J';
                    } else {
                        isPossible = false;
                        break;
                    }
                } else {
                    activeIntervals--;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + new String(schedule));
            }
        }
    }
}