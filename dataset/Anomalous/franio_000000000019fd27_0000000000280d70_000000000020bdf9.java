import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activitiesCount = scanner.nextInt();
            Day daySchedule = new Day();
            boolean isPossible = true;

            for (int i = 0; i < activitiesCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Period period = new Period(start, end, i + 1);
                if (!daySchedule.addPeriod(period)) {
                    isPossible = false;
                    break;
                }
            }

            printResult(t, isPossible ? daySchedule.getSchedule() : "IMPOSSIBLE");
        }
        scanner.close();
    }

    private static void printResult(int testCaseNumber, String result) {
        System.out.println("Case #" + testCaseNumber + ": " + result);
    }
}

class Period {
    int start;
    int end;
    int index;

    public Period(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    public boolean overlapsWith(Period other) {
        return (this.start < other.end && this.end > other.start);
    }
}

class Day {
    private StringBuilder schedule;
    private List<Period> cPeriods;
    private List<Period> jPeriods;

    public Day() {
        this.schedule = new StringBuilder();
        this.cPeriods = new LinkedList<>();
        this.jPeriods = new LinkedList<>();
    }

    public boolean addPeriod(Period period) {
        if (canAddPeriodTo(cPeriods, period)) {
            cPeriods.add(period);
            schedule.append("C");
            return true;
        }

        if (canAddPeriodTo(jPeriods, period)) {
            jPeriods.add(period);
            schedule.append("J");
            return true;
        }

        return false;
    }

    private boolean canAddPeriodTo(List<Period> periods, Period period) {
        return periods.stream().noneMatch(p -> p.overlapsWith(period));
    }

    public String getSchedule() {
        return schedule.toString();
    }
}