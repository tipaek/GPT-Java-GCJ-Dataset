import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int N = scanner.nextInt();
            Day day = new Day();
            boolean isPossible = true;
            for (int i = 0; i < N; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if (isPossible) {
                    Period period = new Period(start, end, i + 1);
                    if (!day.addPeriod(period)) {
                        isPossible = false;
                    }
                }
            }

            printResult(t, isPossible ? day.getAnswer() : "IMPOSSIBLE");
        }
        scanner.close();
    }

    private static void printResult(int testCase, String result) {
        System.out.println("Case #" + testCase + ": " + result);
    }
}

class Period {
    private int start;
    private int end;
    private int index;

    public Period(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    public boolean overlapsWith(Period other) {
        return (this.start < other.end && other.start < this.end);
    }
}

class Day {
    private StringBuilder answer = new StringBuilder();
    private List<Period> cPeriods = new ArrayList<>();
    private List<Period> jPeriods = new ArrayList<>();

    public boolean addPeriod(Period period) {
        if (canAddToPeriods(cPeriods, period)) {
            cPeriods.add(period);
            answer.append("C");
            return true;
        } else if (canAddToPeriods(jPeriods, period)) {
            jPeriods.add(period);
            answer.append("J");
            return true;
        }
        return false;
    }

    private boolean canAddToPeriods(List<Period> periods, Period period) {
        for (Period existingPeriod : periods) {
            if (existingPeriod.overlapsWith(period)) {
                return false;
            }
        }
        return true;
    }

    public String getAnswer() {
        return answer.toString();
    }
}