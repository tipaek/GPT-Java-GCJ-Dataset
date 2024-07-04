import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            List<TimeInterval> timeIntervals = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                timeIntervals.add(new TimeInterval(start, end));
            }

            Collections.sort(timeIntervals, Comparator.comparing(TimeInterval::getStart));

            int cameronEnd = -1;
            int jamieEnd = -1;
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;

            for (TimeInterval interval : timeIntervals) {
                int start = interval.getStart();
                int end = interval.getEnd();

                if (cameronEnd <= start) {
                    cameronEnd = end;
                    schedule.append('C');
                } else if (jamieEnd <= start) {
                    jamieEnd = end;
                    schedule.append('J');
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                schedule = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + (i + 1) + ": " + schedule);
        }
    }
}

class TimeInterval {
    private final int start;
    private final int end;

    public TimeInterval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}