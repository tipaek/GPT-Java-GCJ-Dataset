import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        List<Case> cases = new ArrayList<>(t);
        Solution solution = new Solution();

        while (t-- > 0) {
            int n = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(solution.new Interval(start, end));
            }

            if (!intervals.isEmpty()) {
                cases.add(solution.new Case(intervals));
            }
        }
        scanner.close();

        for (int i = 0; i < cases.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + calculateResult(cases.get(i)));
        }
    }

    public class Case {
        private List<Interval> intervals;

        public Case(List<Interval> intervals) {
            this.intervals = intervals;
        }

        public List<Interval> getIntervals() {
            return intervals;
        }
    }

    public class Interval {
        private String person;
        private int start;
        private int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String getPerson() {
            return person;
        }

        public void setPerson(String person) {
            this.person = person;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    private static String calculateResult(Case aCase) {
        List<String> users = List.of("C", "J");
        List<Interval> intervals = aCase.getIntervals();
        String currentUser = users.get(0);

        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);

            if (i == 0) {
                interval.setPerson(currentUser);
            } else {
                List<Interval> userIntervals = getIntervalsForUser(intervals, currentUser);
                if (!isIntervalValid(interval.getStart(), interval.getEnd(), userIntervals)) {
                    currentUser = currentUser.equals("J") ? "C" : "J";
                    userIntervals = getIntervalsForUser(intervals, currentUser);
                    if (!isIntervalValid(interval.getStart(), interval.getEnd(), userIntervals)) {
                        return "IMPOSSIBLE";
                    } else {
                        interval.setPerson(currentUser);
                    }
                } else {
                    interval.setPerson(currentUser);
                }
            }
        }
        return intervals.stream().map(Interval::getPerson).collect(Collectors.joining());
    }

    private static List<Interval> getIntervalsForUser(List<Interval> intervals, String user) {
        return intervals.stream().filter(interval -> user.equals(interval.getPerson())).collect(Collectors.toList());
    }

    private static boolean isIntervalValid(int start, int end, List<Interval> intervals) {
        for (Interval interval : intervals) {
            if (isOverlapping(interval.getStart(), interval.getEnd(), start, end)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOverlapping(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && end1 > start2);
    }
}