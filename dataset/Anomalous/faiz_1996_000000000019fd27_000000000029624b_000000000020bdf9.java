import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<Schedule> schedules = new ArrayList<>(testCases);
        Solution solution = new Solution();

        while (testCases-- > 0) {
            int numIntervals = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < numIntervals; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (isValidTime(startTime, endTime)) {
                    intervals.add(solution.new Interval("", startTime, endTime));
                }
            }

            if (!intervals.isEmpty()) {
                schedules.add(solution.new Schedule(intervals));
            }
        }
        scanner.close();

        for (int i = 0; i < schedules.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + calculateResult(schedules.get(i)));
        }
    }

    private static boolean isValidTime(int startTime, int endTime) {
        return startTime >= 0 && startTime <= 1440 && endTime >= 0 && endTime <= 1440;
    }

    public class Schedule {
        private List<Interval> intervals;

        public Schedule(List<Interval> intervals) {
            this.intervals = intervals;
        }

        public List<Interval> getIntervals() {
            return intervals;
        }
    }

    public class Interval {
        private String person;
        private int startTime;
        private int endTime;

        public Interval(String person, int startTime, int endTime) {
            this.person = person;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public String getPerson() {
            return person;
        }

        public void setPerson(String person) {
            this.person = person;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }
    }

    private static String calculateResult(Schedule schedule) {
        List<String> users = Arrays.asList("C", "J");
        List<Interval> intervals = schedule.getIntervals();
        String currentUser = users.get(0);

        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (i == 0) {
                interval.setPerson(currentUser);
            } else {
                List<Interval> userIntervals = getUserIntervals(intervals, currentUser);
                if (!isIntervalFeasible(interval, userIntervals)) {
                    currentUser = switchUser(currentUser);
                    userIntervals = getUserIntervals(intervals, currentUser);
                    if (!isIntervalFeasible(interval, userIntervals)) {
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

    private static String switchUser(String currentUser) {
        return currentUser.equals("J") ? "C" : "J";
    }

    private static List<Interval> getUserIntervals(List<Interval> intervals, String user) {
        return intervals.stream().filter(interval -> interval.getPerson().equals(user)).collect(Collectors.toList());
    }

    private static boolean isIntervalFeasible(Interval interval, List<Interval> userIntervals) {
        return userIntervals.stream().noneMatch(userInterval -> isOverlapping(interval, userInterval));
    }

    private static boolean isOverlapping(Interval interval1, Interval interval2) {
        return (interval1.getStartTime() < interval2.getEndTime() && interval1.getEndTime() > interval2.getStartTime());
    }
}