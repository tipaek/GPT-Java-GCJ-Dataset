import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            List<TimeInterval> intervals = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new TimeInterval(start, end, j));
            }

            intervals.sort(Comparator.comparingInt(TimeInterval::getStart));

            int cameronEnd = 0;
            int jamieEnd = 0;
            char[] schedule = new char[n];
            boolean possible = true;

            for (TimeInterval interval : intervals) {
                if (cameronEnd <= interval.getStart()) {
                    cameronEnd = interval.getEnd();
                    schedule[interval.getIndex()] = 'C';
                } else if (jamieEnd <= interval.getStart()) {
                    jamieEnd = interval.getEnd();
                    schedule[interval.getIndex()] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            String result = possible ? new String(schedule) : "IMPOSSIBLE";
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}

class TimeInterval {
    private final int start;
    private final int end;
    private final int index;

    public TimeInterval(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getIndex() {
        return index;
    }
}