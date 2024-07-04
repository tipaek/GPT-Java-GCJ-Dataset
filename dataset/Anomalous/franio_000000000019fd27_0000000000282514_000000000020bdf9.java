import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int tests = scanner.nextInt();

            for (int t = 1; t <= tests; t++) {
                int N = scanner.nextInt();
                Day day = new Day();
                boolean isPossible = true;

                for (int i = 0; i < N; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    Period period = new Period(start, end, i + 1);
                    if (!day.add(period)) {
                        isPossible = false;
                        break;
                    }
                }

                printResult(t, isPossible ? day.getAnswer() : "IMPOSSIBLE");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printResult(int caseNumber, String result) {
        System.out.println("Case #" + caseNumber + ": " + result);
    }
}

class Period {
    private final int start;
    private final int end;
    private final int index;

    public Period(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    public boolean overlaps(Period other) {
        return this.start < other.end && this.end > other.start;
    }
}

class Day {
    private final StringBuilder answerBuilder = new StringBuilder();
    private final List<Period> cPeriods = new ArrayList<>();
    private final List<Period> jPeriods = new ArrayList<>();

    public boolean add(Period period) {
        if (canAddPeriod(cPeriods, period)) {
            cPeriods.add(period);
            answerBuilder.append('C');
            return true;
        }

        if (canAddPeriod(jPeriods, period)) {
            jPeriods.add(period);
            answerBuilder.append('J');
            return true;
        }

        return false;
    }

    private boolean canAddPeriod(List<Period> periods, Period newPeriod) {
        return periods.stream().noneMatch(existingPeriod -> existingPeriod.overlaps(newPeriod));
    }

    public String getAnswer() {
        return answerBuilder.toString();
    }
}