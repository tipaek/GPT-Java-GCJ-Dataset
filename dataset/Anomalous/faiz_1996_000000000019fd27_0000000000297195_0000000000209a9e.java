import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<Case> cases = new ArrayList<>(testCases);

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                if (isValidTime(startTime) && isValidTime(endTime)) {
                    intervals.add(new Interval(startTime, endTime));
                }
            }

            if (!intervals.isEmpty()) {
                cases.add(new Case(intervals));
            }
        }
        scanner.close();

        for (int i = 0; i < cases.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + calculateResult(cases.get(i)));
        }
    }

    private static boolean isValidTime(int time) {
        return time >= 0 && time <= 1440;
    }

    private static String calculateResult(Case testCase) {
        List<String> users = Arrays.asList("C", "J");
        List<Interval> intervals = testCase.getIntervals();
        String currentUser = users.get(0);

        for (Interval interval : intervals) {
            if (!assignUser(interval, currentUser, intervals)) {
                currentUser = toggleUser(currentUser, users);
                if (!assignUser(interval, currentUser, intervals)) {
                    return "IMPOSSIBLE";
                }
            }
        }

        return intervals.stream().map(Interval::getUser).collect(Collectors.joining());
    }

    private static boolean assignUser(Interval interval, String user, List<Interval> intervals) {
        List<Interval> userIntervals = intervals.stream()
                .filter(i -> user.equals(i.getUser()))
                .collect(Collectors.toList());

        if (userIntervals.stream().noneMatch(i -> overlaps(i, interval))) {
            interval.setUser(user);
            return true;
        }
        return false;
    }

    private static String toggleUser(String currentUser, List<String> users) {
        return currentUser.equals(users.get(0)) ? users.get(1) : users.get(0);
    }

    private static boolean overlaps(Interval i1, Interval i2) {
        return i1.getStartTime() < i2.getEndTime() && i2.getStartTime() < i1.getEndTime();
    }

    static class Case {
        private final List<Interval> intervals;

        public Case(List<Interval> intervals) {
            this.intervals = intervals;
        }

        public List<Interval> getIntervals() {
            return intervals;
        }
    }

    static class Interval {
        private final int startTime;
        private final int endTime;
        private String user;

        public Interval(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }
    }
}