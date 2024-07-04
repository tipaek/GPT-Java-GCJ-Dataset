import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 0;

        while (testCases-- > 0) {
            caseNumber++;
            int n = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(start, 's', end));
                intervals.add(new Interval(end, 'e', start));
            }

            intervals.sort(Comparator.comparingInt(Interval::getTime));

            StringBuilder result = new StringBuilder();
            int cameronEnd = 0, jamieEnd = 0;

            for (Interval interval : intervals) {
                if (interval.getType() == 's') {
                    if (cameronEnd != 0 && jamieEnd != 0) {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    } else if (cameronEnd == 0) {
                        result.append("C");
                        cameronEnd = interval.getOther();
                    } else {
                        result.append("J");
                        jamieEnd = interval.getOther();
                    }
                } else {
                    if (interval.getTime() == cameronEnd) {
                        cameronEnd = 0;
                    } else {
                        jamieEnd = 0;
                    }
                }
            }
            System.out.println("Case #" + caseNumber + ": " + result);
        }

        scanner.close();
    }
}

class Interval {
    private final int time;
    private final char type;
    private final int other;

    public Interval(int time, char type, int other) {
        this.time = time;
        this.type = type;
        this.other = other;
    }

    public int getTime() {
        return time;
    }

    public char getType() {
        return type;
    }

    public int getOther() {
        return other;
    }
}