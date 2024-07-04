import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            Interval[] intervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                intervals[i] = new Interval(sc.nextInt(), sc.nextInt(), i);
            }

            Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
            StringBuilder result = new StringBuilder();
            List<Interval> jTasks = new ArrayList<>();
            List<Interval> cTasks = new ArrayList<>();

            boolean isPossible = true;

            for (Interval interval : intervals) {
                if (jTasks.isEmpty() || jTasks.get(jTasks.size() - 1).end <= interval.start) {
                    jTasks.add(interval);
                    interval.assignee = 'J';
                } else if (cTasks.isEmpty() || cTasks.get(cTasks.size() - 1).end <= interval.start) {
                    cTasks.add(interval);
                    interval.assignee = 'C';
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + caseNumber++ + ": IMPOSSIBLE");
                continue;
            }

            Arrays.sort(intervals, (a, b) -> Integer.compare(a.originalIdx, b.originalIdx));

            for (Interval interval : intervals) {
                result.append(interval.assignee);
            }

            System.out.println("Case #" + caseNumber++ + ": " + result.toString());
        }
    }
}

class Interval {
    int start;
    int end;
    int originalIdx;
    char assignee;

    public Interval(int start, int end, int originalIdx) {
        this.start = start;
        this.end = end;
        this.originalIdx = originalIdx;
        this.assignee = 'x';
    }
}