import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int intervalCount = scanner.nextInt();
            Interval[] intervals = new Interval[intervalCount];

            for (int j = 0; j < intervalCount; j++) {
                intervals[j] = new Interval(scanner.nextInt(), scanner.nextInt(), j);
            }
            
            Arrays.sort(intervals);
            boolean[] assignments = new boolean[intervalCount];
            boolean currentAssignment = false;
            int lastEnd = 0;
            boolean impossible = false;
            
            assignments[intervals[0].position] = currentAssignment;
            
            for (int j = 1; j < intervalCount; j++) {
                if (intervals[j].start >= intervals[j - 1].end) {
                    assignments[intervals[j].position] = currentAssignment;
                } else {
                    if (intervals[j].start < lastEnd) {
                        System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                        impossible = true;
                        break;
                    } else {
                        currentAssignment = !currentAssignment;
                        assignments[intervals[j].position] = currentAssignment;
                        lastEnd = intervals[j - 1].end;
                    }
                }
            }
            
            if (impossible) {
                continue;
            }
            
            StringBuilder result = new StringBuilder(intervalCount);
            for (boolean assignment : assignments) {
                result.append(assignment ? "J" : "C");
            }
            
            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }

    static class Interval implements Comparable<Interval> {
        int start;
        int end;
        int position;

        Interval(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }

        @Override
        public int compareTo(Interval other) {
            return Integer.compare(this.start, other.start);
        }
    }
}