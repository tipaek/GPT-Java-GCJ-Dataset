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
            int firstOverlapIndex = 1;

            for (int i = 1; i < n; i++) {
                if (intervals[i].start < intervals[i - 1].end) {
                    firstOverlapIndex = i;
                    intervals[i].assignee = 'J';
                    break;
                } else {
                    intervals[i].assignee = intervals[i - 1].assignee;
                }
            }

            for (int i = firstOverlapIndex + 1; i < n; i++) {
                Interval currentInterval = intervals[i];
                Set<Character> availableAssignees = new HashSet<>(Arrays.asList('J', 'C'));

                for (int j = i - 1; j >= 0; j--) {
                    if (intervals[j].end <= currentInterval.start) {
                        if (availableAssignees.isEmpty()) {
                            break;
                        }

                        currentInterval.assignee = intervals[j].assignee;
                        break;
                    } else {
                        availableAssignees.remove(intervals[j].assignee);
                    }
                }

                if (currentInterval.assignee == 'x') {
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