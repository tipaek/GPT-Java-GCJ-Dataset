import java.util.Arrays;
import java.util.Scanner;

class Triple {
    int start;
    int end;
    int index;

    public Triple(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Triple[] intervals = new Triple[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[i] = new Triple(start, end, i);
            }

            Arrays.sort(intervals, (a, b) -> {
                if (a.start != b.start) {
                    return Integer.compare(a.start, b.start);
                } else {
                    return Integer.compare(a.end, b.end);
                }
            });

            char[] result = new char[n];
            boolean isPossible = true;
            int cEnd = 0, jEnd = 0;

            for (Triple interval : intervals) {
                if (interval.start >= cEnd) {
                    result[interval.index] = 'C';
                    cEnd = interval.end;
                } else if (interval.start >= jEnd) {
                    result[interval.index] = 'J';
                    jEnd = interval.end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + t + ": " + new String(result));
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}