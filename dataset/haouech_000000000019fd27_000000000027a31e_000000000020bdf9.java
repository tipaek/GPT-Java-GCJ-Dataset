import java.util.*;

class Solution {
    private static Scanner scanner = new Scanner(System.in);
    public static final boolean C = true;
    public static final boolean J = false;

    public static void main(String argv[]) {
        int t = scanner.nextInt();
        for (int tc=1; tc <= t; tc++) {
            int N = scanner.nextInt();
            List<Interval> activities = new ArrayList<>(N);
            for (int i=0; i<N; i++) {
                int s = scanner.nextInt();
                int e = scanner.nextInt();
                activities.add(new Interval(i, s, e));
            }

            String result;
            try {
                result = solve(activities).toString();
            } catch (AssignmentException e) {
                result = "IMPOSSIBLE";
            }
            System.out.println("Case #" + tc + ": " + result);
        }
    }

    private static Result solve(List<Interval> activities) {
        Collections.sort(activities);
        int endC = 0, endJ = 0;
        for (Interval interval: activities) {
            if (endC <= interval.start) {
                interval.assignee = C;
                endC = interval.end;
            } else if (endJ <= interval.start) {
                interval.assignee = J;
                endJ = interval.end;
            } else {
                throw new AssignmentException();
            }
        }

        return new Result(activities);
    }
}

class Interval implements Comparable<Interval> {

    int start, end;
    int id;
    boolean assignee = false;

    public Interval(int id, int s, int e) {
        this.id = id;
        this.start = s;
        this.end = e;
    }
    @Override
    public int compareTo(Interval o) {
        return start - o.start;
    }

    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}

class Result {
    List<Interval> intervals;

    public Result(List<Interval> intervals) {
        this.intervals = intervals;
    }

    public String toString() {
        char arr[] = new char[intervals.size()];

        for (Interval interval: intervals) {
            if (interval.assignee == Solution.C) {
                arr[interval.id] = 'C';
            } else {
                arr[interval.id] = 'J';
            }
        }
        return String.valueOf(arr);
    }
}

class AssignmentException extends RuntimeException {}