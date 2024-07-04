import java.util.*;

class Interval {
    int start;
    int end;
    int index;

    Interval(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

class Assignment {
    char person;
    int index;

    Assignment(char person, int index) {
        this.person = person;
        this.index = index;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[i] = new Interval(start, end, i);
            }

            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.start));

            List<Assignment> assignments = new ArrayList<>();
            int jEnd = -1;
            int cEnd = -1;
            boolean possible = true;

            for (Interval interval : intervals) {
                if (jEnd <= interval.start) {
                    jEnd = interval.end;
                    assignments.add(new Assignment('J', interval.index));
                } else if (cEnd <= interval.start) {
                    cEnd = interval.end;
                    assignments.add(new Assignment('C', interval.index));
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                assignments.sort(Comparator.comparingInt(a -> a.index));
                output.append("Case #").append(t).append(": ");
                for (Assignment assignment : assignments) {
                    output.append(assignment.person);
                }
                output.append("\n");
            } else {
                output.append("Case #").append(t).append(": IMPOSSIBLE\n");
            }
        }

        System.out.print(output);
    }
}