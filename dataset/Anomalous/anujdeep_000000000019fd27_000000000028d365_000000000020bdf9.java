import java.util.*;
import java.io.*;

public class Solution {
    static class Interval {
        int start, end;
        
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[i] = new Interval(start, end);
            }

            StringBuilder result = new StringBuilder();
            boolean isPossible = true;
            int cameronEnd = 0, jamieEnd = 0;

            Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));

            for (Interval interval : intervals) {
                if (interval.start >= cameronEnd) {
                    result.append('C');
                    cameronEnd = interval.end;
                } else if (interval.start >= jamieEnd) {
                    result.append('J');
                    jamieEnd = interval.end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + t + ": " + result);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}