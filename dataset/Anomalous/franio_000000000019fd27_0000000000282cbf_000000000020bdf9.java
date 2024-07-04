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
        } catch (RuntimeException e) {
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

    public boolean overlapsWith(Period other) {
        return (this.start < other.end && this.end > other.start) ||
               (other.start < this.end && other.end > this.start);
    }
}

class Day {
    private final StringBuilder answer = new StringBuilder();
    private final List<Period> cPeriods = new LinkedList<>();
    private final List<Period> jPeriods = new LinkedList<>();

    public boolean add(Period period) {
        if (cPeriods.stream().noneMatch(p -> p.overlapsWith(period))) {
            cPeriods.add(period);
            answer.append("C");
            return true;
        } else if (jPeriods.stream().noneMatch(p -> p.overlapsWith(period))) {
            jPeriods.add(period);
            answer.append("J");
            return true;
        }
        return false;
    }

    public String getAnswer() {
        return answer.toString();
    }
}