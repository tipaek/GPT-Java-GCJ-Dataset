import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<CaseModel> caseModels = new ArrayList<>(testCases);
        Solution solution = new Solution();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>(n);

            for (int j = 0; j < n; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                intervals.add(solution.new Interval("", startTime, endTime));
            }

            if (!intervals.isEmpty()) {
                caseModels.add(solution.new CaseModel(intervals));
            }
        }
        scanner.close();

        for (int i = 0; i < caseModels.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + calculateResult(caseModels.get(i)));
        }
    }

    public class CaseModel {
        private List<Interval> intervals;

        public CaseModel(List<Interval> intervals) {
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

    private static String calculateResult(CaseModel caseModel) {
        List<Interval> intervals = caseModel.getIntervals();
        String[] users = {"C", "J"};
        String currentUser = users[0];

        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (i == 0) {
                interval.setPerson(currentUser);
            } else {
                List<Interval> currentUserIntervals = getUserIntervals(intervals, currentUser);
                if (!isTimeSlotAvailable(interval.getStartTime(), interval.getEndTime(), currentUserIntervals)) {
                    currentUser = currentUser.equals("J") ? "C" : "J";
                    currentUserIntervals = getUserIntervals(intervals, currentUser);
                    if (!isTimeSlotAvailable(interval.getStartTime(), interval.getEndTime(), currentUserIntervals)) {
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

    private static List<Interval> getUserIntervals(List<Interval> intervals, String user) {
        return intervals.stream().filter(interval -> interval.getPerson().equals(user)).collect(Collectors.toList());
    }

    private static boolean isTimeSlotAvailable(int startTime, int endTime, List<Interval> userIntervals) {
        for (Interval interval : userIntervals) {
            if (isOverlapping(startTime, endTime, interval.getStartTime(), interval.getEndTime())) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOverlapping(int startTime, int endTime, int intervalStartTime, int intervalEndTime) {
        return (startTime < intervalEndTime && endTime > intervalStartTime);
    }
}