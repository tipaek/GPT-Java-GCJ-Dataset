import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                intervals[i] = new Interval(scanner.nextInt(), scanner.nextInt(), i);
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a.end));
            StringBuilder result = new StringBuilder();
            intervals[0].assignee = 'C';
            int firstOverlapIdx = 1;

            for (int i = 1; i < n; i++) {
                if (intervals[i].start < intervals[i - 1].end) {
                    firstOverlapIdx = i;
                    intervals[i].assignee = 'J';
                    break;
                } else {
                    intervals[i].assignee = intervals[i - 1].assignee;
                }
            }

            for (int i = firstOverlapIdx + 1; i < n; i++) {
                Interval current = intervals[i];
                Set<Character> availableAssignees = new HashSet<>(Arrays.asList('C', 'J'));

                for (int j = i - 1; j >= 0; j--) {
                    if (availableAssignees.isEmpty()) {
                        break;
                    }

                    if (intervals[j].end <= current.start) {
                        current.assignee = intervals[j].assignee;
                        break;
                    } else {
                        availableAssignees.remove(intervals[j].assignee);
                    }
                }

                if (current.assignee == 'x') {
                    result.append("IMPOSSIBLE");
                    break;
                }
            }

            if (result.toString().equals("IMPOSSIBLE")) {
                System.out.println("Case #" + caseNumber++ + ": " + result);
                continue;
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a.originalIdx));
            for (Interval interval : intervals) {
                result.append(interval.assignee);
            }
            System.out.println("Case #" + caseNumber++ + ": " + result);
        }
    }
}

class Interval {
    int start;
    int end;
    int originalIdx;
    char assignee = 'x';

    public Interval(int start, int end, int originalIdx) {
        this.start = start;
        this.end = end;
        this.originalIdx = originalIdx;
    }
}