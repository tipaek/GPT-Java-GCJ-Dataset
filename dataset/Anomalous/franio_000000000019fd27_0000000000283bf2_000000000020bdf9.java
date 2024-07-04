import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int periodCount = scanner.nextInt();
            Day day = new Day();
            boolean isPossible = true;

            for (int i = 0; i < periodCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if (isPossible) {
                    Period period = new Period(start, end, i + 1);
                    if (!day.addPeriod(period)) {
                        isPossible = false;
                    }
                }
            }

            printResult(t + 1, isPossible ? day.getAnswer() : "IMPOSSIBLE");
        }
        scanner.close();
    }

    private static void printResult(int caseNumber, String result) {
        System.out.println("Case #" + caseNumber + ": " + result);
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
        return (this.start < other.end && this.end > other.start);
    }
}

class Day {
    private StringBuilder answer;
    private List<Period> cPeriods;
    private List<Period> jPeriods;

    public Day() {
        this.answer = new StringBuilder();
        this.cPeriods = new ArrayList<>();
        this.jPeriods = new ArrayList<>();
    }

    public boolean addPeriod(Period period) {
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