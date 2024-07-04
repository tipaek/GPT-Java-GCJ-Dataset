import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCaseCount = scanner.nextInt();
        for (int i = 0; i < testCaseCount; i++) {
            int numIntervals = scanner.nextInt();
            Interval[] intervals = new Interval[numIntervals];
            Assignment[] assignments = new Assignment[numIntervals];
            System.out.print("Case #" + (i + 1) + ": ");
            
            for (int j = 0; j < numIntervals; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[j] = new Interval(start, end);
                assignments[j] = new Assignment(intervals[j]);
            }
            
            Arrays.sort(intervals);

            Stack<Interval> stackC = new Stack<>();
            Stack<Interval> stackJ = new Stack<>();
            boolean isImpossible = false;
            
            for (Interval interval : intervals) {
                if (stackC.isEmpty() || interval.start >= stackC.peek().end) {
                    stackC.push(interval);
                    interval.assignedTo = 'C';
                } else if (stackJ.isEmpty() || interval.start >= stackJ.peek().end) {
                    stackJ.push(interval);
                    interval.assignedTo = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
                continue;
            }
            
            for (int j = 0; j < numIntervals; j++) {
                System.out.print(assignments[j].interval.assignedTo);
            }
            System.out.println();
        }
        scanner.close();
    }
}

class Interval implements Comparable<Interval> {
    int start;
    int end;
    char assignedTo;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval other) {
        return Integer.compare(this.end, other.end);
    }
}

class Assignment {
    Interval interval;

    Assignment(Interval interval) {
        this.interval = interval;
    }
}